# Challengue-Foro-hub-API-REST


# Foro-Hub

Foro-Hub es una API REST desarrollada con **Spring Boot** que permite la gestión de usuarios, tópicos, respuestas y cursos. La aplicación incluye autenticación mediante **JWT**, seguridad configurada con **Spring Security**, y documentación interactiva con **Swagger UI (Springdoc OpenAPI)**. Está diseñada para fines educativos y pruebas de desarrollo de proyectos web backend.

---

## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.  

---

## Pre-requisitos 📋

Necesitas tener instaladas las siguientes herramientas:

- **Java 17**  
- **Maven**  
- **Git**  
- **Base de datos**: H2 para pruebas en memoria o MySQL para uso local persistente  



## Instalación y Configuración 🛠️

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/challengue-foro-hub-api-rest.git 
2. Accede al repositorio 🛠️
```bash
  cd challengue-foro-hub-api-rest
```
3.Configura la conexión a la base de datos en application.properties o application.yml según el motor que uses:
# Para MySQL
```
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

server.port=8082

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace = never
api.security.token.secret = ${JWT_SECRET:12345678}
```
4.Compila y ejecuta la aplicación

## Uso 📌

La API estará disponible en [http://localhost:8082/](http://localhost:8082/).

Documentación interactiva con Swagger UI: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)

### Endpoints principales

- `/usuarios` → gestión de usuarios  
- `/topicos` → gestión de tópicos del foro  
- `/respuestas` → gestión de respuestas a los topicos  
- `/cursos` → gestión de cursos  

## Autenticación 🔐

- El sistema utiliza **JWT** para la autenticación.  
- Para acceder a endpoints protegidos, primero debes registrarte o iniciar sesión.  
- Incluye el token JWT en la cabecera Authorization: Bearer-token para las solicitudes protegidas.
