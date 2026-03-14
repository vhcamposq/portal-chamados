# Task — Testes unitários da camada Service

## Contexto
- **Objetivo**: Garantir regras de negócio testadas (criação, atualização, transições de status).

## Escopo
- **Inclui**:
  - Testes unitários para `TicketService`
  - Casos de erro (ticket inexistente, transição inválida)
- **Não inclui**:
  - Integração com banco real

## Critérios de aceite
 - [x] Cobrir criação e defaults
 - [ ] Cobrir mudança de status (válida e inválida)
 - [x] Cobrir not found

## Plano (subtarefas)
### Análise
 - [x] Definir cenários mínimos

### Implementação
 - [x] Criar testes com JUnit + Mockito (se aplicável)

### Testes
 - [x] Rodar suíte local

### Revisão
 - [x] Garantir testes determinísticos

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
