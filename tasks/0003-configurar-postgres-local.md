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
 - [x] Aplicação sobe conectando no Postgres local
 - [x] Entidades JPA criam tabelas (temporariamente via `ddl-auto=update` ou `create`)
 - [x] Profile `prod` usa variáveis de ambiente (`DATABASE_URL`/JDBC url)

## Plano (subtarefas)
### Análise
 - [x] Definir padrão de config local vs prod

### Implementação
 - [x] Adicionar `spring.datasource.*`
 - [x] Adicionar `spring.jpa.*`
 - [x] Criar `application-prod.properties`

### Testes
 - [x] Subir app local e validar conexão

### Revisão
 - [x] Garantir que não há credenciais hardcoded para prod

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- No Heroku, preferir variáveis de ambiente e `SPRING_PROFILES_ACTIVE=prod`.

## Checklist de PR
 - [x] Build passa
 - [x] Sem segredos no repositório

## Evidências
- **Comando/saída**:
- **Prints/links**:
