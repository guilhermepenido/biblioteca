# Sistema de Biblioteca

Um sistema de gerenciamento de biblioteca simples usando Spring Boot, Java e Gradle com banco de dados MySQL.

## Sobre

Este projeto é uma aplicação de exemplo para um sistema de biblioteca, permitindo o gerenciamento de bibliotecários, livros, clientes e empréstimos.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Java](https://www.java.com/)
- [Gradle](https://gradle.org/)
- [Hibernate](https://hibernate.org/)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## Configuração do Ambiente de Desenvolvimento

1. Clone este repositório: `git clone git@github.com:guilhermepenido/biblioteca.git`
2. Navegue até o diretório do projeto: `cd sistema-biblioteca`
3. Configure seu banco de dados MySQL:
   - Crie um banco de dados chamado `biblioteca`.
   - Atualize as configurações de banco de dados em `src/main/resources/application.properties` com suas credenciais e detalhes do banco de dados.
4. Execute a aplicação: `./gradlew bootRun`

## Como Usar

A aplicação estará disponível em `http://localhost:8080`. Você pode explorar as APIs usando ferramentas como [Postman](https://www.postman.com/) ou [Swagger](https://swagger.io/).

Endpoints disponíveis:
- `GET /bibliotecarios`: Lista todos os bibliotecários.
- `GET /livros`: Lista todos os livros.
- `GET /clientes`: Lista todos os clientes.
- `GET /emprestimos`: Lista todos os empréstimos.

Exemplo de solicitação para realizar um empréstimo:
```http
POST /emprestimos/realizar
Content-Type: application/json

{
  "bibliotecarioId": 1,
  "clienteId": 2,
  "livroIds": [3, 4]
}
