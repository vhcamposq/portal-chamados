# Task — Implementar controllers REST de Tickets

## Contexto
- **Objetivo**: Expor API REST do MVP.

## Escopo
- **Inclui**:
  - `TicketController`
  - Endpoints CRUD e status
  - Validações e status HTTP corretos
- **Não inclui**:
  - Autenticação

## Critérios de aceite
 - [x] `POST /tickets` cria e retorna 201
 - [x] `GET /tickets` lista com paginação
 - [x] `GET /tickets/{id}` retorna 200/404
 - [x] `PUT/PATCH /tickets/{id}` atualiza
 - [x] `PATCH /tickets/{id}/status` altera status

## Plano (subtarefas)
### Análise
 - [x] Definir contratos de request/response

### Implementação
 - [x] Implementar controller + injeção do service
 - [x] Mapear DTOs

### Testes
 - [x] Testes com MockMvc (happy path + erros)

### Revisão
- [ ] Garantir mensagens e códigos consistentes

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
