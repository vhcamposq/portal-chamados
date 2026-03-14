# Task — Criar camada de Service e regras (transição de status)

## Contexto
- **Objetivo**: Centralizar regra de negócio fora do controller.
- **Motivação**: Facilitar testes unitários e manutenibilidade.

## Escopo
- **Inclui**:
  - `TicketService`
  - Regras de transição de status
  - Atualização de `updatedAt`
- **Não inclui**:
  - Autorização por usuário

## Critérios de aceite
 - [x] Criação de ticket com defaults
 - [ ] Mudança de status validada (ex.: não permitir pular de OPEN direto para DONE, se decidirmos assim)
 - [x] Erros retornam exceções de domínio

## Plano (subtarefas)
### Análise
 - [ ] Definir diagrama simples de transições permitidas

### Implementação
 - [x] Implementar métodos (create, update, changeStatus, addComment)
 - [ ] Criar exceções (ex.: `ResourceNotFoundException`, `InvalidStatusTransitionException`)

### Testes
 - [x] Testes unitários do service

### Revisão
- [ ] Garantir mensagens claras de erro

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
