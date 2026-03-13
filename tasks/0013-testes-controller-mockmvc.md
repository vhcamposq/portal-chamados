# Task — Testes de controller com MockMvc

## Contexto
- **Objetivo**: Garantir contratos REST e códigos HTTP.

## Escopo
- **Inclui**:
  - Testes de `TicketController`
  - Testes de validação (400) e not found (404)
- **Não inclui**:
  - Testes end-to-end

## Critérios de aceite
- [ ] `POST /tickets` retorna 201
- [ ] Erro de validação retorna 400
- [ ] `GET /tickets/{id}` inexistente retorna 404

## Plano (subtarefas)
### Implementação
- [ ] Criar `@WebMvcTest` + mocks do service

### Testes
- [ ] Rodar testes local

## Evidências
- **Comando/saída**:
- **Prints/links**:
