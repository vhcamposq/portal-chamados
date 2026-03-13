# Task — Documentar API com Swagger/OpenAPI

## Contexto
- **Objetivo**: Garantir Swagger UI acessível e endpoints documentados.

## Escopo
- **Inclui**:
  - Conferir dependência `springdoc-openapi-starter-webmvc-ui`
  - Ajustar path do swagger se necessário
  - Documentar endpoints com anotações (mínimo)
- **Não inclui**:
  - Documentação extensa de negócio

## Critérios de aceite
 - [x] Swagger UI abre localmente
 - [x] Endpoints aparecem com schemas
 - [ ] Exemplo de payload para criação de ticket (se possível)

## Plano (subtarefas)
### Análise
- [ ] Definir se teremos agrupamento por tags

### Implementação
 - [x] Ajustar config do springdoc (se necessário)
 - [ ] Anotar controllers/DTOs (mínimo viável)

### Testes
 - [x] Smoke test manual: abrir swagger e chamar `POST /tickets`

### Revisão
- [ ] Garantir que não expõe endpoints internos

### Deploy/Entrega
- [ ] Validar swagger em produção

## Evidências
- **Comando/saída**:
- **Prints/links**:
