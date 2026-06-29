<div align="center">

<h1 style="color:#2563eb;">
Royal Logistics
</h1>

<h3>
Sistema de gestión logística basado en arquitectura de microservicios
</h3>

</div>

---

<h2 style="color:#2563eb;">📦 Descripción</h2>

<p>
Sistema de gestión logística basado en arquitectura de microservicios, orientado a operaciones Fulfillment, administración de Warehouse y control de inventario dentro de una cadena logística moderna.
</p>

<p>
El proyecto busca simular el funcionamiento de un centro de distribución similar a operaciones utilizadas actualmente por empresas fulfillment, donde distintos vendedores almacenan productos dentro de una misma red logística, manteniendo control, seguimiento y trazabilidad sobre cada operación realizada.
</p>

---

<h2 style="color:#2563eb;">🎯 Objetivo del proyecto</h2>

<p>
El objetivo principal del sistema consiste en desarrollar una plataforma logística modular capaz de administrar procesos de:
</p>

<ul>
<li>recepción de mercadería</li>
<li>ingreso de facturas</li>
<li>desconsolidación de productos</li>
<li>almacenamiento en warehouse</li>
<li>control de stock</li>
<li>movimientos internos</li>
<li>seguimiento operacional</li>
</ul>

<p>
Todo esto mediante arquitectura de microservicios utilizando Spring Boot y APIs REST.
</p>

---

<h2 style="color:#2563eb;">📍 Flujo logístico general</h2>

<pre>
Agendamiento de recepción
        ↓
Llegada de camión
        ↓
Asignación de andén
        ↓
Recepción de factura
        ↓
Descarga de pallets / cajas
        ↓
Desconsolidación
        ↓
Registro de productos
        ↓
Asignación de ubicación
        ↓
Warehouse
        ↓
Actualización de stock
        ↓
Movimientos internos
        ↓
Seguimiento y trazabilidad
</pre>

---

<h2 style="color:#2563eb;">🏗️ Arquitectura de microservicios</h2>

<p>
El sistema fue diseñado bajo arquitectura de microservicios, donde cada módulo cumple una responsabilidad específica dentro de la cadena logística.
</p>

<p>
Cada microservicio posee:
</p>

<ul>
<li>lógica independiente</li>
<li>endpoints REST</li>
<li>base de datos desacoplada</li>
<li>responsabilidades separadas</li>
</ul>

---

<h2 style="color:#2563eb;">⚙️ Tecnologías utilizadas</h2>

<h3>Backend</h3>

<ul>
<li>Java 21</li>
<li>Spring Boot</li>
<li>Spring Data JPA</li>
<li>Hibernate</li>
<li>Maven</li>
<li>Lombok</li>
<li>Jakarta Validation</li>
</ul>

<h3>Arquitectura</h3>

<ul>
<li>Microservices</li>
<li>REST APIs</li>
<li>Eureka Server</li>
</ul>

<h3>Base de datos</h3>

<ul>
<li>MySQL</li>
<li>Oracle SQL Data Modeler</li>
</ul>

<h3>Herramientas/Software</h3>

<ul>
<li>Postman</li>
<li>Visual Studio Code</li>
<li>IntelliJ IDEA</li>
</ul>

---

<h2 style="color:#2563eb;">🗄️ Modelado de base de datos</h2>

<p>
Para visualizar el modelado relacional utilizado dentro del proyecto:
</p>

<ul>

<li>
Descargar Oracle SQL Data Modeler desde:
<a href="https://www.oracle.com/database/sqldeveloper/technologies/sql-data-modeler/download/" target="_blank">
Oracle SQL Data Modeler
</a>
</li>

<li>
Descargar y extraer la carpeta 
<a href="./modelado%20microservicios">
<b>modelado microservicios</b>
</a>
</li>

<li>
Abrir el proyecto desde Oracle SQL Data Modeler
</li>

</ul>

<p>
El modelado fue desarrollado previamente para mantener coherencia entre el flujo logístico y la arquitectura de microservicios.
</p>

---

<h2 style="color:#2563eb;">⭐ Características principales del sistema</h2>

<ul>
<li>Arquitectura desacoplada</li>
<li>Separación de responsabilidades</li>
<li>Gestión de Warehouse</li>
<li>Control de inventario</li>
<li>Seguimiento operacional</li>
<li>Gestión de ubicaciones</li>
<li>Registro de recepciones</li>
<li>Administración de productos</li>
<li>Escalabilidad modular</li>
<li>Trazabilidad logística</li>
</ul>

---

<h2 style="color:#2563eb;">📊 Estado actual del proyecto</h2>

El proyecto **Royal Logistics** se encuentra en estado defendible como ecosistema de microservicios. La versión actual incorpora configuración YAML, Eureka Server, API Gateway, documentación Swagger/OpenAPI, pruebas unitarias con JUnit 5 y Mockito, Docker Compose, script de inicialización de base de datos y guías de ejecución para Windows.

| Área | Estado | Observación |
|---|---:|---|
| Arquitectura de microservicios | Listo | Proyecto separado en módulos independientes. |
| Maven multi-módulo | Listo | Existe un `pom.xml` padre que centraliza módulos y dependencias. |
| Java 21 / Spring Boot | Listo | Los servicios están implementados con Spring Boot y Java 21. |
| Eureka Server | Listo | Servidor de descubrimiento disponible en el puerto `8761`. |
| API Gateway | Listo | Punto de entrada central disponible en el puerto `8080`. |
| YAML | Listo | La configuración fue migrada a `application.yml`. |
| Swagger/OpenAPI | Listo | Documentación centralizada desde el API Gateway. |
| Pruebas unitarias | Listo | Suite ejecutable con `mvn clean install`. |
| Docker Compose | Listo con observaciones | Levanta MySQL, Eureka, Gateway y microservicios logísticos principales. |
| Base de datos Docker | Listo | MySQL se ejecuta en contenedor y usa volumen persistente. |
| `docs/init.sql` | Listo | Crea las bases de datos necesarias al primer arranque de MySQL. |
| Autenticación | Parcial | Módulo creado, pero no forma parte del flujo logístico principal validado. |
| Creación de usuario | Parcial en Docker | Módulo creado y ruta Gateway configurada, pero no está incluido en el Docker Compose principal validado. |

---

<h2 style="color:#2563eb;">🧩 Componentes del sistema</h2>

El ecosistema considera los siguientes componentes principales:

```text
MySQL
Eureka Server
API Gateway
Microservicio de Andén
Microservicio de Camión
Microservicio de Recepción
Microservicio de Factura
Microservicio de Desconsolidación
Microservicio de Producto
Microservicio de Warehouse
Microservicio de Stock
Microservicio de Movimiento
```

> Nota: los módulos `autenticacion` y `creacion-usuario` existen dentro del proyecto. Sin embargo, el despliegue Docker validado se concentra en el flujo logístico principal.

---

<h2 style="color:#2563eb;">🧱 Estructura general del proyecto</h2>

La estructura esperada del proyecto considera los siguientes módulos y archivos principales:

```text
Royal Logistics/
├── 0. eureka-server/
├── 1. autenticacion/
├── 2. producto/
├── 3. creacion-usuario/
├── 4. anden/
├── 5. camion/
├── 6. recepcion/
├── 7. factura/
├── 8. desconsolidacion/
├── 9. warehouse/
├── 10. stock/
├── 11. movimiento/
├── 12. api-gateway/
├── docs/
│   └── init.sql
├── backups/
├── docker-compose.yml
├── Iniciar.bat
├── Cerrar.bat
├── README_Royal_Logistics.md
└── pom.xml
```

---

<h2 style="color:#2563eb;">⚙️ Requisitos previos</h2>

Antes de ejecutar el sistema, se debe contar con:

```text
Java 21 instalado.
Maven instalado.
Docker Desktop instalado.
Docker Desktop abierto y funcionando.
Puerto 8761 disponible para Eureka Server.
Puerto 8080 disponible para API Gateway.
Puerto 3307 disponible para MySQL Docker.
```

