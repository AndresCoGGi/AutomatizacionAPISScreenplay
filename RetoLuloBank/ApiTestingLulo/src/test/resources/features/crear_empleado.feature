# language: es
Característica: Crear empleado
  Yo como usuario
  Necesito crear un empleado
  Para alamacenar la informacion del empleado

  @CrearEmpleado
  Escenario: Creacion de un empleado
    Dado que el usuario hace un llamado a la API de dummy restapiexample
    Cuando el realiza la peticion a la Api de "Crear empleado" con la informacion
      | nombre  | Andres |
      | salario | 100    |
      | edad    | 28     |
    Entonces el podra visualizar una respuesta exitosa con la informacion registrada
       | nombre  | Andres |
       | salario | 100    |
       | edad    | 28     |