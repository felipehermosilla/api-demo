# API-DEMO
Proyecto de ejemplo para mostrar algunas funcionalidades básicas de un API-REST construida con el framework Spring boot y un motor embedded H2 como base de datos.

# Configuración
1. Debe existir el directorio /opt/api-demo o C:/opt/api-demo y el usuario con que correrá el programa debe tener permisos de escritura sobre el mismo.
2. Se configura mediante el archivo ```application.properties``` que se encuentra dentro de ```src/main/resources``` . EL archivo contiene propiedades de la aplicación como conexión a la BD, y configuraciones de seguridad y autenticación. Este último está deshabilitada por defecto.

### Configuracion de la Base de Datos
 Se utiliza el motor embedded H2. Tener en cuenta las siguientes consideraciones:
1. Crear un archivo vacío de nombre 'demodb' dentro del directorio '/opt/api-demo'.
2. La aplicación necesita un repositorio de datos para datos de prueba. Se realizan inserts de datos utilizando el archivo 'src/main/resources/data.sql'.
3. La consola del H2 puede accederse ingresando a la url: 
  http://localhost:8080/h2-console
4. El nombre de usuario y password se encuentran en el archivo application.properties

## Requisitos para ejecutar la aplicación

* IDE compatible con proyectos MAVEN Driver
* Apache Maven 3.3.9 o superior
* Java 8 (JDK8)


## Ejecutar la aplicación
Ubicarse la raiz del proyecto y en la línea de comandos ejecutar:
```mvn spring-boot:run```


## Swagger API
El proyecto cuenta con documentación del API accesible desde el swagger-ui. URI al swagger:
http://localhost:8080/swagger/index.html