Para validar Docker desde CMD, PowerShell o la terminal de VSCode:

```bash
docker --version
```

```bash
docker compose version
```

```bash
docker info
```

Si aparece un error similar a:

```text
Cannot connect to the Docker daemon
```

significa que Docker Desktop no está abierto o que el motor de Docker aún no ha iniciado.

---

<h2 style="color:#2563eb;">🚀 Puesta en marcha nativa con script `.bat`</h2>

Además del despliegue con Docker, el sistema puede ejecutarse de forma nativa en Windows utilizando Maven. En este modo los microservicios corren directamente en el sistema operativo, no dentro de contenedores.

La ejecución nativa debe respetar el siguiente orden jerárquico de arranque:

```text
1. Eureka Server
2. Microservicios logísticos
3. API Gateway
```

Este orden es importante porque los microservicios necesitan registrarse primero en Eureka Server, y el API Gateway necesita consultar Eureka para enrutar las solicitudes hacia los servicios disponibles.

### Script sugerido: `Iniciar-Nativo.bat`

Crear un archivo llamado `Iniciar-Nativo.bat` en la raíz del proyecto con el siguiente contenido:

```bat
@echo off
title Royal Logistics - Ejecucion Nativa
cls

echo ==========================================================
echo        ROYAL LOGISTICS - EJECUCION NATIVA
echo ==========================================================
echo.

echo [1/3] Iniciando Eureka Server...
start "Eureka Server" cmd /k "cd /d ""0. eureka-server"" && mvn spring-boot:run"

echo Esperando inicializacion de Eureka Server...
timeout /t 15 /nobreak

echo.
echo [2/3] Iniciando microservicios logisticos...
start "Anden" cmd /k "cd /d ""4. anden"" && mvn spring-boot:run"
start "Camion" cmd /k "cd /d ""5. camion"" && mvn spring-boot:run"
start "Recepcion" cmd /k "cd /d ""6. recepcion"" && mvn spring-boot:run"
start "Factura" cmd /k "cd /d ""7. factura"" && mvn spring-boot:run"
start "Desconsolidacion" cmd /k "cd /d ""8. desconsolidacion"" && mvn spring-boot:run"
start "Producto" cmd /k "cd /d ""2. producto"" && mvn spring-boot:run"
start "Warehouse" cmd /k "cd /d ""9. warehouse"" && mvn spring-boot:run"
start "Stock" cmd /k "cd /d ""10. stock"" && mvn spring-boot:run"
start "Movimiento" cmd /k "cd /d ""11. movimiento"" && mvn spring-boot:run"

echo Esperando registro de microservicios en Eureka...
timeout /t 25 /nobreak

echo.
echo [3/3] Iniciando API Gateway...
start "API Gateway" cmd /k "cd /d ""12. api-gateway"" && mvn spring-boot:run"

echo Esperando inicializacion del API Gateway...
timeout /t 10 /nobreak

echo.
echo Abriendo Eureka Server...
start http://localhost:8761

echo Abriendo Swagger/OpenAPI centralizado...
start http://localhost:8080/swagger-ui/index.html

echo.
echo ==========================================================
echo SISTEMA INICIADO EN MODO NATIVO
echo ==========================================================
echo.
pause
```

### Consideraciones de la ejecución nativa

```text
Debe existir Java 21 instalado en el equipo.
Debe existir Maven instalado y disponible en la variable PATH.
Eureka Server debe iniciar primero.
Los microservicios deben iniciar antes que el API Gateway.
API Gateway debe iniciar al final.
MySQL debe estar disponible según la configuración de los application.yml.
```

---

<h2 style="color:#2563eb;">🐳 Puesta en marcha con Docker</h2>

Docker permite levantar los componentes principales del sistema en contenedores independientes, evitando iniciar manualmente cada microservicio desde el IDE. Cada servicio se ejecuta de forma aislada, pero todos se comunican mediante una red interna de Docker.

