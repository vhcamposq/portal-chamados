# Task — Padronizar package (remover underscore)

## Contexto
- **Objetivo**: Trocar `com.vhcamposq.portal_chamados` para um package padrão Java (ex.: `com.vhcamposq.portalchamados`).
- **Motivação**: Evitar convenções incomuns e reduzir atrito com tooling, exemplos e revisões.
- **Referências**: `src/main/java/com/vhcamposq/portal_chamados/PortalChamadosApplication.java`

## Escopo
- **Inclui**:
  - Renomear package no código fonte e testes
  - Ajustar estrutura de pastas
- **Não inclui**:
  - Alterar groupId/artifactId

## Critérios de aceite
- [ ] Aplicação sobe sem erros
- [ ] Testes rodam
- [ ] Não sobra referência ao package antigo

## Plano (subtarefas)
### Análise
- [ ] Listar arquivos no package atual (main/test)

### Implementação
- [ ] Renomear diretórios e `package` statements
- [ ] Ajustar imports quebrados

### Testes
- [ ] Rodar testes

### Revisão
- [ ] Conferir se o IntelliJ reconheceu o refactor corretamente

### Deploy/Entrega
- [ ] N/A

## Notas de implementação
- Fazer via refactor do IDE para evitar inconsistência de pastas.

## Checklist de PR
- [ ] Build passa
- [ ] Testes passam

## Evidências
- **Comando/saída**:
- **Prints/links**:
