# Task — Sugestão de artigo por similaridade (IA simples)

## Contexto
- **Objetivo**: Ao criar ticket, sugerir artigos similares com base no texto.

## Escopo
- **Inclui**:
  - Similaridade simples (ex.: trigram/TF-IDF) sem API externa
  - Endpoint `GET /tickets/{id}/suggestions` (ou retorno no create)
- **Não inclui**:
  - LLM/embeddings externos

## Critérios de aceite
- [ ] Dado um ticket, retorna lista de artigos relevantes
- [ ] Implementação determinística e testável
