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
- [ ] Cobrir criação e defaults
- [ ] Cobrir mudança de status (válida e inválida)
- [ ] Cobrir not found

## Plano (subtarefas)
### Análise
- [ ] Definir cenários mínimos

### Implementação
- [ ] Criar testes com JUnit + Mockito (se aplicável)

### Testes
- [ ] Rodar suíte local

### Revisão
- [ ] Garantir testes determinísticos

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
