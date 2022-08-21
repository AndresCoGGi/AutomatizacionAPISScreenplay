# language: es
Característica: Eliminar empleado
  Yo como usuario
  Necesito eliminar un empleado
  Para borrar del sistema la informacion del empleado

  @EliminarEmpleado
  Escenario: Eliminacion de un empleado
    Dado que el usuario hace un llamado a la API de dummy restapiexample
    Cuando el realiza la peticion a la Api de "Eliminar empleado" con id "2" para eliminar
    Entonces el podra visualizar una respuesta exitosa de eliminacion "Successfully! Record has been deleted"