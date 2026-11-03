# Estación 1 — Comprender el problema y modelar el flujo

## Diagrama de flujo

```mermaid
flowchart TD
    A([Inicio]) --> B[El estudiante registra los datos de la solicitud]
    B --> C[El sistema consulta las salas disponibles]
    C --> D[La estrategia selecciona una sala]
    D --> E{¿Hay una sala adecuada?}
    E -- No --> F[Informar que no hay sala disponible]
    F --> Z([Fin sin reserva confirmada])
    E -- Sí --> G[Builder construye la reserva y valida los datos]
    G --> H[Facade registra la reserva en estado Pendiente]
    H --> I[Facade solicita la confirmación]
    I --> J[State valida el cambio Pendiente → Confirmada]
    J --> K[Observer notifica a los suscriptores]
    K --> L{¿El estudiante cancela o finaliza?}
    L -- Cancela --> M[State: Confirmada → Cancelada]
    L -- Finaliza --> N[State: Confirmada → Finalizada]
    M --> O[Observer notifica el cambio]
    N --> O
    O --> P([Fin])
```

## Responsabilidades que no deben quedar en Main

1. Representar los datos del estudiante y de la sala (`Estudiante`, `Sala`).
2. Construir la reserva y validar sus datos obligatorios (`ReservaBuilder`).
3. Elegir la sala según un criterio intercambiable (`EstrategiaSeleccionSala`).
4. Consultar las salas y guardar las reservas (`RepositorioSalas`, `RepositorioReservas`).
5. Coordinar el caso de uso completo de reservar (`ReservaFacade`).
6. Notificar los cambios de estado a los interesados (`ObservadorReserva`).
7. Controlar qué transiciones de estado son válidas (`EstadoReserva`).

## Comprobación

Una clase `Main` que consulte salas, valide datos, construya reservas, notifique y
controle estados tendría muchas razones distintas para cambiar. Sus métodos no
estarían relacionados entre sí (baja cohesión), y cualquier ajuste —por ejemplo,
un nuevo criterio de selección o un nuevo estado— obligaría a modificar la misma
clase, con riesgo de romper las demás funciones. Además sería difícil de probar por
partes y de entender, convirtiéndose en una *clase Dios*.
