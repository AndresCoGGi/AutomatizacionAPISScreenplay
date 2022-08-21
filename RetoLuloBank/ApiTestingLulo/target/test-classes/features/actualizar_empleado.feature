# language: es
Característica: Actulizar empleado
  Yo como usuario
  Necesito actualizar un empleado
  Para actualizar la informacion del empleado

  @ActualizarEmpleado
  Escenario: Actualizacion de un empleado
    Dado que el usuario hace un llamado a la API de dummy restapiexample
    Cuando el realiza la peticion a la Api de "Actualizar empleado" con id "21" para actualizar
    Entonces la informacion del usuario quedara actualizada exitosamente "Successfully! Record has been updated."