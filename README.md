# Desafio CRUD de Funcionários

Este é um projeto desenvolvido como parte de um desafio técnico para a **RGC Consultoria Engenharia**. O objetivo é implementar um sistema CRUD (Create, Read, Update, Delete) para gerenciar funcionários, utilizando **Java** e **Spring Boot**.

## 📌 Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Banco de Dados SQL
- Maven
- Git

## 🚀 Como Executar o Projeto

### 📥 Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina:
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Banco de dados SQL configurado] (MySQL, PostgreSQL, etc.)

### 📌 Passos para rodar o projeto
1. **Clone este repositório:**
   ```bash
   git clone https://github.com/SamuelPaimAraujoCezar/Desafio.git
   ```
2. **Acesse o diretório do projeto:**
   ```bash
   cd Desafio
   ```
3. **Configure o banco de dados**
   - Altere as credenciais de conexão no arquivo `application.properties` (caso necessário)
   
4. **Compile o projeto com Maven:**
   ```bash
   mvn clean install
   ```
5. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```
6. **Acesse a API:**
   - A aplicação estará rodando em `http://localhost:8080`

## 🔧 Endpoints Disponíveis
| Método  | Endpoint       | Descrição                        |
|---------|--------------|--------------------------------|
| GET     | `/funcionarios`   | Lista todos os funcionários |
| GET     | `/funcionarios/{id}` | Obtém um funcionário específico |
| POST    | `/funcionarios`   | Adiciona um novo funcionário |
| PUT     | `/funcionarios/{id}` | Atualiza um funcionário existente |
| DELETE  | `/funcionarios/{id}` | Remove um funcionário |

## 🛠️ Melhorias Futuras
- Implementação de testes unitários
- Validações mais robustas nos inputs
- Autenticação e autorização com JWT
- Integração com um frontend

## 🤝 Contribuição
Caso queira contribuir com melhorias ou sugestões, fique à vontade para abrir um **pull request**!

---
Feito por **Samuel Paim Araújo Cezar** 🚀
