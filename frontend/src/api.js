const API_BASE_URL = (import.meta.env.VITE_API_URL || 'http://localhost:8080').replace(/\/$/, '');

async function request(path, options) {
  const res = await fetch(`${API_BASE_URL}${path}`, {
    headers: {
      'Content-Type': 'application/json',
      ...(options?.headers || {}),
    },
    ...options,
  });

  const contentType = res.headers.get('content-type') || '';
  const isJson = contentType.includes('application/json');

  if (!res.ok) {
    const body = isJson ? await res.json().catch(() => null) : await res.text().catch(() => '');
    const message = body?.message || body?.error || (typeof body === 'string' ? body : '') || `HTTP ${res.status}`;
    const err = new Error(message);
    err.status = res.status;
    err.body = body;
    throw err;
  }

  if (res.status === 204) return null;
  return isJson ? res.json() : res.text();
}

export function listTickets({ page = 0, size = 20, status, priority, category } = {}) {
  const params = new URLSearchParams({ page: String(page), size: String(size) });
  if (status) params.set('status', status);
  if (priority) params.set('priority', priority);
  if (category) params.set('category', category);
  return request(`/tickets?${params.toString()}`);
}

export function getTicket(id) {
  return request(`/tickets/${id}`);
}

export function createTicket(payload) {
  return request('/tickets', { method: 'POST', body: JSON.stringify(payload) });
}

export function updateTicket(id, payload) {
  return request(`/tickets/${id}`, { method: 'PUT', body: JSON.stringify(payload) });
}

export function changeTicketStatus(id, status) {
  return request(`/tickets/${id}/status`, { method: 'PATCH', body: JSON.stringify({ status }) });
}

export function listComments(ticketId) {
  return request(`/tickets/${ticketId}/comments`);
}

export function addComment(ticketId, message) {
  return request(`/tickets/${ticketId}/comments`, { method: 'POST', body: JSON.stringify({ message }) });
}

export const enums = {
  status: ['OPEN', 'IN_PROGRESS', 'IN_REVIEW', 'DONE'],
  priority: ['LOW', 'MEDIUM', 'HIGH'],
  category: ['BUG', 'FEATURE', 'SUPPORT'],
};

export function formatDate(isoString) {
  if (!isoString) return '';
  const d = new Date(isoString);
  if (Number.isNaN(d.getTime())) return String(isoString);
  return d.toLocaleString();
}
