# Estampaider - Sistema de Gestión de Estampados

Proyecto final de la asignatura DevOps. Sistema distribuido basado en microservicios con autenticación JWT, monitoreo, despliegue con Docker Compose y CI/CD con GitHub Actions.

---

## Arquitectura del Proyecto

El sistema está compuesto por los siguientes microservicios:

| Microservicio         | Puerto | Descripción                                         |
|------------------------|--------|-----------------------------------------------------|
| usuarios-servicio      | 8081   | Gestión de usuarios con login, registro y roles JWT |
| productos-servicio     | 8082   | CRUD de productos (antes asignaturas-servicio)     |
| pedidos-servicio       | 8083   | Gestión de pedidos (antes matriculas-servicio)     |
| config-server          | 8089   | Configuración centralizada desde GitHub            |
| eureka-server          | 8761   | Registro y descubrimiento de microservicios        |
| gateway-servicio       | 8080   | Enrutamiento y punto de entrada único (API Gateway)|
| MongoDB                | 27017  | Base de datos NoSQL para todos los servicios       |
| Prometheus             | 9090   | Recolección de métricas del sistema                |
| Grafana                | 3000   | Visualización de métricas y dashboards             |

---

## Seguridad con JWT

- Registro e inicio de sesión: `/auth/register`, `/auth/login`
- Se genera un token que debe enviarse en el header `Authorization: Bearer <token>` para acceder a los endpoints protegidos.
- Roles soportados: `ADMIN`, `USER`.

---

## Comunicación entre Servicios

- `pedidos-servicio` se comunica con `usuarios-servicio` y `productos-servicio` mediante **Feign Client**.

---

## 🔍 Endpoints Clave

| Endpoint                        | Método | Servicio            | Seguridad |
|---------------------------------|--------|----------------------|-----------|
| `/auth/login`                   | POST   | usuarios-servicio    | Público   |
| `/auth/register`                | POST   | usuarios-servicio    | Público   |
| `/api/productos`                | GET    | productos-servicio   | JWT       |
| `/api/pedidos`                  | GET    | pedidos-servicio     | JWT       |
| `/actuator/info`                | GET    | Todos                | Público   |
| `/actuator/metrics`             | GET    | Todos                | Público   |

---

## Monitoreo y Observabilidad

- **Spring Boot Actuator** habilitado en todos los microservicios.
- **Prometheus** recolecta métricas automáticamente.
- **Grafana** visualiza dashboards personalizados.
- Endpoints como `/actuator/metrics`, `/actuator/health` y `/actuator/info` están expuestos.

---

## Despliegue

```bash
- docker-compose up --build

---

## CI/CD 

- GitHub Actions implementado en .github/workflows/test.yml

- Ejecuta automáticamente mvn test al hacer push en el repositorio.

---

## Pruebas

- Pruebas unitarias con Mockito y JUnit 5.

- Pruebas de integración con WebTestClient.

- Postman usado para verificar endpoints y autenticación.

