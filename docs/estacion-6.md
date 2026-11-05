# Estación 6 — Notificar eventos con Observer

## Archivos creados / modificados
- `ObservadorReserva.java`: la interfaz que cumplen todos los que quieren enterarse de los cambios.
- `NotificadorEstudiante.java`: simula el aviso al estudiante.
- `RegistroEventos.java`: deja el cambio registrado en la consola.
- `Reserva.java`: ahora tiene su lista de observadores, metodos para agregar y quitar, y
  `cambiarEstado` avisa a todos cuando cambia el estado.
- `ReservaFacade.java`: recibe la lista de observadores y se los pone a cada reserva antes de guardarla.

## Prueba
La guia dice que al confirmar y al cancelar deben salir dos mensajes (estudiante y registro).
Eso todavia **no se ve en esta estacion**, porque la transicion real de estados se hace en la
Estación 7 (aca `Pendiente` sigue siendo temporal). La prueba de los avisos (P07 y P08) queda
en la captura de la Estación 7. En esta estacion se comprueba que todo compila y que la
fachada ya recibe y engancha los observadores.

Captura: [`evidencias/estacion-6-ejecucion.jpg`](../evidencias/estacion-6-ejecucion.jpg)

## Punto de control: ¿por que Reserva depende de la interfaz y no de las clases concretas?
Porque a la reserva no le importa quien la esta escuchando ni que hace con el aviso. Ella
solo sabe que tiene una lista de `ObservadorReserva` y que a cada uno le llama `actualizar`.
Si `Reserva` creara adentro un `NotificadorEstudiante` y un `RegistroEventos`, cada vez que
se quiera una forma nueva de avisar (correo, mensaje de texto) tocaria abrir `Reserva` y
meterle mano. Asi como esta, se crea la clase nueva que implemente la interfaz, se agrega a
la lista en Main y ya, la reserva ni se entera. Eso es bajo acoplamiento.
