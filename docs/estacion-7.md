# Estación 7 — Controlar el ciclo de vida con State

## Archivos creados / modificados
- `EstadoReserva.java`: el contrato (`nombre`, `confirmar`, `cancelar`, `finalizar`).
- `Pendiente.java`: ahora si es la version real; deja confirmar o cancelar.
- `Confirmada.java`: deja cancelar o finalizar.
- `Cancelada.java` y `Finalizada.java`: estados finales, todo lo rechazan.
- `Main.java`: corre las pruebas obligatorias de la guia.

## Pruebas obligatorias
| ID | Escenario | Resultado |
|---|---|---|
| P07 | Confirmar una reserva pendiente | Pasa a Confirmada y avisan los dos observadores |
| P08 | Cancelar una reserva confirmada | Pasa a Cancelada y avisan los dos observadores |
| P09 | Confirmar una reserva cancelada | Se rechaza: "No se puede confirmar una reserva cancelada." y **no** avisa |
| P11 | Finalizar otra reserva confirmada | Pasa a Finalizada y avisan los dos observadores |
| — | Cancelar una reserva finalizada | Se rechaza: "No se puede cancelar una reserva finalizada." y no avisa |

Captura: [`evidencias/estacion-7-ejecucion.jpg`](../evidencias/estacion-7-ejecucion.jpg)

## Punto de control: State vs una sola Reserva llena de if/else
Si todo estuviera en `Reserva`, cada metodo seria algo tipo "si estado es Pendiente haga
esto, si es Confirmada esto otro, si es Cancelada lance error..." y asi en confirmar,
cancelar y finalizar. Con 4 estados ya son un monton de if, y es facil que se cuele una
transicion que no deberia.

Con State cada estado es una clase pequeña que sabe que puede hacer y que no. La reserva
solo le dice al estado actual "confirmar" y el estado decide.

**¿Que mejora cuando se agrega un estado nuevo?** (por ejemplo "En curso")
Se crea la clase `EnCurso` con sus reglas y se ajusta solo el estado que lleva a ella
(por ejemplo `Confirmada`). No hay que ir a buscar todos los if regados por el codigo.
Y como el aviso a los observadores solo pasa en `cambiarEstado`, una transicion rechazada
nunca genera notificacion.