El archivo principal de configuración es:

```text
docker-compose.yml
```

Este archivo define:

```text
Qué servicios se ejecutan.
Qué imágenes Docker se construyen.
Qué puertos se exponen.
Qué variables de entorno se utilizan.
Qué red interna conecta los servicios.
Qué volumen conserva los datos de MySQL.
Qué servicios dependen de otros.
```

El ZIP del proyecto no corresponde a una imagen Docker completa. El ZIP contiene los archivos necesarios para que Docker pueda construir y levantar el ecosistema de microservicios.

---

<h2 style="color:#2563eb;">📦 Archivos relevantes del despliegue Docker</h2>

| Archivo / carpeta | Función |
|---|---|
| `docker-compose.yml` | Define contenedores, puertos, red, volúmenes y variables de entorno. |
| `Dockerfile` | Define cómo construir la imagen de cada microservicio. |
| `docs/init.sql` | Crea las bases de datos requeridas por los microservicios. |
| `backups/` | Carpeta sugerida para respaldos de base de datos. |
| `Iniciar.bat` | Script de ejecución Docker en Windows. |
| `Cerrar.bat` | Script para detener los contenedores. |
| `pom.xml` | POM padre del proyecto Maven multi-módulo. |

---

<h2 style="color:#2563eb;">🗄️ Archivo `docs/init.sql`</h2>

El archivo `docs/init.sql` permite crear las bases de datos necesarias cuando MySQL se inicia por primera vez dentro del contenedor Docker.

Este archivo se monta normalmente dentro del contenedor MySQL en la ruta:

```text
/docker-entrypoint-initdb.d/init.sql
```

MySQL ejecuta automáticamente los scripts ubicados en esa ruta solo cuando se crea el volumen por primera vez.

Bases de datos consideradas para Royal Logistics:

```sql
CREATE DATABASE IF NOT EXISTS bd_camion;
CREATE DATABASE IF NOT EXISTS bd_productos;
CREATE DATABASE IF NOT EXISTS bd_facturas;
CREATE DATABASE IF NOT EXISTS bd_desconsolidaciones;
CREATE DATABASE IF NOT EXISTS bd_stock;
CREATE DATABASE IF NOT EXISTS bd_anden;
CREATE DATABASE IF NOT EXISTS bd_warehouses;
CREATE DATABASE IF NOT EXISTS bd_recepciones;
CREATE DATABASE IF NOT EXISTS bd_movimientos;
CREATE DATABASE IF NOT EXISTS bd_credenciales;
CREATE DATABASE IF NOT EXISTS bd_usuarios;
CREATE DATABASE IF NOT EXISTS bd_camiones;
CREATE DATABASE IF NOT EXISTS bd_movimiento;
```

Importante:

```text
El archivo init.sql se ejecuta automáticamente solo la primera vez que se crea el volumen de MySQL.
Si el volumen ya existe, MySQL no volverá a ejecutar este archivo automáticamente.
```

Para recrear el volumen desde cero:

```bash
docker compose down -v
```

```bash
docker compose up -d --build
```

Advertencia: `docker compose down -v` elimina los datos persistentes de MySQL.

---

<h2 style="color:#2563eb;">🧭 Orden lógico de arranque</h2>

Aunque Docker Compose puede levantar todo el sistema con un solo comando, el orden lógico del ecosistema es:

```text
1. MySQL
2. Eureka Server
3. Microservicios logísticos
4. API Gateway
```

En ejecución nativa, el orden mínimo esperado es:

```text
1. Eureka Server
2. Microservicios
3. API Gateway
```

En ambos casos, Eureka debe estar disponible antes de que los servicios intenten registrarse, y el API Gateway debe iniciar después de que los servicios principales estén disponibles.

---

<h2 style="color:#2563eb;">▶️ Levantar el sistema con Docker</h2>

Ubicarse en la raíz del proyecto:

```bash
cd /d RUTA_DEL_PROYECTO
```

Ejecutar el script:

```bash
Iniciar.bat
```

