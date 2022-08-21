# language: es
Característica: Consulta de empleados
  Yo como usuario
  Necesito consultar empleados
  Para validar la informacion

  @consultaTodosLosEmpleados
  Escenario: : Consulta de todos los empleados
    Dado que el usuario hace un llamado a la API de dummy restapiexample
    Cuando el realiza la peticion a la Api de "Consultar empleados"
    Entonces el podra obtener toda la informacion de los empleados

  @consultaUnEmpleadoEspecifico
  Escenario: : Consultar un empleado especifico
    Dado que el usuario hace un llamado a la API de dummy restapiexample
    Cuando el realiza la peticion a la Api de "Consultar empleado" con id "1"
    Entonces el podra obtener toda la informacion del empleado con id "1"