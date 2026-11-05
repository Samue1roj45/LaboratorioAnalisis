# Estación 4 — Seleccionar salas con Strategy

## Archivos creados
- `EstrategiaSeleccionSala.java`: la interfaz, el contrato que cumplen todos los criterios.
- `SeleccionPorCapacidad.java`: escoge la sala disponible mas pequeña que alcance.
- `SeleccionSalaPreferida.java`: escoge la sala que pidio el estudiante, solo si alcanza.
- `Main.java`: prueba las dos estrategias con la lista de salas.

## Pruebas
| ID | Escenario | Resultado |
|---|---|---|
| P03 | Por capacidad, 4 personas | Selecciona Sala B |
| P04 | Preferida C, 4 personas | Selecciona Sala C |
| P05 | Preferida B, 7 personas | No selecciona sala (`null`) |

Captura: [`evidencias/estacion-4-ejecucion.jpg`](../evidencias/estacion-4-ejecucion.jpg)

## Punto de control: una tercera estrategia
Por ejemplo **sala con equipamiento**: que escoja una sala que tenga lo que el estudiante
necesita (video beam, tablero, computadores) y que alcance para todos.

**Que toca crear:**
- `SeleccionPorEquipamiento.java`, que implemente `EstrategiaSeleccionSala` y haga el filtro.
- Como hoy `Sala` no guarda equipos, habria que agregarle ese dato (por ejemplo una lista
  de equipos) para que la estrategia tenga con que filtrar.

**Que NO toca modificar:**
- `EstrategiaSeleccionSala`, `SeleccionPorCapacidad` ni `SeleccionSalaPreferida`, siguen igual.
- La fachada tampoco, porque ella recibe "una estrategia" sin saber cual es. Solo se le pasa
  `new SeleccionPorEquipamiento(...)` desde Main y ya funciona.

O sea, se agrega un criterio nuevo creando una clase y no hay que meterle mano a lo que ya
sirve. Eso es el principio abierto/cerrado.
