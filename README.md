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
| `estacion-3` | Construir reservas con Builder | ⏳ Pendiente |
| `estacion-4` | Seleccionar salas con Strategy | ⏳ Pendiente |
| `estacion-5` | Separar el acceso a datos y coordinar con Facade | ⏳ Pendiente |
| `estacion-6` | Notificar eventos con Observer | ⏳ Pendiente |
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