También se puede ejecutar manualmente:

```bash
mvn clean package -DskipTests
```

```bash
docker compose up -d --build
```

La opción `-d` significa **detached mode**, es decir, los contenedores quedan ejecutándose en segundo plano.

---

<h2 style="color:#2563eb;">🔎 Revisar contenedores activos</h2>

Para revisar el estado de los contenedores:

```bash
docker ps
```

También se puede usar:

```bash
docker compose ps
```

Contenedores esperados en el despliegue principal:

```text
mysql-db
eureka-server
api-gateway
anden
camion
recepcion
factura
desconsolidacion
producto
warehouse
stock
movimiento
```

---

<h2 style="color:#2563eb;">🌐 Accesos principales</h2>

Una vez levantado el sistema, se pueden revisar los siguientes accesos. Cada bloque contiene solo la URL para facilitar su copia y pegado en el navegador.

**Eureka Server**

```text
http://localhost:8761
```

**API Gateway**

```text
http://localhost:8080
```

**Swagger / OpenAPI centralizado**

```text
http://localhost:8080/swagger-ui/index.html
```

**Actuator Health del API Gateway**

```text
http://localhost:8080/actuator/health
```

Nota importante:

```text
Estos accesos funcionan mientras Docker esté corriendo y los contenedores estén activos.
Si Docker se detiene, el sistema deja de estar disponible.
```

---

<h2 style="color:#2563eb;">🧪 Calidad y pruebas unitarias</h2>

El proyecto incorpora una suite de pruebas unitarias y pruebas de controller en los microservicios principales.

Tecnologías utilizadas para testing:

```text
JUnit 5
Mockito
MockMvc
Spring Boot Test
```

Para ejecutar la suite completa de pruebas, compilar el proyecto e instalar los artefactos en el repositorio local de Maven:

```bash
mvn clean install
```

Este comando ejecuta el reactor Maven completo, valida los módulos, ejecuta las pruebas unitarias configuradas y genera los artefactos correspondientes.

Para ejecutar solo las pruebas sin instalar artefactos:

```bash
mvn clean test
```

Prácticas de prueba presentes en el proyecto:

```text
@Test
@Mock
@InjectMocks
when(...)
verify(...)
assertEquals(...)
assertThrows(...)
@WebMvcTest
MockMvc
```

El resultado esperado de una ejecución correcta es:

```text
BUILD SUCCESS
```

---

<h2 style="color:#2563eb;">📚 Documentación Swagger / OpenAPI</h2>

El proyecto utiliza Swagger/OpenAPI para documentar los endpoints REST de los microservicios.

La documentación centralizada se encuentra disponible desde el API Gateway:

```text
http://localhost:8080/swagger-ui/index.html
```

Los controladores principales incorporan anotaciones como:

```text
@Tag
@Operation
@ApiResponses
@ApiResponse
```

Esto permite documentar:

```text
Nombre del grupo funcional.
Descripción del endpoint.
Códigos HTTP esperados.
Respuestas exitosas.
Errores funcionales.
Rutas disponibles por microservicio.
```

---

<h2 style="color:#2563eb;">🧾 Verificación de bases de datos</h2>

Para verificar que las bases de datos fueron creadas dentro del contenedor MySQL:

```bash
docker exec -it mysql-db mysql -u root -proot -e "SHOW DATABASES;"
```

Para revisar las tablas de una base específica:

```bash
docker exec -it mysql-db mysql -u root -proot -e "USE bd_productos; SHOW TABLES;"
```

Si las bases no aparecen y el archivo `docs/init.sql` fue agregado después de haber levantado Docker previamente, es probable que el volumen MySQL ya existiera. En ese caso, `init.sql` no se ejecutará automáticamente hasta crear un volumen nuevo.

---

<h2 style="color:#2563eb;">🧭 Verificación en Eureka</h2>

Abrir en el navegador:

```text
http://localhost:8761
```

Servicios esperados en Eureka:

```text
ANDEN
API-GATEWAY
CAMION
DESCONSOLIDACION
FACTURA
MOVIMIENTO
PRODUCTO
RECEPCION
STOCK
WAREHOUSE
```

---

<h2 style="color:#2563eb;">🔁 Pruebas mediante API Gateway</h2>

Las rutas principales se prueban mediante el API Gateway en el puerto `8080`.

Ejemplos:

```text
http://localhost:8080/api/productos
```

```text
http://localhost:8080/api/stock
```

```text
http://localhost:8080/api/movimientos
```

```text
http://localhost:8080/api/andenes
```

```text
http://localhost:8080/api/camiones
```

```text
http://localhost:8080/api/recepciones
```

```text
http://localhost:8080/api/facturas
```

```text
http://localhost:8080/api/desconsolidaciones
```

```text
http://localhost:8080/api/warehouse
```

Rutas configuradas pero no incluidas en el Docker Compose principal validado:

```text
http://localhost:8080/api/empleados
```

```text
http://localhost:8080/api/credenciales
```

---

<h2 style="color:#2563eb;">📌 Rutas principales del API Gateway</h2>

| Ruta Gateway | Servicio destino | Estado |
|---|---|---:|
| `/api/productos/**` | `lb://producto` | Listo |
| `/api/stock/**` | `lb://stock` | Listo |
| `/api/movimientos/**` | `lb://movimiento` | Listo |
| `/api/andenes/**` | `lb://anden` | Listo |
| `/api/camiones/**` | `lb://camion` | Listo |
| `/api/recepciones/**` | `lb://recepcion` | Listo |
| `/api/facturas/**` | `lb://factura` | Listo |
| `/api/desconsolidaciones/**` | `lb://desconsolidacion` | Listo |
| `/api/warehouse/**` | `lb://warehouse` | Listo |
| `/api/empleados/**` | `lb://creacion-usuario` | Configurado/parcial |
| `/api/credenciales/**` | `lb://autenticacion` | Configurado/parcial |

---

<h2 style="color:#2563eb;">🧾 Endpoints principales por microservicio</h2>

### Microservicio de Andenes

**Endpoint base:** `/api/andenes`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/andenes` | Lista todos los andenes. |
| GET | `/api/andenes/{nAnden}` | Busca un andén por número. |
| POST | `/api/andenes` | Registra un nuevo andén. |

### Microservicio de Camiones

**Endpoint base:** `/api/camiones`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/camiones` | Lista todos los camiones. |
| GET | `/api/camiones/patente/{patente}` | Busca un camión por patente. |
| POST | `/api/camiones` | Registra un nuevo camión. |
| DELETE | `/api/camiones/{patente}` | Elimina un camión por patente. |

### Microservicio de Recepciones

**Endpoint base:** `/api/recepciones`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/recepciones` | Lista todas las recepciones. |
| GET | `/api/recepciones/id/{idRecepcion}` | Busca una recepción por ID. |
| POST | `/api/recepciones` | Registra una nueva recepción. |
| GET | `/api/recepciones/estado/{estado}` | Busca recepciones por estado. |
| GET | `/api/recepciones/patente/{patente}` | Busca recepciones por patente de camión. |
| GET | `/api/recepciones/anden/{nAnden}` | Busca recepciones por número de andén. |
| DELETE | `/api/recepciones/{id}` | Elimina una recepción por ID. |

### Microservicio de Facturas

**Endpoint base:** `/api/facturas`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/facturas` | Lista todas las facturas. |
| GET | `/api/facturas/{numeroFactura}` | Busca una factura por número. |
| POST | `/api/facturas` | Registra una nueva factura. |
| GET | `/api/facturas/estado/{estado}` | Busca facturas por estado. |
| GET | `/api/facturas/proveedor/{proveedor}` | Busca facturas por proveedor. |
| GET | `/api/facturas/recepcion/{idRecepcion}` | Busca facturas por ID de recepción. |
| DELETE | `/api/facturas/{nFactura}` | Elimina una factura por número. |

### Microservicio de Desconsolidaciones

**Endpoint base:** `/api/desconsolidaciones`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/desconsolidaciones` | Lista todas las desconsolidaciones. |
| GET | `/api/desconsolidaciones/{idDesconsolidacion}` | Busca una desconsolidación por ID. |
| POST | `/api/desconsolidaciones` | Registra una nueva desconsolidación. |
| GET | `/api/desconsolidaciones/factura/{numeroFactura}` | Busca desconsolidaciones por número de factura. |
| GET | `/api/desconsolidaciones/cantidad/{cantidadProductos}` | Busca desconsolidaciones por cantidad de productos. |
| DELETE | `/api/desconsolidaciones/{idDesconsolidacion}` | Elimina una desconsolidación por ID. |

### Microservicio de Productos

**Endpoint base:** `/api/productos`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/productos` | Lista todos los productos disponibles. |
| GET | `/api/productos/sku/{sku}` | Busca un producto por SKU. |
| POST | `/api/productos` | Registra un nuevo producto. |
| GET | `/api/productos/categoria/{categoria}` | Busca productos por categoría. |
| GET | `/api/productos/desconsolidacion/{idDesconsolidacion}` | Busca productos por ID de desconsolidación. |
| GET | `/api/productos/nombre/{nombreProducto}` | Busca productos por nombre. |
| DELETE | `/api/productos/{sku}` | Elimina un producto por SKU. |

### Microservicio de Warehouse

**Endpoint base:** `/api/warehouse`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/warehouse` | Lista todas las ubicaciones de bodega. |
| GET | `/api/warehouse/ubicacion/{idUbicacion}` | Busca una ubicación por ID. |
| POST | `/api/warehouse` | Registra una nueva ubicación. |
| GET | `/api/warehouse/pasillo/{pasillo}` | Busca ubicaciones por pasillo. |
| GET | `/api/warehouse/rack/{rack}` | Busca ubicaciones por rack. |
| GET | `/api/warehouse/nivel/{nivel}` | Busca ubicaciones por nivel. |
| DELETE | `/api/warehouse/{idUbicacion}` | Elimina una ubicación por ID. |

### Microservicio de Stock

**Endpoint base:** `/api/stock`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/stock` | Lista todo el stock disponible. |
| POST | `/api/stock/inicializar` | Inicializa stock desde otro microservicio. |
| POST | `/api/stock` | Registra o actualiza stock. |
| GET | `/api/stock/producto/sku/{sku}` | Busca stock por SKU de producto. |
| GET | `/api/stock/ubicacion/{idUbicacion}` | Busca stock por ubicación. |

### Microservicio de Movimientos

**Endpoint base:** `/api/movimientos`

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/movimientos` | Lista todos los movimientos. |
| POST | `/api/movimientos` | Registra un nuevo movimiento. |
| GET | `/api/movimientos/sku/{sku}` | Busca movimientos por SKU. |
| GET | `/api/movimientos/ubicacion/{idUbicacion}` | Busca movimientos por ubicación. |
| GET | `/api/movimientos/tipo/{tipoMovimiento}` | Busca movimientos por tipo. |
| GET | `/api/movimientos/desconsolidacion/{idDesconsolidacion}` | Busca movimientos por ID de desconsolidación. |
| DELETE | `/api/movimientos/{idMovimiento}` | Elimina un movimiento por ID. |

---

<h2 style="color:#2563eb;">🧰 Comandos principales</h2>

| Acción | Comando |
|---|---|
| Ver versión de Docker | `docker --version` |
| Ver versión de Docker Compose | `docker compose version` |
| Ver información de Docker | `docker info` |
| Compilar, probar e instalar | `mvn clean install` |
| Ejecutar solo pruebas unitarias | `mvn clean test` |
| Empaquetar sin pruebas | `mvn clean package -DskipTests` |
| Levantar sistema con Docker | `docker compose up -d --build` |
| Revisar contenedores | `docker ps` |
| Revisar servicios de Compose | `docker compose ps` |
| Ver todos los logs | `docker compose logs -f` |
| Ver logs de un servicio | `docker compose logs -f nombre-servicio` |
| Detener sistema | `docker compose down` |
| Detener y borrar volumen | `docker compose down -v` |
| Ver bases de datos | `docker exec -it mysql-db mysql -u root -proot -e "SHOW DATABASES;"` |

---

<h2 style="color:#2563eb;">💾 Persistencia de datos de MySQL</h2>

El sistema utiliza MySQL dentro de Docker. Para conservar los datos, MySQL utiliza un volumen Docker.

Un volumen permite que los datos de la base de datos se mantengan aunque los contenedores se detengan o se vuelvan a crear.

Ejemplo conceptual:

```yaml
volumes:
  mysql_data:
