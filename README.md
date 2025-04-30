# Checkpoint 1 – API de Pedidos (Spring Boot)

Este projeto foi desenvolvido como parte de um checkpoint da FIAP, com o objetivo de aplicar os conceitos iniciais de arquitetura orientada a serviços (SOA) e desenvolvimento de APIs RESTful com Spring Boot. Ele consiste em um sistema para cadastrar, consultar, atualizar e deletar pedidos de clientes.

## 📦 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3.1.x  
- Spring Web  
- Spring Data JPA  
- Lombok  
- H2 Database (banco de dados em memória)  
- Maven

## 📁 Estrutura do Projeto

```
src/main/java/br/com/fiap/checkpoint1/
├── controller     // Endpoints REST
├── model          // Entidades do domínio
├── repository     // Interface de persistência
├── service        // Regras de negócio
```

## 📌 Funcionalidades

A API permite:

- ✅ Criar pedidos
- 📋 Listar todos os pedidos
- 🔍 Buscar pedido por ID
- ✏️ Atualizar um pedido
- ❌ Deletar um pedido

### 🧾 Entidade Pedido

| Campo        | Tipo       | Regras                                    |
|--------------|------------|-------------------------------------------|
| `id`         | Long       | Chave primária, gerada automaticamente     |
| `clienteNome`| String     | Obrigatório, não pode ser vazio           |
| `dataPedido` | LocalDate  | Gerado automaticamente com data atual     |
| `valorTotal` | double     | Não pode ser negativo                     |

## 🔌 Endpoints da API

| Método | Rota              | Ação                             |
|--------|-------------------|----------------------------------|
| GET    | `/pedidos`        | Listar todos os pedidos          |
| GET    | `/pedidos/{id}`   | Buscar pedido pelo ID            |
| POST   | `/pedidos`        | Criar novo pedido                |
| PUT    | `/pedidos/{id}`   | Atualizar pedido existente       |
| DELETE | `/pedidos/{id}`   | Deletar pedido                   |

## ⚙️ Configuração do Banco de Dados

O banco H2 é configurado via `application.properties` para funcionar em memória, com o console habilitado para visualização dos dados.

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/PalomaRodrigues33/fiap-checkpoint1.git
cd fiap-checkpoint1
```

2. Execute o projeto com Maven:

```bash
./mvnw spring-boot:run
```

3. Acesse o H2 Console (opcional):

```
http://localhost:8080/h2-console
```

Use o JDBC URL: `jdbc:h2:mem:testdb`

## 🧪 Testes

Você pode testar os endpoints usando o Postman ou qualquer outra ferramenta REST:

- Criar um novo pedido (POST)
- Buscar todos os pedidos (GET)
- Buscar um pedido por ID (GET)
- Atualizar um pedido (PUT)
- Deletar um pedido (DELETE)

## 📝 Licença

Este projeto é de uso acadêmico e está disponível para fins educacionais.
