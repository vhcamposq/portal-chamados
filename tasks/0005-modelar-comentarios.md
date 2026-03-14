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
 - [x] Comentário persistido com referência ao `Ticket`
 - [x] Ordenação por data consistente
 - [x] Response do ticket pode incluir comentários (ou endpoint separado)

## Plano (subtarefas)
### Análise
 - [x] Definir campos (mensagem, autor opcional, createdAt)

### Implementação
 - [x] Criar entidade + repository
 - [x] Criar DTOs

### Testes
- [ ] Teste de persistência básico

### Revisão
- [ ] Evitar N+1 (fetch strategy ou endpoint separado)

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- Para MVP, `author` pode ser apenas string.

## Checklist de PR
 - [x] Build passa

## Evidências
- **Comando/saída**:
- **Prints/links**:
