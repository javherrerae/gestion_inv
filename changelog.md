---------------------- CHANGELOG -------------------------

[17-05-2027] Actualización v1.0:

El sistema se encuentra funcional en su estado base. Se esperan futuras integraciones de más microservicios (principalmente el microservicio de movimiento y el de api-gateway), junto con la finalización de la gestión de usuarios y autenticación.

Nota de integración: Tras aplicar esta actualización, se ejecutaron con éxito el flujo de pruebas en Postman, logrando que los microservicios validen información en bases de datos externas a las suyas. Además de lograr la inicialización reactiva y en cascada del registro de cero unidades dentro del inventario aislado de stock.

Nuevo:
- Actualización de microservicios producto, anden, camion, recepcion, factura, desconsolidacion y warehouse.
- Finalización de integración de inter-conexión de microservicios mediante FeignClient.

Corrección de errores:
- Downgrade de la propiedad 'java.version' de Java 25 a Java 21 en pom.xml de camion, creacion-usuario, recepcion, factura,   desconsolidacion y warehouse.
- Se añadió la notacion @Service omitida en la clase AndenService.
- Fix de bugs generales de JavaBeans (Discrepancia entre mayúsculas y minúsculas en JPA).




[16-05-2026] Actualización v0.3.6:
- Actualización del microservicio `Producto`:
- Finalización del microservicio `Desconsolidacion`
- Finalización del microservicio `Warehouse`
- PDF Ingenieria: Sistema y flujo logístico:
  - Informe y eplicación de Ingeniería de proyecto:
    - Explicación teórica, comprensión operacional, análisis de flujo logístico, justificación de microservicios  
- Avance presentación: (Pendiente de subir)
  - Presentación proyecto
  - Flujo logístico
  - Ingeniería *PDF*
  - Arquitectura

[14-05-2026] Actualización v0.3.5:
- Finalización del microservicio `Camion`
- Finalización del microservicio `Recepcion`
- Finalización del microservicio `Factura`

[14-05-2026] Actualización v0.3.4:
- Corrección y carga final modelado de Base de Datos: Diseño del modelo relacional en Oracle SQL Developer Data Modeler

[13-05-2026] Actualización v0.3.3:
- Finalización del Microservicio `Anden`
- Finalización de modelado de Base de Datos: Diseño del modelo relacional en Oracle SQL Developer Data Modeler

[11-05-2026] Actualización v0.3.2:
- Finalización del microservicio `Producto`
- Finalización del microservicio `Creacion-usuario`

[06-05-2026] Actualización v0.3.1
- Inicio de modelado de Base de datos: Diseño del modelo relacional en Oracle SQL Developer Data Modeler

[04-05-2026] Actualización v0.3
- Finalización del microservicio `Autenticación`

[01-05-2026] Actualización v0.3
- Finalización del microservicio `Eureka-Server`

