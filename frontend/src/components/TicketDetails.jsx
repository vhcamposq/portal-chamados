import { useEffect, useState } from 'react';
import { addComment, changeTicketStatus, enums, formatDate, listComments } from '../api';

export default function TicketDetails({ ticket, onBack, onEdit, onRefresh }) {
  const [comments, setComments] = useState([]);
  const [comment, setComment] = useState('');
  const [loadingComments, setLoadingComments] = useState(false);
  const [savingComment, setSavingComment] = useState(false);
  const [changingStatus, setChangingStatus] = useState(false);
  const [error, setError] = useState('');

  async function loadComments() {
    setError('');
    setLoadingComments(true);
    try {
      const data = await listComments(ticket.id);
      setComments(data);
    } catch (err) {
      setError(err?.message || 'Erro ao carregar comentários');
    } finally {
      setLoadingComments(false);
    }
  }

  useEffect(() => {
    loadComments();
  }, [ticket.id]);

  async function handleAddComment(e) {
    e.preventDefault();
    if (!comment.trim()) return;
    setError('');
    setSavingComment(true);
    try {
      await addComment(ticket.id, comment.trim());
      setComment('');
      await loadComments();
    } catch (err) {
      setError(err?.message || 'Erro ao adicionar comentário');
    } finally {
      setSavingComment(false);
    }
  }

  async function handleChangeStatus(newStatus) {
    setError('');
    setChangingStatus(true);
    try {
      await changeTicketStatus(ticket.id, newStatus);
      await onRefresh();
    } catch (err) {
      setError(err?.message || 'Erro ao mudar status');
    } finally {
      setChangingStatus(false);
    }
  }

  return (
    <div className="card">
      <div className="cardHeader">
        <div>
          <div className="cardTitle">Ticket #{ticket.id}</div>
          <div className="muted">Criado: {formatDate(ticket.createdAt)} | Atualizado: {formatDate(ticket.updatedAt)}</div>
        </div>
        <div className="row gap">
          <button className="btn btnGhost" onClick={onBack}>Voltar</button>
          <button className="btn" onClick={onEdit}>Editar</button>
        </div>
      </div>

      {error ? <div className="alert alertError">{error}</div> : null}

      <div className="details">
        <div className="detailsTitle">{ticket.title}</div>
        <div className="muted">Prioridade: {ticket.priority} | Categoria: {ticket.category}</div>
        <div className="desc">{ticket.description}</div>

        <div className="row gap">
          <span className={`pill pill-${ticket.status}`}>{ticket.status}</span>
          <select
            value={ticket.status}
            onChange={(e) => handleChangeStatus(e.target.value)}
            disabled={changingStatus}
          >
            {enums.status.map((s) => (
              <option key={s} value={s}>
                {s}
              </option>
            ))}
          </select>
          {changingStatus ? <span className="muted">Atualizando...</span> : null}
        </div>
      </div>

      <div className="section">
        <div className="sectionTitle">Comentários</div>
        {loadingComments ? <div className="muted">Carregando comentários...</div> : null}

        {comments.length === 0 && !loadingComments ? <div className="empty">Nenhum comentário ainda</div> : null}

        <div className="comments">
          {comments.map((c) => (
            <div key={c.id} className="comment">
              <div className="commentMsg">{c.message}</div>
              <div className="muted">{formatDate(c.createdAt)}</div>
            </div>
          ))}
        </div>

        <form className="row gap" onSubmit={handleAddComment}>
          <input
            placeholder="Adicionar comentário..."
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            maxLength={1000}
          />
          <button className="btn" type="submit" disabled={savingComment}>
            {savingComment ? 'Enviando...' : 'Enviar'}
          </button>
        </form>
      </div>
    </div>
  );
}
