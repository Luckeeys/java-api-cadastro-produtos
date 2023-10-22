
# java-api-cadastro-produtos

Projeto destinado a criação de um modelo de currículo em formato de página web

## Principais Tecnologias
 - **Java 17**: Foi utilizada a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: foi utilizada a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

## Diagrama de classe

```mermaid
classDiagram
    class Produto {
        -int id
        -string nome
        -string descricao
        -float preco
        -int estoque
        -string categoria
        -string imagem_url
    }

    Produto -->|tem| string : id
    Produto -->|tem| string : nome
    Produto -->|tem| string : descricao
    Produto -->|tem| float : preco
    Produto -->|tem| int : estoque
    Produto -->|tem| string : categoria
    Produto -->|tem| string : imagem_url
```
