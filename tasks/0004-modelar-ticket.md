# Task — Modelar domínio `Ticket` (entidade + enums + DTOs)

## Contexto
- **Objetivo**: Criar o domínio central do sistema de chamados.
- **Motivação**: Base para repositórios, regras e endpoints.

## Escopo
- **Inclui**:
  - Entidade JPA `Ticket`
  - Enums: `TicketStatus`, `TicketPriority`, `TicketCategory`
  - DTOs: `TicketCreateRequest`, `TicketUpdateRequest`, `TicketResponse`
- **Não inclui**:
  - Comentários/histórico (task separada)

## Critérios de aceite
 - [x] Entidade persistível com JPA
 - [x] DTOs com validações (`@NotBlank`, `@NotNull`, `@Size`)
 - [x] Campos mínimos definidos (título, descrição, status, prioridade, categoria, createdAt/updatedAt)

## Plano (subtarefas)
### Análise
 - [x] Definir campos obrigatórios e defaults

### Implementação
 - [x] Criar enums
 - [x] Criar entidade `Ticket`
 - [x] Criar DTOs
 - [x] Definir mapper simples (manual) para Response

### Testes
- [ ] Testar validações (unitário de DTO opcional)

### Revisão
 - [x] Revisar nomes/colunas e nulabilidade

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- Status default: `OPEN`.

## Checklist de PR
 - [x] Build passa

## Evidências
- **Comando/saída**:
- **Prints/links**:
