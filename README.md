# Evaluacion creación de usuarios

La aplicación utiliza base de datos Mysql, en el archivo application.properties
que se encuantra en /resources se puede cambiar la BD y usuario a utilizar. De esta misma manera el puerto y el path
donde correrá el servicio.

## Configuración

En el archivo .properties se configura:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/evaluacion
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
- url: ruta donde se ubica la Base de datos y se creara en caso de no existir.
- username: Usuario de BD.
- password: Password de BD.
- driver-class-name: driver de BD, en este caso Mysql.

```properties
server.port=8079
server.servlet.context-path=/ws/api/evaluacion/v1
```
- port: puerto que correra el servicio.
- context-path: ruta base del servicio.

## Instalación

El proyecto puede ser corrido desde el IDE o desde la consola, se ubica en el directorio /build/libs

```bash
$ java -jar evaluacion-0.0.1-SNAPSHOT.jar
```

## Uso

Para usar la funcionalidad de crear un usuario se debe llamar al servicio (por Postman o navegador)
a traves de  la url:

```bash
http://localhost:8079/ws/api/evaluacion/v1/save
```

Tambien se puede probar a traves de la documentación Swagger:

```bash
http://localhost:8079/ws/api/evaluacion/v1/swagger-ui.html
```