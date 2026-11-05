# Estación 5 — Separar el acceso a datos y coordinar con Facade

## Archivos creados
- `RepositorioSalas.java` y `RepositorioReservas.java`: interfaces para consultar salas y guardar reservas.
- `RepositorioSalasMemoria.java` y `RepositorioReservasMemoria.java`: implementaciones en memoria (lista fija).
- `ReservaFacade.java` (primera version): coordina consultar, seleccionar, construir y registrar.
- `Main.java`: hace una reserva por la fachada y prueba una solicitud de 10 personas.

## Pruebas
| ID | Escenario | Resultado |
|---|---|---|
| P06 | Reserva exitosa por la fachada | Se registra la reserva (Sala B) |
| P10 | Solicitud para 10 personas | No se crea reserva: "No hay una sala disponible que cumpla la solicitud." |

Nota: en esta estacion la reserva sigue saliendo como **Pendiente**, porque los estados
de verdad (Confirmada, Cancelada...) se hacen en la Estación 7. Por ahora `Pendiente` es la
version temporal y solo avisa que la transicion falta.

Captura: [`evidencias/estacion-5-ejecucion.jpg`](../evidencias/estacion-5-ejecucion.jpg)

## Punto de control
**¿Por que Main ya no necesita saber el orden de los pasos?**
Porque ahora Main solo le dice a la fachada "haga esta reserva" y le pasa los datos. La
fachada es la que sabe que primero se consultan las salas, despues se escoge una con la
estrategia, despues se arma con el Builder y al final se guarda. Main no se tiene que
enterar de nada de eso, y si mañana cambia el orden o se agrega un paso, se cambia solo
la fachada.

**¿Que cambiaria si se reemplaza el repositorio en memoria por otro?**
Casi nada. Se crea una clase nueva (por ejemplo `RepositorioSalasBD`) que implemente
`RepositorioSalas`, y en Main se le pasa esa a la fachada en vez de la de memoria. La
fachada no se toca porque ella trabaja con la interfaz, no con la clase concreta. Eso es
la inversion de dependencias.
