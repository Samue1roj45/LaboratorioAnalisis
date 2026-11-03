package biblioteca;

/**
 * Versión TEMPORAL de Pendiente para poder compilar por incrementos
 * (ver nota de construcción de la Estación 3). Las transiciones reales
 * se implementan en la Estación 7 con Confirmada, Cancelada y Finalizada.
 */
public class Pendiente implements EstadoReserva {
    public String nombre() { return "Pendiente"; }

    public void confirmar(Reserva reserva) {
        System.out.println("(Transición a Confirmada pendiente de implementar: Estación 7)");
    }

    public void cancelar(Reserva reserva) {
        System.out.println("(Transición a Cancelada pendiente de implementar: Estación 7)");
    }

    public void finalizar(Reserva reserva) {
        throw new IllegalStateException("No se puede finalizar una reserva pendiente.");
    }
}
