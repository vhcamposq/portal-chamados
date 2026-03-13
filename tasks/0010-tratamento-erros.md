# Task — Tratamento de erros (ControllerAdvice)

## Contexto
- **Objetivo**: Padronizar respostas de erro (404, 400, 422 etc.).
- **Motivação**: Melhor DX e API mais profissional para demo.

## Escopo
- **Inclui**:
  - `@RestControllerAdvice`
  - Payload padrão de erro (timestamp, status, message, path)
  - Tratamento de `MethodArgumentNotValidException`
  - Tratamento de `ResourceNotFoundException`
- **Não inclui**:
  - Logging estruturado avançado

## Critérios de aceite
 - [x] Validações retornam 400 com detalhes
 - [x] Recurso inexistente retorna 404
 - [x] Erros têm formato consistente

## Plano (subtarefas)
### Análise
 - [x] Definir formato do erro

### Implementação
 - [x] Criar classe `ApiError`
 - [x] Criar `GlobalExceptionHandler`

### Testes
- [ ] MockMvc cobrindo 400/404

### Revisão
 - [x] Revisar mensagens para não vazar stacktrace

### Deploy/Entrega
- [ ] N/A

## Evidências
- **Comando/saída**:
- **Prints/links**:
