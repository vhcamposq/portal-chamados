# Task — Modelar comentários/histórico do chamado

## Contexto
- **Objetivo**: Permitir acompanhar evolução do ticket por comentários (timeline).
- **Motivação**: Simula atendimento real e dá material para demo.

## Escopo
- **Inclui**:
  - Entidade JPA `TicketComment` (ou `TicketEvent`)
  - Relacionamento com `Ticket` (1:N)
  - DTOs de comentário
- **Não inclui**:
  - Menções, anexos, rich text

## Critérios de aceite
- [ ] Comentário persistido com referência ao `Ticket`
- [ ] Ordenação por data consistente
- [ ] Response do ticket pode incluir comentários (ou endpoint separado)

## Plano (subtarefas)
### Análise
- [ ] Definir campos (mensagem, autor opcional, createdAt)

### Implementação
- [ ] Criar entidade + repository
- [ ] Criar DTOs

### Testes
- [ ] Teste de persistência básico

### Revisão
- [ ] Evitar N+1 (fetch strategy ou endpoint separado)

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- Para MVP, `author` pode ser apenas string.

## Checklist de PR
- [ ] Build passa

## Evidências
- **Comando/saída**:
- **Prints/links**:
