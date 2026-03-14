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
 - [x] `POST /tickets` retorna 201
 - [x] Erro de validação retorna 400
 - [x] `GET /tickets/{id}` inexistente retorna 404

## Plano (subtarefas)
### Implementação
 - [x] Criar `@WebMvcTest` + mocks do service

### Testes
 - [x] Rodar testes local

## Evidências
- **Comando/saída**:
- **Prints/links**:
