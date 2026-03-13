# Task — Configurar Postgres local (datasource) e profiles

## Contexto
- **Objetivo**: Configurar `application.properties` para rodar local com Postgres e preparar `prod` para Heroku.
- **Motivação**: Habilitar JPA/Hibernate e começar persistência real.

## Escopo
- **Inclui**:
  - `application.properties` (local)
  - `application-prod.properties` (Heroku)
  - Config de JPA (`ddl-auto`, show-sql opcional)
- **Não inclui**:
  - Flyway (pode ser task separada)

## Critérios de aceite
- [ ] Aplicação sobe conectando no Postgres local
- [ ] Entidades JPA criam tabelas (temporariamente via `ddl-auto=update` ou `create`)
- [ ] Profile `prod` usa variáveis de ambiente (`DATABASE_URL`/JDBC url)

## Plano (subtarefas)
### Análise
- [ ] Definir padrão de config local vs prod

### Implementação
- [ ] Adicionar `spring.datasource.*`
- [ ] Adicionar `spring.jpa.*`
- [ ] Criar `application-prod.properties`

### Testes
- [ ] Subir app local e validar conexão

### Revisão
- [ ] Garantir que não há credenciais hardcoded para prod

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- No Heroku, preferir variáveis de ambiente e `SPRING_PROFILES_ACTIVE=prod`.

## Checklist de PR
- [ ] Build passa
- [ ] Sem segredos no repositório

## Evidências
- **Comando/saída**:
- **Prints/links**:
