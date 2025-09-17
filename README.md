
# Sistema de Gestão de Usuários - Spring Boot + JWT

API REST para gestão de usuários com autenticação JWT e controle de acesso baseado em roles.
## Grupo
- Marco Albuquerque
- Valter Gomes

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.1.0
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Flyway (Migrations)
- Docker
- Maven

## 🔐 Roles e Permissões

| Role | Permissões |
|------|------------|
| **ADMIN** | Acesso total a todos os endpoints |
| **GERENTE** | Visualizar usuários e relatórios |
| **COLABORADOR** | Apenas dashboard |

## 📋 Pré-requisitos

- Java 17+
- Maven 3.6+
- Docker Desktop

## 🛠️ Instalação e Execução

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd projeto-java
```

### 2. Subir o banco PostgreSQL
```bash
docker compose up -d
```

### 3. Executar a aplicação
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 🐘 Banco de Dados

### PostgreSQL
- **Host:** localhost:5432
- **Database:** projetobase
- **Username:** admin
- **Password:** admin

### PgAdmin (Interface Web)
- **URL:** http://localhost:8081
- **Email:** admin@admin.com
- **Password:** admin

## 📡 Endpoints da API

### Autenticação

#### Login
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}
```

#### Registro
```http
POST /auth/register
Content-Type: application/json

{
  "username": "novouser",
  "password": "senha123"
}
```

### Gestão (Requer Autenticação)

#### Listar Usuários
```http
GET /gestao/usuarios
Authorization: Bearer <seu-token-jwt>
```
**Acesso:** ADMIN, GERENTE

#### Gerar Relatórios
```http
GET /gestao/relatorios
Authorization: Bearer <seu-token-jwt>
```
**Acesso:** ADMIN, GERENTE

#### Dashboard
```http
GET /gestao/dashboard
Authorization: Bearer <seu-token-jwt>
```
**Acesso:** ADMIN, GERENTE, COLABORADOR

## 👤 Usuário Padrão

- **Username:** admin
- **Password:** 123456
- **Role:** ROLE_ADMIN

## 🗂️ Estrutura do Projeto

```
src/main/java/com/gestao/
├── controller/          # Controllers REST
├── service/            # Lógica de negócio
├── repository/         # Acesso a dados
├── model/              # Entidades JPA
├── dto/                # Data Transfer Objects
├── security/           # Configurações JWT
└── GestaoApplication.java

src/main/resources/
├── db/migration/       # Scripts Flyway
└── application.yml     # Configurações
```

## 🔧 Configurações

### JWT
- **Secret:** my-secret-key-123456
- **Expiração:** 24 horas (86400000ms)

### Banco de Dados
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/projetobase
    username: admin
    password: admin
```

## 🧪 Como Testar

### 1. Fazer Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"123456"}'
```

### 2. Usar o Token
```bash
curl -X GET http://localhost:8080/gestao/usuarios \
  -H "Authorization: Bearer SEU_TOKEN_AQUI"
```

## 📦 Docker

### Subir apenas o banco
```bash
docker compose up -d db
```

### Subir banco + PgAdmin
```bash
docker compose up -d
```

### Parar os serviços
```bash
docker compose down
```

## 🚨 Troubleshooting

### Erro de conexão com banco
- Verifique se o Docker está rodando
- Confirme se a porta 5432 não está em uso

### Erro de compilação
- Verifique se está usando Java 17+
- Execute: `./mvnw clean install`

### Token inválido
- Verifique se o token não expirou (24h)
- Confirme o formato: `Bearer <token>`

## 📄 Licença

Este projeto está sob a licença MIT.
