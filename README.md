# 🪙 Crypto Token Manager - Java Console App

A professional-grade Java console application for managing a database of crypto tokens. This CLI tool allows users to **add**, **view**, **update**, and **delete** token entries from a PostgreSQL database — following best practices in modular design, configuration management, logging, and clean architecture.

---

## 🚀 Features

- ✅ **Full CRUD operations** via console interface
- ✅ **PostgreSQL integration** with persistent storage
- ✅ **.env-based config management** (using dotenv for DB credentials)
- ✅ **Modular architecture** using clean Java package separation
- ✅ **Production-grade logging** using `java.util.logging` (no `System.out.println`)
- ✅ **Custom logger formatter** for clean console output
- ✅ **Schema and seed data included** for quick setup
- ✅ **Clear error handling** and input validation
- ✅ **Easily extensible** into REST API or desktop GUI

---

## 🔧 Setup Instructions

Follow the steps below to run the project locally on your machine.

---

### 📦 Prerequisites

- ✅ Java 17 or higher
- ✅ PostgreSQL installed and running
- ✅ `psql` CLI or GUI (like pgAdmin)
- ✅ `.env` file created at the project root (see below)
- ✅ PostgreSQL user and database already created (e.g., `CryptoTokensDB`)

### ⚙️ Create .env file

- DB_URL=jdbc:postgresql://localhost:5432/cryptodb
- DB_USER=postgres
- DB_PASSWORD=your_password_here

### 🛢️ Set Up PostgreSQL Database

**Create the database (if it doesn't exist):**

- createdb CryptoTokensDB

#### Then run the schema and sample data:

- psql -U your_postgres_user -d cryptodb -f sql_resources/schema.sql
- psql -U your_postgres_user -d cryptodb -f sql_resources/sample_data.sql

### 🔨 Compile & Run

Instead of manually running `javac`/`java`, use the scripts:

#### 🔧 Build the project:

```bash
./build.sh
```

#### 🚀 Run the project:

```bash
./run.sh
```

## 📁 Project Structure

CryptoTokenManager/
├── src/
│ └── com.crypto.tokenmanager/
│ ├── app/ # Main CLI logic
│ ├── dao/ # Data Access Object (CRUD logic)
│ ├── model/ # Token entity
│ └── util/ # DB connection & logger setup
├── sql_resources/
│ ├── schema.sql # SQL table creation script
│ └── sample_data.sql # Sample tokens
├── .env # Hidden DB credentials
└── README.md

```

```
