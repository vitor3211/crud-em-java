# crud com spring boot
![Blog](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Blog](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Blog](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Blog](https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)

Este projeto foi desenvolvido para praticar e demonstrar os fundamentos de uma **API REST** utilizando **Java** e **Spring Boot**.  
A aplicação implementa operações básicas de **CRUD (Create, Read, Update, Delete)** sobre a entidade **User**, permitindo criar, listar, atualizar e deletar registros de forma simples e eficiente.

Trata-se de um projeto de estudo, com banco de dados **H2 em memória**, criado para reforçar conceitos essenciais de desenvolvimento web e demonstrar boas práticas como:
- Tratamento centralizado de exceções com `@ControllerAdvice`.
- Padronização de respostas em formato JSON.
- Organização em camadas (`controller`, `service`, `repository`, `dto`, `exception`).
- Persistência de dados com **Spring Data JPA + Hibernate**.


## Tecnologias utilizadas
- Java 21
- Spring Boot 4.0.0 
    - Spring Web
    - Spring Data JPA
    - Lombok
    - Validation
    - H2 Database
- Maven 3.6.3
- VS code
- Postman

## API Endpoints
Para testar as requisições HTTP, foi utilizado o Postman.  
Os endpoints podem ser acessados em `http://localhost:8080/users` ou `http://localhost:8080/users/{id}`.

### Endpoints
```
GET /users - Listar todos usuários.
GET /users/{id} - Listar usuário pelo id.
POST /users - Criar novo usuário.
PUT /users/{id} - Atualizar usuário pelo id.
DELETE /users/{id} - Deletar usuário pelo id.
```

### Excemplos de requisições em JSON
- Criar usuário
    - URL: http://localhost:8080/users
    - METHOD: POST

Body:

```json
{
    "name": "Matheus",
    "email": "Matheus@gmail.com",
    "dateOfBirth": "2000-10-23"
}
```
Response:
```json
{
    "id": 1,
    "name": "Matheus",
    "email": "Matheus@gmail.com",
    "dateOfBirth": "2000-10-23"
}
```
- Listar todos usuários
    - URL: http://localhost:8080/users
    - METHOD: GET

Response:
```json
{
    "id": 1,
    "name": "Matheus",
    "email": "Matheus@gmail.com",
    "dateOfBirth": "2000-10-23"
}
```

- Atualizar usuário
    - URL: http://localhost:8080/users/1
    - METHOD: PUT

Body:
```json
{
    "name": "Lucas",
    "email": "Lucas@gmail.com",
    "dateOfBirth": "2010-02-12"
}
```
Response:
```json
{
    "id": 1,
    "name": "Lucas",
    "email": "Lucas@gmail.com",
    "dateOfBirth": "2000-10-23"
}
```

- Deletar usuário
    - URL: http://localhost:8080/users/1
    - METHOD: DELETE

Response:
```json
{


}
```


