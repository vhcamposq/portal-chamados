# Task — Deploy no Heroku (Spring Boot + Postgres)

## Contexto
- **Objetivo**: Subir o backend no Heroku e deixar rodando.

## Escopo
- **Inclui**:
  - Criar app no Heroku
  - Rodar em `prod` sem Postgres (H2 em memória)
  - Configurar `SPRING_PROFILES_ACTIVE=prod`
  - Ajustar porta/healthcheck se necessário
- **Não inclui**:
  - Pipeline staging/prod

## Critérios de aceite
- [ ] App responde no domínio do Heroku
- [ ] App sobe sem Postgres (H2 em memória) (dados não persistem)
- [ ] Swagger abre em produção
- [ ] `GET /actuator/health` retorna UP

## Plano (subtarefas)
### Implementação
- [x] Preparar config `prod`
- [x] Garantir porta dinâmica (`server.port=${PORT:8080}`)
- [x] Fixar Java 21 para Heroku (`system.properties`)
- [x] Adicionar `Procfile` (comando de start)
- [x] Ajustar `prod` para fallback em H2 (sem custo)
- [ ] Criar app no Heroku
- [ ] Configurar variáveis de ambiente
- [ ] Deploy via Git

### Testes
- [ ] Smoke test em produção

## Evidências
- **URL produção**:
- **Swagger URL**:
