# Portal Chamados — Task Board (Template)

## Como usar
- Crie uma cópia deste arquivo (ex.: `tasks/0000-roadmap.md` ou `tasks/roadmap.md`).
- Para cada item grande, crie um arquivo individual a partir de `tasks/task-template.md`.
- Marque o checklist conforme for concluindo.

## Objetivo
Descrever o objetivo do MVP e acompanhar a execução por tarefas.

## MVP — Checklist

### 1) Setup e qualidade
- [ ] Padronizar `package` (sem `_`)
- [ ] Configurar `application.properties` (local)
- [ ] Configurar profile `prod` (Heroku)
- [ ] Ajustar `springdoc`/Swagger e validar acesso

### 2) Domínio de Chamados
- [ ] Modelar entidade `Ticket`
- [ ] Modelar enums (status, prioridade, categoria)
- [ ] Criar DTOs (create/update)
- [ ] Implementar validações (`jakarta.validation`)

### 3) API REST
- [ ] `POST /tickets`
- [ ] `GET /tickets` (filtro/paginação)
- [ ] `GET /tickets/{id}`
- [ ] `PATCH /tickets/{id}/status`
- [ ] `PUT/PATCH /tickets/{id}` (edição)
- [ ] `POST /tickets/{id}/comments`

### 4) Persistência
- [ ] Repositories JPA
- [ ] Migrações com Flyway (opcional, mas recomendado)
- [ ] Índices/constraints básicos (ex.: status, prioridade)

### 5) Testes
- [ ] Testes unitários de regras (ex.: transição de status)
- [ ] Testes de controller (MockMvc)
- [ ] Testes de integração (opcional)

### 6) Observabilidade
- [ ] Actuator health
- [ ] Log básico (requests/erros)

### 7) Deploy Heroku
- [ ] App no Heroku + Heroku Postgres
- [ ] Config vars (`SPRING_PROFILES_ACTIVE=prod`, etc.)
- [ ] Build e start ok
- [ ] Swagger público (ou protegido)

## Backlog (pós-MVP)
- [ ] Autenticação e autorização (JWT)
- [ ] Base de conhecimento (CRUD de artigos)
- [ ] Sugestão de artigo (IA/similaridade)
- [ ] Acessibilidade (se houver frontend)

## Links
- Repositório: 
- Swagger (local): 
- Swagger (prod): 
