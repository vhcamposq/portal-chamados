import { useCallback, useEffect, useMemo, useState } from 'react';
import './App.css';
import { createTicket, getTicket, listTickets, updateTicket } from './api';
import TicketDetails from './components/TicketDetails';
import TicketForm from './components/TicketForm';
import TicketList from './components/TicketList';

function App() {
  const [filters, setFilters] = useState({ status: '', priority: '', category: '' });
  const [page, setPage] = useState(0);

  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const [view, setView] = useState('list');
  const [selectedId, setSelectedId] = useState(null);
  const [selectedTicket, setSelectedTicket] = useState(null);
  const [loadingTicket, setLoadingTicket] = useState(false);
  const [ticketError, setTicketError] = useState('');

  const title = useMemo(() => {
    if (view === 'create') return 'Novo ticket';
    if (view === 'edit') return `Editar ticket #${selectedId}`;
    if (view === 'details') return `Ticket #${selectedId}`;
    return 'Portal de Chamados';
  }, [view, selectedId]);

  const load = useCallback(async () => {
    setError('');
    setLoading(true);
    try {
      const result = await listTickets({ page, size: 20, ...filters });
      setData(result);
    } catch (err) {
      setError(err?.message || 'Erro ao carregar tickets');
    } finally {
      setLoading(false);
    }
  }, [filters, page]);

  useEffect(() => {
    if (view === 'list') load();
  }, [load, view]);

  const loadTicket = useCallback(async (id) => {
    setTicketError('');
    setLoadingTicket(true);
    try {
      const t = await getTicket(id);
      setSelectedTicket(t);
    } catch (err) {
      setTicketError(err?.message || 'Erro ao carregar ticket');
    } finally {
      setLoadingTicket(false);
    }
  }, []);

  async function openDetails(id) {
    setSelectedId(id);
    setView('details');
    await loadTicket(id);
  }

  function openCreate() {
    setSelectedId(null);
    setSelectedTicket(null);
    setView('create');
  }

  function openEdit() {
    setView('edit');
  }

  async function refreshSelected() {
    if (!selectedId) return;
    await loadTicket(selectedId);
  }

  async function handleCreate(payload) {
    const created = await createTicket(payload);
    setView('details');
    setSelectedId(created.id);
    setSelectedTicket(created);
  }

  async function handleUpdate(payload) {
    const updated = await updateTicket(selectedId, payload);
    setView('details');
    setSelectedTicket(updated);
  }

  const totalPages = data?.totalPages ?? 0;

  return (
    <div className="app">
      <header className="topbar">
        <div>
          <div className="brand">Portal de Chamados</div>
          <div className="muted">{title}</div>
        </div>
        <div className="muted small">
          API: {import.meta.env.VITE_API_URL || 'http://localhost:8080'}
        </div>
      </header>

      <main className="main">
        {view === 'list' ? (
          <>
            <TicketList
              data={data}
              loading={loading}
              error={error}
              filters={filters}
              onFiltersChange={(f) => {
                setPage(0);
                setFilters(f);
              }}
              onSelect={openDetails}
              onCreate={openCreate}
            />

            <div className="pager">
              <button className="btn btnGhost" disabled={page <= 0} onClick={() => setPage((p) => Math.max(0, p - 1))}>
                Anterior
              </button>
              <div className="muted">
                Página {page + 1} {totalPages ? `de ${totalPages}` : ''}
              </div>
              <button
                className="btn btnGhost"
                disabled={totalPages === 0 || page >= totalPages - 1}
                onClick={() => setPage((p) => p + 1)}
              >
                Próxima
              </button>
            </div>
          </>
        ) : null}

        {view === 'create' ? (
          <TicketForm submitLabel="Criar ticket" onCancel={() => setView('list')} onSubmit={handleCreate} />
        ) : null}

        {view === 'edit' ? (
          <TicketForm
            submitLabel="Salvar alterações"
            initialValue={selectedTicket}
            onCancel={() => setView('details')}
            onSubmit={handleUpdate}
          />
        ) : null}

        {view === 'details' ? (
          <>
            {ticketError ? <div className="alert alertError">{ticketError}</div> : null}
            {loadingTicket || !selectedTicket ? (
              <div className="card"><div className="muted">Carregando ticket...</div></div>
            ) : (
              <TicketDetails
                ticket={selectedTicket}
                onBack={() => {
                  setView('list');
                  load();
                }}
                onEdit={openEdit}
                onRefresh={refreshSelected}
              />
            )}
          </>
        ) : null}
      </main>

      <footer className="footer">
        <div className="muted small">
          Dica: crie um arquivo <code>frontend/.env</code> com <code>VITE_API_URL</code> apontando para seu backend.
        </div>
      </footer>
    </div>
  );
}

export default App;
