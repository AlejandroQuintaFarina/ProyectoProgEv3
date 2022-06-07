# ProyectoProgEv3
## Gestión sencilla de registros para un Hotel

Nuestra aplicación consiste en un registro que se muestra en un GUI creado a través de la paleta de netbeans 
y utiliza una base de datos en MySQL que nos ayudará a guardar los datos necesarios para el programa.

Al iniciarlo nos encontramos con una pestaña de inicio de sesión donde los empleados colocarán sus datos
(siempre y cuando estén registrados en la base de datos) y este inicio será guardado con la hora de entrada.

Tras un inicio correcto se abre el gestor de registros que se conformará de dos pestañas:

      ·La primera contiene todos los campos de datos necesarios para el registro, 
        los campos no pueden estar vacios , y los campos como el dni o tlf es obligatorio cumplir unas condiciones.
        
      ·La segunda muestra en una tabla los datos contenidos en una tabla de registros
        en la base de datos, en ella también encontramos tres acciones:
        
          ·Existe un selector en el que se encuentran varias opciones de busqueda.
          .Un botón que actualiza los datos en la base de datos con cambios en la 
              tabla de la interfaz.
          ·Un botón eliminar que borra la fila seleccionada en la tabla.