```

```yaml
volumes:
  - mysql_data:/var/lib/mysql
```

Con esta configuración, los datos de MySQL quedan almacenados en un volumen administrado por Docker.

---

<h2 style="color:#2563eb;">🛑 Detener el sistema</h2>

Para detener los contenedores sin borrar los datos:

```bash
docker compose down
```

Para detener los contenedores y eliminar también los volúmenes:

```bash
docker compose down -v
```

Advertencia:

```text
No usar docker compose down -v si se desea conservar la información de la base de datos.
```

---

<h2 style="color:#2563eb;">⚠️ Errores comunes</h2>

### Docker Desktop no está abierto

Mensaje posible:

```text
Cannot connect to the Docker daemon
```

Solución:

```text
Abrir Docker Desktop.
Esperar a que esté iniciado.
Volver a ejecutar el comando.
```

### Puerto ocupado

Mensaje posible:

```text
port is already allocated
```

Solución:

```text
Cambiar el puerto externo en docker-compose.yml o cerrar el proceso que está usando el puerto.
```

### Microservicio no conecta a MySQL

Revisar:

```text
Que mysql-db esté running.
Que la base de datos exista.
Que usuario y contraseña coincidan.
Que el microservicio use mysql-db como host dentro de Docker.
```

Dentro de Docker no debe usarse:

```text
localhost
```

Debe usarse:

```text
mysql-db
```

### Microservicio no aparece en Eureka

Revisar que el microservicio apunte a:

```text
http://eureka-server:8761/eureka/
```

Dentro de Docker no debe apuntar a:

```text
http://localhost:8761/eureka/
```

### API Gateway no enruta

Posibles causas:

```text
El microservicio destino no está registrado en Eureka.
El nombre del servicio no coincide con spring.application.name.
La ruta del Gateway está mal configurada.
El Gateway inició antes de que los microservicios estuvieran disponibles.
```

---

<h2 style="color:#2563eb;">📸 Evidencia recomendada para revisión</h2>

Para demostrar que el sistema está funcionando, se recomienda guardar capturas de:

```text
docker --version
docker compose version
docker ps o docker compose ps
Eureka Server con microservicios registrados
Swagger/OpenAPI centralizado
Endpoint funcionando mediante API Gateway
mvn clean install con BUILD SUCCESS
Bases de datos creadas en MySQL
Logs de un microservicio iniciado correctamente
```

---

<h2 style="color:#2563eb;">👨‍💻 Equipo</h2>

<ul>
<li>Javier Herrera</li>
<li>Acxel González</li>
</ul>

<p>
<b>Profesor:</b><br>
Ricardo Mauricio González Vejar
</p>

---

<h2 style="color:#2563eb;">📌 Consideraciones del proyecto</h2>

<p>
El presente proyecto fue desarrollado con enfoque académico para la asignatura Desarrollo Fullstack I de Duoc UC.
</p>

<p>
Su objetivo consiste en representar procesos reales utilizados actualmente dentro de operaciones fulfillment y administración de warehouse modernas, utilizando arquitectura de microservicios para mantener una solución modular, escalable y desacoplada.
</p>

<p>
El sistema busca integrar conceptos de logística, trazabilidad, control de inventario, documentación de APIs, testing automatizado y despliegue local mediante Docker Compose.
</p>
