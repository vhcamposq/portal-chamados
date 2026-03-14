import { useMemo, useState } from 'react';
import { enums } from '../api';

export default function TicketForm({ initialValue, onCancel, onSubmit, submitLabel }) {
  const initial = useMemo(
    () =>
      initialValue || {
        title: '',
        description: '',
        priority: 'MEDIUM',
        category: 'SUPPORT',
      },
    [initialValue]
  );

  const [value, setValue] = useState(initial);
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState('');

  async function handleSubmit(e) {
    e.preventDefault();
    setError('');
    setSaving(true);
    try {
      await onSubmit(value);
    } catch (err) {
      setError(err?.message || 'Erro ao salvar');
    } finally {
      setSaving(false);
    }
  }

  return (
    <form className="card" onSubmit={handleSubmit}>
      <div className="cardHeader">
        <div className="cardTitle">{submitLabel}</div>
        <div className="row gap">
          <button type="button" className="btn btnGhost" onClick={onCancel} disabled={saving}>
            Cancelar
          </button>
          <button type="submit" className="btn" disabled={saving}>
            {saving ? 'Salvando...' : 'Salvar'}
          </button>
        </div>
      </div>

      {error ? <div className="alert alertError">{error}</div> : null}

      <div className="grid">
        <label className="field">
          <span>Título</span>
          <input
            value={value.title}
            onChange={(e) => setValue((v) => ({ ...v, title: e.target.value }))}
            maxLength={120}
            required
          />
        </label>

        <label className="field">
          <span>Prioridade</span>
          <select
            value={value.priority}
            onChange={(e) => setValue((v) => ({ ...v, priority: e.target.value }))}
            required
          >
            {enums.priority.map((p) => (
              <option key={p} value={p}>
                {p}
              </option>
            ))}
          </select>
        </label>

        <label className="field">
          <span>Categoria</span>
          <select
            value={value.category}
            onChange={(e) => setValue((v) => ({ ...v, category: e.target.value }))}
            required
          >
            {enums.category.map((c) => (
              <option key={c} value={c}>
                {c}
              </option>
            ))}
          </select>
        </label>

        <label className="field fieldFull">
          <span>Descrição</span>
          <textarea
            value={value.description}
            onChange={(e) => setValue((v) => ({ ...v, description: e.target.value }))}
            maxLength={4000}
            rows={6}
            required
          />
        </label>
      </div>

      <div className="hint">
        Campos obrigatórios. Em produção (Heroku) o banco é H2 em memória (não persiste).
      </div>
    </form>
  );
}
