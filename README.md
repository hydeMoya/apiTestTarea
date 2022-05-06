# apiTestTarea
Para instalar proyecto SpringBoot:

- Instalar mysql 
- Entrar con usuario=root y password= root 
- Crear esquema base de datos nombre "prueba_tareas" 
- Levantar proyecto spring boot y se creará la tabla tareas 
- Ejecutar con postman los 5 servicios.
``` sh
http://localhost:8097
 - get tarea/all 
 - get tarea/{id}  
 - post tarea/save 
 - del tarea/{id}  
 - put tarea/{id} 
 
 ```
 - Ver documentacion swagger
 ``` sh
 http://localhost:8097/swagger-ui/index.html
 ```
 - Probar clase pruebas unitarias
 ``` sh
 Ejecutar clase test con junit se encuentra en la siguiente ruta: apiTestTareas\src\test\java\com\tareas\TareaRepositoryTest.java
 
 ```
 
 
