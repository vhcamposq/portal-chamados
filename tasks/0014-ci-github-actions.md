# Task — CI com GitHub Actions (build + testes)

## Contexto
- **Objetivo**: Rodar build e testes automaticamente a cada push/PR.
- **Motivação**: Demonstrar noções de CI/CD.

## Escopo
- **Inclui**:
  - Workflow Maven (compile + test)
  - Cache do Maven
- **Não inclui**:
  - Deploy automático

## Critérios de aceite
 - [ ] Pipeline roda em PR/push
 - [ ] Falhas de teste quebram o build

## Plano (subtarefas)
### Implementação
 - [x] Criar `.github/workflows/ci.yml`
 - [x] Configurar Java 21

### Testes
- [ ] Abrir PR e validar execução

## Evidências
- **Link do run**:
