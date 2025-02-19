Implementación de Seguridad e Internacionalización en Spring Boot
Introducción
Funcionamiento de una aplicación Spring Boot que incorpora seguridad con Spring Security e internacionalización (i18n). El objetivo es permitir el acceso a rutas públicas sin autenticación y proteger rutas privadas, asegurando además que los mensajes de la aplicación se adapten según el idioma del usuario.
Tecnologías Utilizadas
•	Spring Boot (Framework principal)
•	Spring Security (Autenticación y autorización)
•	Internacionalización con MessageSource (Manejo de idiomas)
•	Maven (Gestor de dependencias)
•	IntelliJ IDEA (Entorno de desarrollo)
•	Git y GitHub (Control de versiones y almacenamiento en la nube)
Descripción de la Implementación
Seguridad
Se configuró Spring Security para:
1.	Permitir acceso libre a /publico.
2.	Requerir autenticación en /privado.
3.	Gestionar usuarios en memoria con credenciales predefinidas.
4.	Redirigir a /privado después del login y a /publico tras el logout.
Internacionalización
Se crearon archivos messages.properties para manejar mensajes en distintos idiomas:
•	messages.properties (Español por defecto)
•	messages_en.properties (Inglés) Estos archivos contienen claves como publico.mensaje y privado.mensaje, que el controlador usa para responder según el idioma del usuario.
Controlador
El controlador maneja las rutas /publico y /privado y devuelve mensajes internacionalizados según el Accept-Language enviado en la petición.
Pruebas Realizadas
1.	Prueba de Acceso sin Autenticación 
o	URL: http://localhost:8080/publico
o	Esperado: Mensaje público sin pedir login.
2.	Prueba de Acceso Protegido 
o	URL: http://localhost:8080/privado
o	Esperado: Requiere inicio de sesión.
3.	Prueba de Internacionalización 
o	URL: http://localhost:8080/publico?lang=en
o	Esperado: Mensaje en inglés.
4.	Prueba de Logout 
o	URL: http://localhost:8080/logout
o	Esperado: Redirección a /publico.
Experiencia y Dificultades
Durante la implementación surgieron los siguientes retos:
•	Errores en la configuración de Git y GitHub: Se solucionó verificando el repositorio remoto y usando git push origin master.
•	Spring Security bloqueando rutas no deseadas: Se ajustó SecurityConfig.java para permitir acceso correcto.
•	Problemas con la carga de archivos messages.properties: Se solucionó ubicando los archivos correctamente en src/main/resources/.
Conclusión
La implementación permitió comprender cómo integrar seguridad e internacionalización en una aplicación Spring Boot. La configuración realizada asegura que los usuarios puedan acceder a contenido en su idioma y que las rutas privadas estén protegidas correctamente. El uso de GitHub facilita la gestión del código y futuras colaboraciones.
