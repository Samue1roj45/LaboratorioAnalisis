# LaboratorioAnalisis — Sistema de reservas de biblioteca

Laboratorio individual de *Análisis y diseño de sistemas de información*:
identificación e implementación de patrones de diseño (Builder, Strategy, Facade,
Observer y State) en un prototipo de consola en Java 17+.

**Autor:** Samuel Velásquez Rojas

## Organización por ramas

Cada estación del laboratorio está en su propia rama y parte de la anterior:

| Rama | Estación | Estado |
|---|---|---|
| `estacion-1` | Comprender el problema y modelar el flujo | ✅ Terminada |
| `estacion-2` | Crear el dominio y ejecutar la primera versión | ✅ Terminada |
| `estacion-3` | Construir reservas con Builder | ✅ Terminada |
| `estacion-4` | Seleccionar salas con Strategy | ✅ Terminada |
| `estacion-5` | Separar el acceso a datos y coordinar con Facade | ✅ Terminada |
| `estacion-6` | Notificar eventos con Observer | ✅ Terminada |
| `estacion-7` | Controlar el ciclo de vida con State | ⏳ Pendiente |
| `estacion-8` | Integrar y ejecutar la aplicación completa | ⏳ Pendiente |

## Avance

### Estación 1 — Comprender el problema
- Diagrama de flujo del proceso de reserva, con la decision "¿hay una sala adecuada?".
- 7 responsabilidades que no deben quedar en `Main` y el por que de cada una.
- Detalle: [`docs/estacion-1.md`](docs/estacion-1.md)

### Estación 2 — Dominio y primera versión
- Clases `Estudiante` y `Sala` con atributos privados y finales, y validacion en el constructor.
- `Main` inicial que crea las 4 salas de prueba (A: 2, B: 4, C: 6, D: 8) y las muestra.
- Punto de control sobre encapsulamiento: [`docs/estacion-2.md`](docs/estacion-2.md)
- Captura de ejecucion: [`evidencias/estacion-2-ejecucion.jpg`](evidencias/estacion-2-ejecucion.jpg)

### Estación 3 — Builder
- Clase `Reserva` (arranca en estado `Pendiente`) y `ReservaBuilder`, que la arma paso a paso y centraliza las validaciones.
- `EstadoReserva` y `Pendiente` en version temporal para poder compilar; los estados reales llegan en la Estación 7.
- Pruebas: P01 (reserva valida), P02 (sin estudiante, se rechaza) y sala con capacidad insuficiente (se rechaza).
- Punto de control: [`docs/estacion-3.md`](docs/estacion-3.md)
- Captura de ejecucion: [`evidencias/estacion-3-ejecucion.jpg`](evidencias/estacion-3-ejecucion.jpg)

### Estación 4 — Strategy
- Interfaz `EstrategiaSeleccionSala` con dos implementaciones: `SeleccionPorCapacidad` (la sala mas pequeña que alcance) y `SeleccionSalaPreferida` (la que pidio el estudiante, si alcanza).
- Pruebas: P03 (4 personas → Sala B), P04 (preferida C → Sala C) y P05 (preferida B para 7 → no hay sala).
- Punto de control con la propuesta de una tercera estrategia (por equipamiento): [`docs/estacion-4.md`](docs/estacion-4.md)
- Captura de ejecucion: [`evidencias/estacion-4-ejecucion.jpg`](evidencias/estacion-4-ejecucion.jpg)

### Estación 5 — Facade y repositorios
- Interfaces `RepositorioSalas` y `RepositorioReservas` con sus implementaciones en memoria.
- `ReservaFacade` coordina consultar, seleccionar, construir y registrar; recibe los repositorios por constructor (inversion de dependencias).
- Pruebas: P06 (reserva por la fachada) y P10 (10 personas → no se crea reserva). La reserva aun queda Pendiente porque los estados reales llegan en la Estación 7.
- Punto de control: [`docs/estacion-5.md`](docs/estacion-5.md)
- Captura de ejecucion: [`evidencias/estacion-5-ejecucion.jpg`](evidencias/estacion-5-ejecucion.jpg)

### Estación 6 — Observer
- Interfaz `ObservadorReserva` con `NotificadorEstudiante` y `RegistroEventos`.
- `Reserva` guarda su lista de observadores y les avisa en `cambiarEstado`; `ReservaFacade` los engancha a cada reserva antes de guardarla.
- Los avisos se ven en accion desde la Estación 7 (P07 y P08).
- Punto de control: [`docs/estacion-6.md`](docs/estacion-6.md)
- Captura de ejecucion: [`evidencias/estacion-6-ejecucion.jpg`](evidencias/estacion-6-ejecucion.jpg)
