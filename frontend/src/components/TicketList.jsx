import { enums, formatDate } from '../api';

export default function TicketList({ data, loading, error, filters, onFiltersChange, onSelect, onCreate }) {
  const items = data?.content || [];

  return (
    <div className="card">
      <div className="cardHeader">
        <div>
          <div className="cardTitle">Tickets</div>
          <div className="muted">{loading ? 'Carregando...' : `${data?.totalElements ?? 0} total`}</div>
        </div>
        <button className="btn" onClick={onCreate}>
          Novo ticket
        </button>
      </div>

      {error ? <div className="alert alertError">{error}</div> : null}

      <div className="filters">
        <select value={filters.status} onChange={(e) => onFiltersChange({ ...filters, status: e.target.value })}>
          <option value="">Status (todos)</option>
          {enums.status.map((s) => (
            <option key={s} value={s}>
              {s}
            </option>
          ))}
        </select>
        <select value={filters.priority} onChange={(e) => onFiltersChange({ ...filters, priority: e.target.value })}>
          <option value="">Prioridade (todas)</option>
          {enums.priority.map((p) => (
            <option key={p} value={p}>
              {p}
            </option>
          ))}
        </select>
        <select value={filters.category} onChange={(e) => onFiltersChange({ ...filters, category: e.target.value })}>
          <option value="">Categoria (todas)</option>
          {enums.category.map((c) => (
            <option key={c} value={c}>
              {c}
            </option>
          ))}
        </select>
      </div>

      <div className="table">
        <div className="tableRow tableHeader">
          <div>Título</div>
          <div>Status</div>
          <div>Prioridade</div>
          <div>Categoria</div>
          <div>Criado</div>
        </div>

        {items.length === 0 && !loading ? <div className="empty">Nenhum ticket encontrado</div> : null}

        {items.map((t) => (
          <button key={t.id} className="tableRow tableButton" onClick={() => onSelect(t.id)}>
            <div className="titleCell">{t.title}</div>
            <div><span className={`pill pill-${t.status}`}>{t.status}</span></div>
            <div>{t.priority}</div>
            <div>{t.category}</div>
            <div className="muted">{formatDate(t.createdAt)}</div>
          </button>
        ))}
      </div>
    </div>
  );
}
