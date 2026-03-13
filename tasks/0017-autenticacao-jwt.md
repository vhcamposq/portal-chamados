# Task — Autenticação JWT (pós-MVP)

## Contexto
- **Objetivo**: Proteger endpoints e demonstrar Spring Security.

## Escopo
- **Inclui**:
  - Login com usuário/senha (in-memory ou tabela)
  - Emissão e validação de JWT
  - Proteger endpoints de escrita
- **Não inclui**:
  - RBAC completo, OAuth2

## Critérios de aceite
- [ ] `POST /auth/login` retorna token
- [ ] Endpoints protegidos retornam 401 sem token

## Evidências
- **Swagger/prints**:
