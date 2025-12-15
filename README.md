# S-Canteen Menu Management API  
**GDG on Campus – Backend Volunteer Selection Task**

## Overview
This repository contains a Spring Boot backend module developed for the **GDG on Campus Backend Volunteer Selection Task**.  
The project implements a **Menu Management API** for a college canteen, focusing on clean REST design, proper layering, validation, and professional GitHub practices.

This module is intentionally scoped to test backend fundamentals rather than full-scale application development.

---

## Problem Statement
Canteen administrators must be able to:
- Add new food items  
- Retrieve all available items  
- Update existing items  
- Delete items  

Each food item includes:
- `id` – Auto-generated unique ID  
- `name` – Item name  
- `price` – Price of the item  
- `category` – Category (Breakfast, Drinks, etc.)  
- `availability` – Availability status  

---

## API Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/items` | Create a new item |
| GET | `/api/items` | Retrieve all items |
| PUT | `/api/items/{id}` | Update an item |
| DELETE | `/api/items/{id}` | Delete an item |

---

## Tech Stack
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 In-Memory Database  
- Maven  

---

## Project Structure
```

controller   → REST endpoints
service      → Business logic
repository   → JPA repositories
entity       → Database models
dto          → Request/response models
exception    → Global error handling

````

---

## Features
- RESTful CRUD APIs  
- Input validation (price > 0, name not blank)  
- Meaningful error responses  
- Layered architecture  
- DTO usage  
- Clean commit history  

---

## Running the Application
```bash
mvn spring-boot:run
````

H2 Console:

```
http://localhost:8080/h2-console
```

---

## Author

**Aravinth K**