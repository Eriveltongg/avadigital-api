# Avanova Digital – API

API REST em Java 17 + Spring Boot 4 (Maven), com banco H2 em memória.

## Como rodar
```bash
cd avanovadigital
mvn spring-boot:run
```
No VS Code: abra a pasta do projeto e use "Run" na classe `AvanovadigitalApplication`.

- API: http://localhost:8080/produtos
- Swagger (testar as rotas): http://localhost:8080/swagger-ui.html
- Console H2: http://localhost:8080/h2-console
  (JDBC URL `jdbc:h2:mem:avanovadigital`, usuário `sa`, senha vazia)

## Rotas
| Método | Rota             | Descrição              |
|--------|------------------|------------------------|
| POST   | /produtos        | Cadastrar produto      |
| GET    | /produtos        | Listar produtos        |
| GET    | /produtos/{id}   | Buscar por id          |
| PUT    | /produtos/{id}   | Atualizar produto      |
| DELETE | /produtos/{id}   | Excluir produto        |

Exemplo de corpo (POST/PUT):
```json
{ "nome": "Mouse gamer", "descricao": "RGB 6400 DPI", "preco": 129.90, "quantidade": 15 }
```

## Estrutura
```
src/main/java/br/com/avanovadigital/
├── AvanovadigitalApplication.java
├── config/       CorsConfig (libera http://localhost:5173 para o React)
├── controller/   ProdutoController
├── dto/          ProdutoRequest, ProdutoResponse
├── exception/    RecursoNaoEncontradoException, ApiExceptionHandler
├── model/        Produto
├── repository/   ProdutoRepository
└── service/      ProdutoService
```
