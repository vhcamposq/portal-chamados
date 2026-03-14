# Task — Endpoints de comentários do Ticket

## Contexto
- **Objetivo**: Permitir adicionar/listar comentários de um ticket.

## Escopo
- **Inclui**:
  - `POST /tickets/{id}/comments`
  - `GET /tickets/{id}/comments` (opcional)
- **Não inclui**:
  - Edição/remoção de comentário

## Critérios de aceite
 - [x] Comentário criado e vinculado ao ticket
 - [x] Listagem ordenada por data

## Plano (subtarefas)
### Análise
 - [x] Definir se comentários vêm embutidos no `GET /tickets/{id}` ou endpoint próprio

### Implementação
 - [x] Implementar endpoints

### Testes
 - [x] MockMvc cobrindo 201/404

### Revisão
- [ ] Validar payload e limitações

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
