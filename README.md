# 📄 Document Storage Management System (Liferay + Java EE + MVC)

A simple, modular web-based application built using **Java EE** and **Liferay MVC** architecture for managing **documents**, **tags**, and related data with a clean user interface and layered architecture.

---

## 🔧 Tech Stack

- **Java EE (JSP)**
- **Liferay MVC Framework**
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
| `document-data` | Contains service builder-generated code for persistence, service APIs, and model objects |
| `document-service` | Business logic layer that retrieves data, applies logic, and returns ViewModels |
| `document-web` | User interface layer with Liferay portlets (MVC), controllers, and JSP pages |

---


### 📥 Clone the Repository

```bash
git clone https://github.com/UhtredRegress/J2ee-Final.git
cd J2ee-Final
