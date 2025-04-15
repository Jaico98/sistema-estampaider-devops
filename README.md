# Estampaider Microservicios

Proyecto de sistema distribuido basado en microservicios con Spring Boot, Spring Cloud y WebFlux.  
Inspirado en un sistema educativo, adaptado para la gestión de productos, pedidos y usuarios.

---

##  Tecnologías

- Spring Boot 2.6.6
- Spring Cloud Eureka
- Spring Cloud Config
- Spring WebFlux
- JWT (Json Web Token)
- Feign Client
- MongoDB
- Maven

---

##  Microservicios

| Servicio             | Puerto | Función                                 |
|----------------------|--------|------------------------------------------|
| Config Server        | 8089   | Centraliza configuración                |
| Eureka Server        | 8761   | Registro de servicios                   |
| Gateway              | 8080   | Entrada única (proxy API)              |
| usuarios-servicio    | 8081   | Login y autenticación (JWT)            |
| productos-servicio   | 8082   | CRUD de productos (protegido)          |
| pedidos-servicio     | 8083   | CRUD de pedidos, consume otros servicios|

---

##  Seguridad JWT

- `/auth/login` genera un token (usuarios-servicio).
- `productos` y `pedidos` requieren header:
  
##  Endpoints clave
POST /api/usuarios/auth/login → retorna token
GET  /api/productos           → requiere token
GET  /api/pedidos             → requiere token
