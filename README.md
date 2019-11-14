# EjercicioPersona_TasOn:
Ejercicio: Aplicación para ingresar datos de una persona, buscar y eliminar la persona. Para el Front end se utilizo Angular 
y para el BackEnd JavaEE

# Detalles:
* Aplicacion Web basada en Maven 
* Servidor web: glassFish 4.1.1
* IDE: NetBeans8.2
* Nombre del Proyecto: Persona

# Levantar y ejecutar la aplicacion:
1.- Añadir el servidor GlassFish a NetBeans: 
    Ver en la siguiente guia: https://docs.oracle.com/cd/E21454_01/html/821-2531/gknen.html
    
2.- Crear la Base de datos y conexion
 	- Se utilizo la base de datos Java DB (Derby).
	- Nombre de la base de datos: persona, usuario: root, password:root
 	- Para crear la base de datos seguir ver la siguiente guia: https://netbeans.org/kb/docs/ide/java-db.html#starting
  y avanzar hasta el punto "Connecting to the Database",
	  luego saltarse al punto "Recreating Tables from a Different Database" y usar el archivo PERSONA.grab para generar la 
	  correspondiente tabla.
 
 3.- Build y Run el Proyecto
