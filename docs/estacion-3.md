# Estación 3 — Construir reservas con Builder

## Archivos creados
- `Reserva.java`: el objeto de dominio. Arranca siempre en estado `Pendiente`.
- `ReservaBuilder.java`: arma la reserva paso a paso y hace todas las validaciones.
- `EstadoReserva.java` y `Pendiente.java`: version **temporal** para poder compilar
  (lo dice la nota de la guia). Los estados de verdad se hacen en la Estación 7.
- `Main.java`: prueba una reserva valida y dos que se deben rechazar.

## Pruebas
| ID | Escenario | Resultado |
|---|---|---|
| P01 | Construccion con todos los datos | Se crea la reserva en estado Pendiente |
| P02 | Construccion sin estudiante | Se rechaza: "Faltan datos obligatorios de la reserva." |
| — | Sala A (2) para 6 personas | Se rechaza: "La sala no tiene capacidad suficiente." |

Captura: [`evidencias/estacion-3-ejecucion.jpg`](../evidencias/estacion-3-ejecucion.jpg)

## Punto de control: ¿que validaciones son del Builder y por que no van en Main?
Al Builder le tocan todas las validaciones de **armar** la reserva:
- que esten los datos obligatorios (estudiante, fecha, hora y sala),
- que la fecha no sea pasada y que la duracion y la cantidad de personas sean mayores a 0,
- que la sala si alcance para la cantidad de personas.

No van en Main porque si cada parte del programa que crea una reserva tiene que acordarse
de validar, tarde o temprano alguien se salta una y se crea una reserva mal hecha. Con el
Builder la regla esta en un solo lado: si los datos estan mal, `build()` no deja crear la
reserva y ya. Ademas el constructor de `Reserva` no es publico, entonces no hay otra forma
de crearla que no sea pasando por el Builder.

Y frente a un constructor con 7 parametros, con el Builder se ve clarito que es cada dato
(`.duracionHoras(2)`, `.cantidadPersonas(4)`), y no hay riesgo de pasar uno en el orden que no es.
