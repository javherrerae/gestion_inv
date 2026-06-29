# Diagnóstico actualizado del Proyecto de Microservicios - Royal Logistics

## 1. Resumen ejecutivo actualizado

Este documento actualiza el diagnóstico técnico del proyecto **Royal Logistics** a partir de la revisión del nuevo ZIP del proyecto y del README de diagnóstico anterior. El objetivo es dejar una versión ordenada para cargar a GitHub, mostrando con claridad qué elementos están listos, cuáles avanzaron respecto del análisis previo y qué puntos siguen pendientes antes de la entrega o defensa.

El proyecto presenta mejoras importantes respecto del diagnóstico anterior. Ahora se evidencia un **README general en la raíz**, un **docker-compose.yml**, **Dockerfiles para la mayoría de los servicios**, pruebas unitarias reales con **JUnit y Mockito** en varios módulos, documentación Swagger/OpenAPI mediante anotaciones `@Tag` y `@Operation`, configuración centralizada de Swagger en el API Gateway y una estructura Maven multi-módulo más clara.

La base técnica del proyecto es defendible: existe arquitectura de microservicios, más de 10 servicios, Eureka Server, API Gateway, comunicación REST mediante Feign Client, separación Controller-Service-Repository, reglas de negocio distribuidas y documentación técnica inicial. Además, el proyecto ya no depende solo de pruebas `contextLoads()`, porque varios servicios incorporan pruebas de controller y service con mocks, asserts y validaciones de error.

Sin embargo, todavía existen brechas que conviene cerrar. Las más relevantes son: la configuración sigue estando en `application.properties` y no en `application.yml`; el microservicio de autenticación existe pero no expone endpoints funcionales; el despliegue Docker está iniciado, pero no cubre todos los servicios y requiere ajustar detalles; algunos servicios no tienen pruebas; y Swagger todavía puede fortalecerse con `@ApiResponse`, descripciones de errores y ejemplos de request/response.

En síntesis, el proyecto pasó de estar **parcialmente implementado** a estar **bastante más sólido y defendible**, pero aún requiere ajustes puntuales para alinearse mejor con la pauta de Unidad III.

---

## 2. Cambios relevantes detectados respecto del diagnóstico anterior

| Área | Estado anterior | Estado actualizado | Comentario |
|---|---:|---:|---|
| README general | Pendiente | Listo/parcial | Ahora existe `README.md` en la raíz del proyecto. |
| Docker/despliegue | No evidenciado | Parcial | Ahora existe `docker-compose.yml` y varios `Dockerfile`. |
| Pruebas unitarias | Pendiente crítico | Parcialmente listo | Hay pruebas reales en varios servicios con Mockito y asserts. |
| Swagger/OpenAPI | Parcial básico | Parcial avanzado | Se agregaron anotaciones `@Tag` y `@Operation` en varios controllers. |
| API Gateway | Listo/parcial | Listo/parcial avanzado | Mantiene rutas funcionales y Swagger centralizado. |
| JaCoCo/cobertura | No evidenciado | Configurado en POM padre | Existe plugin JaCoCo con regla de 80% en el `pom.xml` padre. |
| YAML | Pendiente crítico | Sigue pendiente | No se encontraron archivos `application.yml` o `application.yaml`. |
| Autenticación | Incompleto | Sigue incompleto | El controller existe, pero no tiene `GET`, `POST`, `PUT` ni `DELETE`. |
| Creación de usuario | No destacado | Funcional básico | Tiene controller con endpoints para listar, registrar, listar activos, buscar por rol y eliminar. |

---

## 3. Estado general actualizado del proyecto

| Área evaluada | Estado actualizado | Comentario técnico |
|---|---:|---|
| Proyecto multi-módulo Maven | Listo | Existe `pom.xml` padre con módulos para Eureka, microservicios y Gateway. |
| Java 21 | Listo | El POM padre centraliza Java 21. |
| Spring Boot | Listo | El proyecto usa Spring Boot como base de los servicios. |
| Spring Cloud | Listo | Se usa Spring Cloud para Eureka, Gateway y Feign. |
| Cantidad mínima de microservicios | Listo | Hay 11 microservicios definidos, sin contar Eureka ni Gateway. |
| Eureka Server | Listo | Configurado en puerto `8761`. |
| Registro en Eureka | Listo/parcial | Los servicios tienen configuración para registrarse en Eureka. |
| API Gateway | Listo/parcial avanzado | Configurado en puerto `8080`, con rutas hacia servicios y documentación Swagger centralizada. |
| Comunicación REST entre microservicios | Listo/parcial | Existen Feign Clients entre servicios logísticos. |
| Patrón Controller-Service-Repository | Mayormente listo | La mayoría de módulos tiene controller, service, repository y model. |
| Swagger/OpenAPI | Parcial avanzado | Hay dependencias, Swagger centralizado y anotaciones `@Tag/@Operation`. Faltan respuestas y ejemplos. |
| Pruebas unitarias | Parcialmente listo | Hay pruebas reales en varios módulos, pero no en todos. |
| JaCoCo | Configurado | El POM padre tiene JaCoCo y regla de cobertura mínima del 80%. Falta evidenciar ejecución. |
| Docker | Parcial | Existen Dockerfiles y `docker-compose.yml`, pero no cubre autenticación ni creación-usuario. |
| YAML | Pendiente crítico | Todo sigue en `application.properties`. |
| README general | Listo/parcial | Existe README raíz, pero puede complementarse con diagnóstico, estado actual y pendientes. |
| Autenticación | Incompleto | El servicio existe, pero no expone endpoints funcionales. |

---

## 4. Estructura de módulos detectada

El proyecto mantiene una estructura multi-módulo Maven con los siguientes componentes:

| N° | Módulo | Tipo | Estado |
|---:|---|---|---:|
| 0 | `eureka-server` | Infraestructura / Discovery Server | Listo |
| 1 | `autenticacion` | Microservicio | Incompleto |
| 2 | `producto` | Microservicio | Listo/parcial avanzado |
| 3 | `creacion-usuario` | Microservicio | Listo/parcial |
| 4 | `anden` | Microservicio | Listo/parcial avanzado |
| 5 | `camion` | Microservicio | Listo/parcial avanzado |
| 6 | `recepcion` | Microservicio | Listo/parcial avanzado |
| 7 | `factura` | Microservicio | Listo/parcial avanzado |
| 8 | `desconsolidacion` | Microservicio | Listo/parcial avanzado |
| 9 | `warehouse` | Microservicio | Listo/parcial avanzado |
| 10 | `stock` | Microservicio | Listo/parcial avanzado |
| 11 | `movimiento` | Microservicio | Listo/parcial avanzado |
| 12 | `api-gateway` | Infraestructura / Gateway | Listo/parcial avanzado |

El proyecto cumple con el requisito de contar con más de 10 microservicios funcionales o definidos.

---

## 5. Puertos y rutas actuales

### 5.1 Puertos detectados en `application.properties`

| Servicio | `spring.application.name` | Puerto |
|---|---|---:|
| Eureka Server | `eureka-server` | `8761` |
| API Gateway | `api-gateway` | `8080` |
| Recepción | `recepcion` | `8081` |
| Camión | `camion` | `8082` |
| Andén | `anden` | `8083` |
| Desconsolidación | `desconsolidacion` | `8084` |
| Factura | `factura` | `8085` |
| Producto | `producto` | `8086` |
| Warehouse | `warehouse` | `8087` |
| Stock | `stock` | `8088` |
| Movimiento | `movimiento` | `8089` |
| Creación usuario | `creacion-usuario` | `8092` |
| Autenticación | `autenticacion` | `0`, puerto dinámico |

### 5.2 Rutas principales configuradas en el API Gateway

| Ruta Gateway | Servicio destino | URI lógica |
|---|---|---|
| `/api/credenciales/**` | autenticacion | `lb://autenticacion` |
| `/api/productos/**` | producto | `lb://producto` |
| `/api/empleados/**` | creacion-usuario | `lb://creacion-usuario` |
| `/api/andenes/**` | anden | `lb://anden` |
| `/api/camiones/**` | camion | `lb://camion` |
| `/api/recepciones/**` | recepcion | `lb://recepcion` |
| `/api/facturas/**` | factura | `lb://factura` |
| `/api/desconsolidaciones/**` | desconsolidacion | `lb://desconsolidacion` |
| `/api/warehouse/**` | warehouse | `lb://warehouse` |
| `/api/stock/**` | stock | `lb://stock` |
| `/api/movimientos/**` | movimiento | `lb://movimiento` |

---

## 6. Elementos que están listos

### 6.1 Arquitectura multi-módulo Maven

El proyecto cuenta con un `pom.xml` padre que organiza todos los módulos. Esto permite centralizar versiones, dependencias y configuración común.

Puntos positivos:

- Uso de `packaging` tipo `pom` en el proyecto raíz.
- Declaración de todos los módulos principales.
- Centralización de Java 21.
- Centralización de Spring Cloud.
- Centralización de Springdoc OpenAPI.
- Configuración de JaCoCo en el POM padre.

Estado: **listo**.

---

### 6.2 Eureka Server

El proyecto mantiene un Eureka Server configurado en el puerto `8761`.

Rol técnico:

- Permite el registro dinámico de microservicios.
- Habilita el descubrimiento de servicios por nombre lógico.
- Reduce dependencia de IPs y puertos fijos.
- Permite que el Gateway consuma servicios mediante `lb://nombre-servicio`.

Estado: **listo**.

---

### 6.3 API Gateway

El API Gateway está configurado en el puerto `8080` y define rutas hacia los microservicios principales.

Puntos positivos:

- Usa rutas `lb://`, lo que indica integración con Eureka.
- Centraliza el acceso externo a los microservicios.
- Incluye rutas funcionales hacia los servicios logísticos.
- Incluye rutas para Swagger/OpenAPI centralizado.
- Expone Actuator con `health`, `info` y `gateway`.

Estado: **listo/parcial avanzado**.

Observación: el Gateway está bien encaminado, pero se recomienda probar todas las rutas desde Postman o Swagger y documentar evidencia de funcionamiento.

---

### 6.4 Swagger/OpenAPI

El proyecto mejoró bastante en este punto. Se detectaron anotaciones de documentación en varios controllers, por ejemplo:

- `@Tag`
- `@Operation`

Servicios con documentación Swagger detectada:

| Servicio | Estado Swagger |
|---|---:|
| Producto | Documentado con `@Tag/@Operation` |
| Stock | Documentado con `@Tag/@Operation` |
| Andén | Documentado con `@Tag/@Operation` |
| Camión | Documentado con `@Tag/@Operation` |
| Recepción | Documentado con `@Tag/@Operation` |
| Factura | Documentado con `@Tag/@Operation` |
| Desconsolidación | Documentado con `@Tag/@Operation` |
| Warehouse | Documentado con `@Tag/@Operation` |
| Movimiento | Documentado con `@Tag/@Operation` |

Además, el Gateway incluye configuración para mostrar Swagger centralizado en:

```text
http://localhost:8080/swagger-ui.html
```

y también puede usarse, según configuración de Springdoc, una ruta tipo:

```text
http://localhost:8080/swagger-ui/index.html
```

Estado: **parcial avanzado**.

Pendiente recomendado:

- Agregar `@ApiResponses`.
- Agregar códigos HTTP esperados: `200`, `201`, `400`, `404`, `500`.
- Agregar descripción de errores de negocio.
- Agregar ejemplos de request/response si el tiempo lo permite.

---

### 6.5 Pruebas unitarias reales

Este punto mejoró de forma importante. Ya no existen solamente pruebas `contextLoads()`. Ahora se identifican pruebas reales en varios servicios, especialmente para `controller` y `service`.

Servicios con pruebas detectadas:

| Servicio | Archivos de prueba | Estado |
|---|---:|---:|
| Producto | 2 | Parcialmente listo |
| Stock | 2 | Parcialmente listo |
| Andén | 2 | Parcialmente listo |
| Camión | 2 | Parcialmente listo |
| Recepción | 2 | Parcialmente listo |
| Factura | 2 | Parcialmente listo |
| Desconsolidación | 2 | Parcialmente listo |
| Warehouse | 2 | Parcialmente listo |
| Movimiento | 2 | Parcialmente listo |
| Eureka Server | 1 | Básico |

Las pruebas contienen elementos relevantes para la pauta:

- `@Test`.
- `@Mock`.
- `@InjectMocks`.
- `Mockito.when(...)`.
- `Mockito.verify(...)`.
- `assertEquals(...)`.
- `assertNotNull(...)`.
- `assertThrows(...)`.

Estado: **parcialmente listo**.

Brecha restante: autenticación, creación-usuario y API Gateway no tienen pruebas equivalentes en el ZIP revisado.

---

### 6.6 JaCoCo

El POM padre contiene configuración de JaCoCo con regla de cobertura mínima de 80%.

Esto es positivo porque se alinea con criterios de evaluación asociados a cobertura.

Estado: **configurado**.

Pendiente: ejecutar y evidenciar el reporte real de cobertura, por ejemplo:

```bash
mvn clean verify
```

Luego revisar los reportes generados en:

```text
target/site/jacoco/index.html
```

No se pudo validar la ejecución desde este entorno porque no está instalado el comando `mvn`.

---

### 6.7 Docker y docker-compose

El proyecto ahora incluye `docker-compose.yml` y Dockerfiles en varios servicios.

Servicios con Dockerfile detectado:

| Servicio | Dockerfile |
|---|---:|
| Eureka Server | Sí |
| API Gateway | Sí |
| Producto | Sí |
| Andén | Sí |
| Camión | Sí |
| Recepción | Sí |
| Factura | Sí |
| Desconsolidación | Sí |
| Warehouse | Sí |
| Stock | Sí |
| Movimiento | Sí |

Servicios sin Dockerfile detectado:

| Servicio | Observación |
|---|---|
| Autenticación | No se detectó Dockerfile. |
| Creación usuario | No se detectó Dockerfile. |

Estado: **parcial**.

Observación técnica: el `docker-compose.yml` contiene MySQL con puerto:

```yaml
ports:
  - "3307:3307"
```

MySQL normalmente escucha dentro del contenedor en `3306`. Si se quiere exponer MySQL al host por el puerto 3307, lo recomendado sería:

```yaml
ports:
  - "3307:3306"
```

Dentro de la red Docker, los microservicios pueden seguir usando:

```text
mysql-db:3306
```

---

### 6.8 README general

Ahora existe un README general en la raíz del proyecto.

Incluye:

- descripción del sistema;
- objetivo del proyecto;
- flujo logístico general;
- arquitectura;
- tecnologías utilizadas;
- referencia a Eureka;
- orden de ejecución;
- acceso a Eureka.

Estado: **listo/parcial**.

Recomendación: complementar el README raíz con la matriz de estado actual, tabla de puertos, rutas Gateway, comandos de Docker, comandos de test y checklist final.

---

## 7. Elementos parciales o todavía débiles

### 7.1 YAML sigue pendiente

Se revisaron los archivos de configuración y todos los servicios siguen usando:

```text
application.properties
```

No se detectaron archivos:

```text
application.yml
application.yaml
```

Estado: **pendiente crítico**.

La pauta o directriz de Unidad III solicita configuración YAML. Por lo tanto, este punto sigue siendo uno de los pendientes principales.

Recomendación mínima:

- Migrar primero `api-gateway` y `eureka-server`.
- Luego migrar los servicios principales: producto, stock, recepción, factura, movimiento.
- Finalmente migrar el resto para consistencia.

---

### 7.2 Autenticación sigue incompleta

El microservicio `autenticacion` existe y tiene:

- `AutenticacionApplication`.
- `Credencial`.
- `CredencialRepository`.
- `CredencialService`.
- `CredencialController`.

Sin embargo, el controller solo tiene:

```java
@RestController
@RequestMapping("/api/credenciales")
public class CredencialController {
    @Autowired
    private CredencialService credencialService;
}
```

No se detectaron métodos:

```java
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
```

Estado: **incompleto**.

Opciones:

1. Completar autenticación con endpoints básicos.
2. No defender autenticación como servicio funcional central.
3. Explicar que el foco funcional está en los microservicios logísticos y que autenticación queda como mejora futura.

Recomendación: si queda poco tiempo, agregar al menos endpoints CRUD básicos o un endpoint simple `/login`.

---

### 7.3 Creación de usuario no tiene pruebas detectadas

El microservicio `creacion-usuario` tiene controller funcional con endpoints para:

- listar empleados;
- registrar empleado;
- listar activos;
- buscar por rol;
- eliminar empleado.

Sin embargo, no se detectaron pruebas unitarias para este módulo.

Estado: **funcional, pero sin testing evidenciado**.

Recomendación: agregar al menos:

- `EmpleadoServiceTest`.
- `EmpleadoControllerTest`.

---

### 7.4 Swagger todavía puede fortalecerse

Aunque se agregaron `@Tag` y `@Operation`, todavía no se observó una documentación completa con:

- `@ApiResponses`;
- `@ApiResponse`;
- `@Parameter`;
- `@Schema`;
- ejemplos de request y response;
- descripción de errores de negocio.

Estado: **parcial avanzado**.

Recomendación práctica: agregar `@ApiResponses` a los endpoints `POST` y `DELETE`, porque son los que más suelen tener errores de negocio.

Ejemplo:

```java
@Operation(
    summary = "Registrar producto",
    description = "Crea un producto validando SKU, fechas y desconsolidación asociada."
)
@ApiResponses({
    @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos o regla de negocio incumplida"),
    @ApiResponse(responseCode = "404", description = "Recurso asociado no encontrado")
})
@PostMapping
public ResponseEntity<?> registrar(@RequestBody Producto producto) {
    // lógica del controlador
}
```

---

### 7.5 Docker está iniciado, pero debe validarse

El despliegue Docker avanzó, pero todavía se debe validar en ejecución real.

Pendientes de Docker:

- Agregar Dockerfile a autenticación, si se decide mantenerlo.
- Agregar Dockerfile a creación-usuario.
- Revisar el puerto MySQL en `docker-compose.yml`.
- Confirmar que todos los JAR existan antes del `docker compose up --build`.
- Documentar el comando de construcción Maven antes de levantar contenedores.
- Agregar `depends_on` no garantiza que MySQL esté listo; si hay errores, se podría requerir healthcheck o reintentos.

Estado: **parcial**.

---

### 7.6 Consistencia de paquetes

Aún se observan paquetes con mayúsculas en algunos módulos, por ejemplo:

```text
Controller
Service
Repository
Model
```

Mientras otros usan:

```text
controller
service
repository
model
```

Estado: **mejora recomendada**.

No es necesariamente un error funcional, pero en Java se recomienda usar nombres de paquetes en minúscula.

---

## 8. Matriz actualizada de cumplimiento contra pauta

| Indicador / criterio | Estado actualizado | Evidencia / comentario |
|---|---:|---|
| Arquitectura de microservicios | Listo | Proyecto separado en servicios independientes. |
| Mínimo 10 microservicios | Listo | Hay 11 microservicios definidos. |
| Maven multi-módulo | Listo | Existe POM padre con módulos. |
| Spring Boot | Listo | Servicios implementados con Spring Boot. |
| Java 21 | Listo | Centralizado en POM padre. |
| Eureka Server | Listo | Servicio de descubrimiento en puerto `8761`. |
| Registro de servicios en Eureka | Listo/parcial | Configurado en servicios mediante Eureka Client. |
| API Gateway | Listo/parcial avanzado | Gateway en puerto `8080`, rutas `lb://`. |
| Interoperabilidad vía Gateway | Listo/parcial | Rutas configuradas para servicios principales. |
| Feign Client | Listo/parcial | Se observa comunicación entre servicios. |
| Patrón CSR | Mayormente listo | Controllers, Services y Repositories en la mayoría de módulos. |
| Reglas de negocio | Aceptable | Existen validaciones en services. |
| Swagger/OpenAPI | Parcial avanzado | Hay `@Tag`, `@Operation` y Swagger centralizado. |
| Pruebas unitarias | Parcialmente listo | Hay pruebas reales en 9 servicios logísticos, faltan otros módulos. |
| Mockito / asserts | Parcialmente listo | Presente en pruebas revisadas. |
| JaCoCo / cobertura | Configurado | POM padre tiene plugin y regla de 80%. Falta reporte ejecutado. |
| YAML | No logrado | No se detectaron `application.yml`. |
| Docker/despliegue | Parcial | Hay Dockerfiles y compose, pero incompleto y por validar. |
| README general | Listo/parcial | Existe README raíz, se recomienda complementarlo. |
| Autenticación | Incompleto | Servicio creado, sin endpoints funcionales. |
| Trello / gestión ágil | No evidenciado en ZIP | Debe adjuntarse o enlazarse si la pauta lo exige. |
| GitHub | No evaluable desde ZIP | Debe revisarse en el repositorio real. |

---

## 9. Checklist actualizado antes de entregar

### 9.1 Arquitectura

- [x] Proyecto multi-módulo Maven.
- [x] Java 21 configurado.
- [x] Más de 10 microservicios.
- [x] Eureka Server.
- [x] API Gateway.
- [x] Comunicación mediante Feign Client.
- [x] Separación general Controller-Service-Repository.
- [ ] Normalizar nombres de paquetes en minúscula.

### 9.2 Documentación

- [x] README general en la raíz.
- [x] README de diagnóstico listo/pendiente.
- [x] Changelog del proyecto.
- [x] Tabla conceptual de servicios.
- [x] Flujo logístico general.
- [ ] Agregar tabla final de puertos al README principal.
- [ ] Agregar tabla final de rutas Gateway al README principal.
- [ ] Agregar comandos exactos de test.
- [ ] Agregar comandos exactos de Docker.
- [ ] Agregar evidencia o capturas de Eureka.
- [ ] Agregar evidencia o capturas de Swagger.

### 9.3 Testing

- [x] Pruebas reales en Producto.
- [x] Pruebas reales en Stock.
- [x] Pruebas reales en Andén.
- [x] Pruebas reales en Camión.
- [x] Pruebas reales en Recepción.
- [x] Pruebas reales en Factura.
- [x] Pruebas reales en Desconsolidación.
- [x] Pruebas reales en Warehouse.
- [x] Pruebas reales en Movimiento.
- [x] Uso de Mockito.
- [x] Uso de asserts.
- [x] Uso de `assertThrows` en casos de error.
- [x] JaCoCo configurado en POM padre.
- [ ] Pruebas para Creación-Usuario.
- [ ] Pruebas para Autenticación, si se mantiene como servicio funcional.
- [ ] Pruebas para API Gateway, si la pauta lo exige.
- [ ] Ejecutar `mvn clean verify` y guardar evidencia de cobertura.

### 9.4 Configuración

- [x] `application.properties` funcionales.
- [x] Puertos definidos por servicio.
- [x] Nombres de servicios definidos con `spring.application.name`.
- [x] Rutas `lb://` en Gateway.
- [ ] Migrar `application.properties` a `application.yml`.
- [ ] Validar que Swagger centralizado resuelva todos los `/v3/api-docs`.
- [ ] Confirmar que todos los servicios se registren correctamente en Eureka.

### 9.5 Swagger/OpenAPI

- [x] Dependencia Springdoc instalada.
- [x] Swagger individual por microservicio.
- [x] Swagger centralizado en Gateway.
- [x] Uso de `@Tag`.
- [x] Uso de `@Operation`.
- [ ] Agregar `@ApiResponses`.
- [ ] Agregar códigos de error documentados.
- [ ] Agregar ejemplos de request/response.
- [ ] Verificar documentación de `creacion-usuario` y `autenticacion`.

### 9.6 Docker/despliegue

- [x] Existe `docker-compose.yml`.
- [x] Dockerfile para Eureka.
- [x] Dockerfile para Gateway.
- [x] Dockerfile para Producto.
- [x] Dockerfile para Andén.
- [x] Dockerfile para Camión.
- [x] Dockerfile para Recepción.
- [x] Dockerfile para Factura.
- [x] Dockerfile para Desconsolidación.
- [x] Dockerfile para Warehouse.
- [x] Dockerfile para Stock.
- [x] Dockerfile para Movimiento.
- [ ] Dockerfile para Autenticación.
- [ ] Dockerfile para Creación-Usuario.
- [ ] Corregir o validar mapeo de puerto MySQL.
- [ ] Probar `docker compose up --build`.
- [ ] Documentar si el despliegue final es local, Docker, Render o Railway.

### 9.7 Autenticación

- [x] Módulo creado.
- [x] Entidad `Credencial` creada.
- [x] Repository creado.
- [x] Service creado.
- [x] Controller creado.
- [ ] Agregar endpoints REST.
- [ ] Agregar lógica de validación o login básico.
- [ ] Agregar pruebas unitarias.
- [ ] Agregar documentación Swagger.

---

## 10. Pendientes priorizados

### Prioridad 1: Migrar a YAML

Este sigue siendo el pendiente más claro frente a las directrices de configuración.

Orden sugerido:

1. `api-gateway`.
2. `eureka-server`.
3. `producto`.
4. `stock`.
5. `recepcion`.
6. `factura`.
7. resto de servicios.

Ejemplo base para Eureka:

```yaml
server:
  port: 8761

spring:
  application:
    name: eureka-server

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

Ejemplo base para Gateway:

```yaml
server:
  port: 8080

spring:
  application:
    name: api-gateway
  cloud:
    gateway:
      routes:
        - id: producto
          uri: lb://producto
          predicates:
            - Path=/api/productos/**
        - id: stock
          uri: lb://stock
          predicates:
            - Path=/api/stock/**

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
    register-with-eureka: true
    fetch-registry: true
```

---

### Prioridad 2: Completar autenticación o excluirla como servicio principal

El servicio de autenticación es el punto funcional más débil.

Endpoints mínimos recomendados:

| Método | Ruta | Propósito |
|---|---|---|
| `GET` | `/api/credenciales` | Listar credenciales. |
| `POST` | `/api/credenciales` | Crear credencial. |
| `POST` | `/api/credenciales/login` | Validar usuario y contraseña. |
| `DELETE` | `/api/credenciales/{id}` | Eliminar o desactivar credencial. |

Si no se completa, conviene no presentarlo como servicio principal en la defensa.

---

### Prioridad 3: Cerrar pruebas faltantes

Ya hay buen avance en testing, pero falta cubrir:

- `creacion-usuario`;
- `autenticacion`, si se mantiene;
- eventualmente `api-gateway`.

Para `creacion-usuario`, agregar casos como:

- registrar empleado válido;
- rechazar empleado duplicado o inválido, si existe regla;
- listar empleados activos;
- buscar por rol;
- eliminar empleado.

---

### Prioridad 4: Fortalecer Swagger

Agregar `@ApiResponses` a endpoints principales:

- `POST /api/productos`.
- `POST /api/stock`.
- `POST /api/recepciones`.
- `POST /api/facturas`.
- `POST /api/desconsolidaciones`.
- `POST /api/movimientos`.
- `DELETE` de servicios principales.

---

### Prioridad 5: Validar Docker

Antes de entregar, probar:

```bash
mvn clean package -DskipTests
```

Luego:

```bash
docker compose up --build
```

Validar:

```text
http://localhost:8761
http://localhost:8080/swagger-ui.html
http://localhost:8080/actuator/health
```

Revisar especialmente el puerto de MySQL en `docker-compose.yml`.

---

## 11. Recomendación para defensa oral actualizada

El orden recomendado para presentar el proyecto es:

1. Explicar el problema logístico que resuelve Royal Logistics.
2. Mostrar el flujo operacional: recepción, factura, desconsolidación, producto, warehouse, stock y movimiento.
3. Mostrar el `pom.xml` padre y los módulos.
4. Explicar Eureka Server como registro dinámico de servicios.
5. Mostrar el API Gateway y las rutas `lb://`.
6. Mostrar Swagger centralizado desde el Gateway.
7. Mostrar un flujo entre microservicios usando Feign Client.
8. Mostrar una regla de negocio dentro de un `Service`.
9. Mostrar una prueba unitaria con Mockito y asserts.
10. Mostrar Dockerfile y docker-compose como evidencia de despliegue local.
11. Declarar pendientes menores con transparencia: YAML, autenticación y validación final de cobertura.

Respuesta sugerida si preguntan por Eureka:

> Eureka Server cumple el rol técnico de servidor de descubrimiento de servicios. Cada microservicio se registra con su nombre lógico mediante `spring.application.name`, y el API Gateway puede encontrarlos usando rutas `lb://`, sin depender directamente de puertos o direcciones fijas. Esto desacopla la arquitectura y facilita escalabilidad y balanceo de carga.

Respuesta sugerida si preguntan por autenticación:

> El microservicio de autenticación está creado dentro de la arquitectura, con entidad, repository, service y controller base. Sin embargo, sus endpoints funcionales todavía deben completarse. El núcleo funcional defendible del sistema está en los servicios logísticos, que superan el mínimo solicitado y están integrados mediante Eureka, Gateway y Feign Client.

Respuesta sugerida si preguntan por YAML:

> Actualmente la configuración está funcional en `application.properties`. La migración a `application.yml` queda como ajuste pendiente para alinearse completamente con la directriz de configuración YAML.

---

## 12. Veredicto final actualizado

El proyecto **mejoró considerablemente** respecto del diagnóstico anterior.

Antes, los principales puntos débiles eran testing, README, Swagger, Docker y documentación general. En la versión revisada, varios de esos puntos ya están abordados:

- existe README raíz;
- existe Docker Compose;
- existen Dockerfiles para varios servicios;
- existen pruebas reales con Mockito y asserts;
- existe Swagger documentado con `@Tag` y `@Operation`;
- existe JaCoCo configurado;
- existe Gateway con rutas funcionales y Swagger centralizado.

El proyecto actualmente es **defendible como arquitectura de microservicios**, especialmente por su cantidad de servicios, separación de responsabilidades, uso de Eureka, Gateway, Feign Client y testing parcial.

Los pendientes que más conviene cerrar antes de entregar son:

1. Migrar configuración a YAML.
2. Completar o justificar autenticación.
3. Agregar pruebas faltantes para creación-usuario y autenticación.
4. Fortalecer Swagger con respuestas HTTP y errores.
5. Validar Docker Compose y corregir el puerto MySQL si corresponde.
6. Ejecutar `mvn clean verify` y guardar evidencia de cobertura JaCoCo.
7. Añadir al README principal las tablas finales de puertos, rutas, pruebas y despliegue.

Con esos ajustes, el proyecto quedaría mucho más alineado con la pauta y mejor preparado para defensa técnica.

---

## 13. Estado resumido final

| Categoría | Estado |
|---|---:|
| Arquitectura base | Listo |
| Microservicios mínimos | Listo |
| Eureka | Listo |
| Gateway | Listo/parcial avanzado |
| Feign Client | Listo/parcial |
| Swagger | Parcial avanzado |
| Testing | Parcialmente listo |
| JaCoCo | Configurado |
| Docker | Parcial |
| README | Listo/parcial |
| YAML | Pendiente crítico |
| Autenticación | Pendiente funcional |
| Defensa técnica | Defendible con observaciones |
