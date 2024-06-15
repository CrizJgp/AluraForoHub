# AluraForoHub

## Descripción
Realzación del challenge del programa One de Alura el cual consiste en la creación de tópicos para un foro. AluraForoHub es una aplicación desarrollada con Spring Boot
que actúa como una plataforma de foros en línea. La aplicación permite a los usuarios gestionar temas de discusión, publicar comentarios y proporciona una API para 
interactuar con estos datos, estableciendo una conexión segura y eficiente con una base de datos.

Durante el desarrollo de este proyecto, se implementaron varios conceptos fundamentales de Spring Boot y Java, que incluyen:

- La persistencia de datos con Spring Data JPA.
- Autenticación y autorización con JWT.
- Configuración y uso de base de datos.
- Creación y gestión de servicios RESTful.
- Seguridad en la API.

## Características
- **Gestión de usuarios y autenticación JWT**: Los usuarios pueden registrarse, iniciar sesión y autenticarse usando tokens JWT.
- **Creación y gestión de temas de discusión**: Los usuarios pueden crear, leer, actualizar y eliminar temas de discusión.
- **Publicación de comentarios**: Los usuarios pueden agregar y gestionar comentarios en los temas de discusión.
- **Interfaz de usuario intuitiva**: La aplicación está diseñada para ser fácil de usar, permitiendo a los usuarios interactuar con los foros de manera eficiente.

## Requisitos
- Java 17 o superior
- IntelliJ IDEA
- MySQL

## Configuración
### Variables de entorno
Asegúrate de configurar las siguientes variables de entorno para la conexión con la base de datos y la configuración de JWT:

```properties
DB_HOST=<tu_host_de_base_de_datos>
DB_NAME=<tu_nombre_de_base_de_datos>
DB_USER=<tu_usuario_de_base_de_datos>
DB_PASSWORD=<tu_contraseña_de_base_de_datos>
JWT_SECRET=<tu_contraseña_de_JWT>

## Nota
Este proyecto fue desarrollado como parte de un desafío dentro del programa One de Alura Latam, más específicamente para la rama de BackEnd con fines educativos
y no está destinado a recibir contribuciones. Sin embargo, siéntete libre de explorar el código y aprender de él.

## Licencia
Este proyecto fue desarrollado por Cristina González como parte del Challenge API REST del programa One de Alura Latam de la rama BackEnd con fines 
educativos. No se concede ninguna licencia para su uso o distribución.