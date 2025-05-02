# 🏅 OlimpiadasJava

Projeto desenvolvido em Java para gerenciamento de dados relacionados às Olimpíadas, utilizando conexão com banco de dados MySQL.

---

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **MySQL**: Banco de dados relacional utilizado para armazenamento dos dados.
- **JDBC (Java Database Connectivity)**: API para conexão e execução de operações no banco de dados.
- **MySQL Connector/J**: Driver JDBC para conexão com o MySQL.

---

## ⚙️ Funcionalidades

- **Cadastro de Atletas**: Permite adicionar novos atletas ao sistema.
- **Listagem de Atletas**: Exibe todos os atletas cadastrados.
- **Atualização de Dados**: Possibilita a edição das informações dos atletas.
- **Remoção de Atletas**: Permite a exclusão de registros de atletas.
- **Consulta de Medalhas**: Visualiza o número de medalhas por país ou atleta.

---

## 🗂️ Estrutura do Projeto

```
OlimpiadasJava/
├── src/
│   ├── Main.java
│   ├── Atleta.java
│   ├── Conexao.java
│   └── Olimpiadas.java
├── mysql-connector-j-9.0.0.jar
└── README.md
```

---

## 🛠️ Instalação e Execução

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/RodrigoLudke/OlimpiadasJava.git
   cd OlimpiadasJava
   ```

2. **Configure o banco de dados MySQL:**

   - Crie um banco de dados chamado `olimpiadas`.
   - Execute o script SQL fornecido (caso exista) para criar as tabelas necessárias.

3. **Compile o projeto:**

   Certifique-se de que o `mysql-connector-j-9.0.0.jar` está incluído no classpath.

   ```bash
   javac -cp .:mysql-connector-j-9.0.0.jar src/*.java
   ```

   No Windows, use `;` em vez de `:` para separar os caminhos:

   ```bash
   javac -cp .;mysql-connector-j-9.0.0.jar src/*.java
   ```

4. **Execute a aplicação:**

   ```bash
   java -cp .:mysql-connector-j-9.0.0.jar src.Main
   ```

   No Windows:

   ```bash
   java -cp .;mysql-connector-j-9.0.0.jar src.Main
   ```

---

## ✅ Requisitos

- Java 8 ou superior
- MySQL Server
- MySQL Connector/J (incluso no projeto)

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.
