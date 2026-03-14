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
- [x] App responde no domínio do Heroku
- [x] App sobe sem Postgres (H2 em memória) (dados não persistem)
- [x] Swagger abre em produção
- [x] `GET /actuator/health` retorna UP

## Plano (subtarefas)
### Implementação
- [x] Preparar config `prod`
- [x] Garantir porta dinâmica (`server.port=${PORT:8080}`)
- [x] Fixar Java 21 para Heroku (`system.properties`)
- [x] Adicionar `Procfile` (comando de start)
- [x] Ajustar `prod` para fallback em H2 (sem custo)
- [x] Criar app no Heroku
- [x] Configurar variáveis de ambiente
- [x] Deploy via Git

### Testes
- [x] Smoke test em produção

## Evidências
- **URL produção**: https://portal-chamados-vhcamposq-eb600894b845.herokuapp.com/
- **Swagger URL**: https://portal-chamados-vhcamposq-eb600894b845.herokuapp.com/swagger
