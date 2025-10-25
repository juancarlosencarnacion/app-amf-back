# 💰 app-amf-back

**Backend de la Aplicación de Manejo Financiero (AMF)**

Esta API REST es el componente backend central para la gestión financiera, construida con **Spring Boot** y **Java 21**. Proporciona un conjunto completo de endpoints para la administración de usuarios, categorías, tipos de presupuesto, presupuestos y transacciones (ingresos/gastos).

---

## 🚀 Tecnologías

El proyecto ha sido desarrollado utilizando las siguientes herramientas y tecnologías:

| Herramienta / Tecnología | Versión / Tipo | Propósito |
| :--- | :--- | :--- |
| **Java** | 21 | Lenguaje de programación. |
| **Spring Boot** | 3.x (o superior) | Framework principal para la creación de la API. |
| **Spring Data JPA** | - | Persistencia y manejo de la base de datos. |
| **PostgreSQL** | `latest` (vía Docker) | Base de datos relacional. |
| **Docker Compose** | - | Orquestación para levantar la BD PostgreSQL. |
| **Lombok** | - | Reducción de código *boilerplate* (getters, setters, constructores, etc.). |
| **Swagger/OpenAPI** | - | Documentación interactiva de la API. |
| **CORS** | Configurado | Gestión de Cross-Origin Resource Sharing. |
| **Validación** | Jakarta Bean Validation | Validación de campos en DTOs. |

---

## ⚙️ Arquitectura del Proyecto

El proyecto sigue una arquitectura modular y por capas (Controller, Service, Repository) y utiliza **DTOs** para la transferencia de datos:

* `es.amf.appamfback.controller`: Contiene los **Controladores** (`@RestController`) que manejan las peticiones HTTP.
* `es.amf.appamfback.service`: Contiene la **Lógica de Negocio** (Servicios, `@Service`) e implementa validaciones.
* `es.amf.appamfback.repository`: Contiene las interfaces **Repositorios** (`@Repository`) para la comunicación con PostgreSQL vía JPA.
* `es.amf.appamfback.entity`: Define las clases **Entidad** (`@Entity`) que mapean las tablas de la base de datos (User, Category, Budget, Transaction, TypeBudget).
* `es.amf.appamfback.dto`: Contiene los **DTOs** (Data Transfer Objects) para entrada y salida de datos.

---

## 📊 Modelo de Datos (Esquema Básico)

La API gestiona las siguientes entidades:

1.  **User**: Datos del usuario (con validaciones en campos como email, password).
2.  **Category**: Categorías de transacciones/presupuestos (e.g., Comida, Transporte).
3.  **TypeBudget**: Define la periodicidad de los presupuestos (e.g., Mensual, Anual).
4.  **Budget**: Permite al usuario registrar un presupuesto asociado a un **User**, una **Category** y un **TypeBudget**.
5.  **Transaction**: Registra un gasto o ingreso asociado a un **User** y una **Category**.

---

## 🛠️ Configuración y Ejecución Local

### 1. Requisitos Previos

* **Java 21** JDK
* **Maven** (para construir el proyecto)
* **Docker** y **Docker Compose** (para la base de datos)

### 2. Base de Datos con Docker Compose

La base de datos PostgreSQL se levanta con Docker Compose. Crea un archivo `docker-compose.yml` en la raíz del proyecto:

```yaml
version: '3.8'
services:
  postgres-db:
    image: postgres:latest
    container_name: amf_postgres
    environment:
      POSTGRES_DB: amf_db
      POSTGRES_USER: amf_user
      POSTGRES_PASSWORD: amf_password
    ports:
      - "5434:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
