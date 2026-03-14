# Portal de Chamados (backend)

Backend de um mini Service Desk (portal de chamados) para demonstrar proficiência com Java/Spring, APIs REST, testes e CI.

- Produção (Heroku): https://portal-chamados-vhcamposq-eb600894b845.herokuapp.com/
- Swagger (produção): https://portal-chamados-vhcamposq-eb600894b845.herokuapp.com/swagger

## Stack

- Java 21
- Spring Boot 4.0.3
- Maven
- Spring WebMVC
- Spring Data JPA
- PostgreSQL (local)
- H2 (testes e fallback em `prod` no Heroku sem Postgres)
- Springdoc OpenAPI (Swagger)
- Actuator
- GitHub Actions (CI)

## Funcionalidades (MVP)

- Tickets (CRUD)
  - `POST /tickets`
  - `GET /tickets`
  - `GET /tickets/{id}`
  - `PUT /tickets/{id}`
  - `PATCH /tickets/{id}/status`
- Comentários do ticket
  - `POST /tickets/{ticketId}/comments`
  - `GET /tickets/{ticketId}/comments`
- Tratamento global de erros (400/404/500)

## Documentação da API (Swagger)

Local:
- http://localhost:8080/swagger

Produção (Heroku):
- https://portal-chamados-vhcamposq-eb600894b845.herokuapp.com/swagger

## Healthcheck

- `GET /actuator/health`

## Como rodar localmente (PostgreSQL)

### Pré-requisitos

- Java 21
- PostgreSQL instalado e rodando

### Variáveis/config

O projeto usa `src/main/resources/application.properties` com fallback para variáveis de ambiente.

Valores default (se você não setar env vars):
- Host: `localhost`
- Porta: `5432`
- DB: `portal_chamados`
- Usuário: `postgres`
- Senha: `postgres`

Se necessário, ajuste por variáveis de ambiente:

- `DB_HOST`
- `DB_PORT`
- `DB_NAME`
- `DB_USER`
- `DB_PASSWORD`

### Subir a aplicação

No Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

A API ficará em:
- http://localhost:8080

Swagger:
- http://localhost:8080/swagger

## Testes

Os testes usam H2 em memória (`src/test/resources/application.properties`).

```powershell
.\mvnw.cmd test
```

## CI (GitHub Actions)

Pipeline em `.github/workflows/ci.yml`:
- Java 21
- `./mvnw -U clean test`

## Deploy no Heroku (sem custo, sem Postgres)

Este repositório está configurado para subir no Heroku com profile `prod`.

Observação importante:
- No Heroku, como não foi provisionado Postgres (pago), o `prod` faz **fallback para H2 em memória**.
- **Dados não persistem** entre restarts.

Arquivos relevantes:
- `system.properties` (Java 21)
- `Procfile` (start command)
- `src/main/resources/application-prod.properties` (porta dinâmica e datasource)

Comandos (Heroku CLI):

```powershell
heroku login
heroku create portal-chamados-vhcamposq
heroku config:set SPRING_PROFILES_ACTIVE=prod -a portal-chamados-vhcamposq
git push heroku master
```

## Limitações conhecidas

- Sem autenticação/autorização (pós-MVP)
- Validação de transições de status ainda é simples (pós-MVP)
- No Heroku gratuito (sem Postgres), o banco é H2 em memória e não persiste dados
