# Estación 8 — Integrar y ejecutar la aplicación completa

## Archivos modificados
- `Main.java` (version final): solo arma las dependencias (repositorios, observadores y
  fachada) y presenta el flujo. No tiene logica de negocio.

## Verificacion (seccion 8.1 de la guia)
| Que se comprueba | Resultado |
|---|---|
| Se confirma la primera reserva | Laura → Sala B, estado Confirmada ✅ |
| La cancelacion cambia el estado y genera dos notificaciones | Confirmada → Cancelada, avisan estudiante y registro ✅ |
| Confirmar despues de cancelar se rechaza y no notifica | "Operación rechazada: No se puede confirmar una reserva cancelada." ✅ |
| La sala preferida C se escoge para 4 personas | Andrés → Sala C ✅ |
| Una solicitud para 10 personas no crea reserva | "No hay una sala disponible que cumpla la solicitud." ✅ |
| Una reserva confirmada se puede finalizar | Samuel → Sala A, Confirmada → Finalizada ✅ |

Captura: [`evidencias/estacion-8-ejecucion.jpg`](../evidencias/estacion-8-ejecucion.jpg)

## Limitaciones del prototipo
La disponibilidad es una lista fija, entonces una misma sala puede salir en varias reservas
a la misma hora. Tampoco se controlan cruces de horario ni se guarda nada entre una
ejecucion y otra. Para conectarlo a algo real tocaria hacer otra implementacion de
`RepositorioSalas` y `RepositorioReservas` (por ejemplo contra una base de datos) y pasarsela
a la fachada; el resto del sistema no cambia.
