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
- [ ] `POST /tickets` cria e retorna 201
- [ ] `GET /tickets` lista com paginação
- [ ] `GET /tickets/{id}` retorna 200/404
- [ ] `PUT/PATCH /tickets/{id}` atualiza
- [ ] `PATCH /tickets/{id}/status` altera status

## Plano (subtarefas)
### Análise
- [ ] Definir contratos de request/response

### Implementação
- [ ] Implementar controller + injeção do service
- [ ] Mapear DTOs

### Testes
- [ ] Testes com MockMvc (happy path + erros)

### Revisão
- [ ] Garantir mensagens e códigos consistentes

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
