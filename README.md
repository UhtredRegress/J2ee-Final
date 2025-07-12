# 📄 Document Storage Management System (Liferay + Java EE + MVC)

A simple, modular web-based application built using **Java EE** and **Liferay MVC** architecture for managing **documents**, **tags**, and related data with a clean user interface and layered architecture.

---

## 🔧 Tech Stack

- **Java EE (JSP)**
- **Liferay MVC Portlet**
- **PostgreSQL Database**
- **Apache Tomcat**
- **Gradle Build Tool**
- **Bootstrap 5 (UI Styling)**

---

## 📌 Key Features

- Create, edit, and delete **documents** and **tags**
- View records in a clean, responsive, and paginated UI
- MVC-based design for better code organization
- Modular architecture using **Liferay OSGi modules**

---

## 🏗️ Project Modules 

| Module | Description |
|--------|-------------|
| `document-data` | Contains service builder-generated code for persistence, service APIs, and view model  |
| `document-web` | User interface layer with Liferay portlets (MVC), controllers, and JSP pages |

---


## 🚀 Getting Started

Follow the steps below to set up and run the project locally.

### ✅ Prerequisites

Make sure the following tools and software are installed:

- [Java JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Git](https://git-scm.com/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Liferay Portal 7.4 Bundle](https://www.liferay.com/downloads)
- A database GUI like [pgAdmin](https://www.pgadmin.org/) or [DBeaver](https://dbeaver.io/)

---

## 📦 Installation

### 1. Clone the Repository

  ```bash
  git clone https://github.com/your-username/your-liferay-project.git
  cd your-liferay-project
  ```
### 2. 🗄️ Set Up the Database

> Liferay supports various relational databases, including **PostgreSQL**, **MySQL**, and **MariaDB**.
Choose a database and create the necessary schema and user before starting the portal.

---

#### 🐘 PostgreSQL Example

  ```sql
  CREATE DATABASE lportal;
  CREATE USER liferay WITH PASSWORD 'liferay';
  GRANT ALL PRIVILEGES ON DATABASE lportal TO liferay;
  ```

#### 🐬 MySQL / MariaDB Example
  
  ```sql
  CREATE DATABASE lportal DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
  CREATE USER 'liferay'@'localhost' IDENTIFIED BY 'liferay';
  GRANT ALL PRIVILEGES ON lportal.* TO 'liferay'@'localhost';
  FLUSH PRIVILEGES;
  ```

---

### 3. 🛠️ JDBC Configuration in portal-ext.properties
Create or edit portal-ext.properties in your Liferay bundle root directory.

---

#### 🐘 PostgreSQL Example

  ```properties
  jdbc.default.driverClassName=org.postgresql.Driver
  jdbc.default.url=jdbc:postgresql://localhost:5432/lportal
  jdbc.default.username=liferay
  jdbc.default.password=liferay
  ```
  
#### 🐬 MySQL / MariaDB Example

  ```properties
  jdbc.default.driverClassName=com.mysql.cj.jdbc.Driver
  jdbc.default.url=jdbc:mysql://localhost:3306/lportal?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
  jdbc.default.username=liferay
  jdbc.default.password=liferay
  ```
---
