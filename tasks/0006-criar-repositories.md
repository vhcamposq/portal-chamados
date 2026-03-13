# Task — Criar repositories JPA (Ticket + Comments)

## Contexto
- **Objetivo**: Habilitar operações de banco via Spring Data.

## Escopo
- **Inclui**:
  - `TicketRepository`
  - `TicketCommentRepository`
  - Métodos de busca básicos (status/prioridade/categoria)
- **Não inclui**:
  - Query complexa/relatórios

## Critérios de aceite
- [ ] Repositórios compilam e são injetáveis
- [ ] Paginação funciona para listagem

## Plano (subtarefas)
### Análise
- [ ] Definir necessidades de filtro/paginação

### Implementação
- [ ] Criar interfaces `JpaRepository`
- [ ] Criar métodos derivados (ex.: `findByStatus`)

### Testes
- [ ] `@DataJpaTest` básico (persistir e buscar)

### Revisão
- [ ] Checar nomes e índices necessários

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
