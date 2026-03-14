# Task — Deploy no Heroku (Spring Boot + Postgres)

## Contexto
- **Objetivo**: Subir o backend no Heroku e deixar rodando.

## Escopo
- **Inclui**:
  - Criar app no Heroku
  - Provisionar Heroku Postgres
  - Configurar `SPRING_PROFILES_ACTIVE=prod`
  - Ajustar porta/healthcheck se necessário
- **Não inclui**:
  - Pipeline staging/prod

## Critérios de aceite
- [ ] App responde no domínio do Heroku
- [ ] Conecta no Postgres do Heroku
- [ ] Swagger abre em produção
- [ ] `GET /actuator/health` retorna UP

## Plano (subtarefas)
### Implementação
- [x] Preparar config `prod`
- [x] Garantir porta dinâmica (`server.port=${PORT:8080}`)
- [x] Fixar Java 21 para Heroku (`system.properties`)
- [x] Adicionar `Procfile` (comando de start)
- [ ] Criar app e add-on Postgres
- [ ] Configurar variáveis de ambiente
- [ ] Deploy via Git

### Testes
- [ ] Smoke test em produção

## Evidências
- **URL produção**:
- **Swagger URL**:
