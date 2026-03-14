# Task — Escopo do MVP (Portal de Chamados)

## Contexto
- **Objetivo**: Definir claramente o MVP do Portal de Chamados (entidades, fluxos, endpoints e fora de escopo) para guiar a implementação.
- **Motivação**: Evitar retrabalho e garantir que o projeto seja demonstrável rapidamente.
- **Referências**: `tasks/tasks-template.md`

## Escopo
- **Inclui**:
  - Chamados (ticket) com status/prioridade/categoria
  - Comentários e histórico do chamado
  - API REST documentada (Swagger)
  - Persistência Postgres
  - Deploy no Heroku
- **Não inclui**:
  - Frontend (neste MVP)
  - Autenticação (pós-MVP)
  - IA (pós-MVP)

## Critérios de aceite
 - [x] Lista de entidades definida (Ticket, Comment/TimelineEvent)
 - [x] Lista de endpoints definida
 - [ ] Regras de negócio mínimas definidas (transições de status, campos obrigatórios)
 - [x] Fora de escopo registrado

## Plano (subtarefas)
### Análise
 - [x] Definir campos do `Ticket`
 - [x] Definir enums (status, prioridade, categoria)
 - [x] Definir campos do comentário/histórico

### Implementação
 - [ ] Criar documento com endpoints e exemplos de payload

### Testes
- [ ] N/A (definição)

### Revisão
- [ ] Revisar se o escopo cabe em 1-2 semanas

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- Manter status simples: `OPEN`, `IN_PROGRESS`, `IN_REVIEW`, `DONE`.

## Checklist de PR
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
