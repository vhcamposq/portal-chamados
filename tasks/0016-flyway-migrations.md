# Task — Migrações com Flyway

## Contexto
- **Objetivo**: Controlar schema do banco por migrações versionadas.

## Escopo
- **Inclui**:
  - Adicionar dependência Flyway
  - Criar migração inicial (`V1__init.sql`)
- **Não inclui**:
  - Migrações avançadas/refactors complexos

## Critérios de aceite
- [ ] App sobe com Flyway habilitado
- [ ] Migração cria tabelas necessárias

## Plano (subtarefas)
### Implementação
- [ ] Adicionar Flyway no Maven
- [ ] Criar scripts em `src/main/resources/db/migration`

### Testes
- [ ] Subir app em banco limpo

## Evidências
- **Comando/saída**:
