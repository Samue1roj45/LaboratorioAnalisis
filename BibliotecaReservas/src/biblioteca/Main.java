package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReservaFacade fachada = new ReservaFacade(
            new RepositorioSalasMemoria(),
            new RepositorioReservasMemoria(),
            List.of(new NotificadorEstudiante(), new RegistroEventos())
        );

        System.out.println("=== P07: confirmar una reserva pendiente ===");
        Reserva r1 = crear(fachada, "E001", "Laura");
        System.out.println(r1);

        System.out.println("\n=== P08: cancelar una reserva confirmada ===");
        r1.cancelar();
        System.out.println(r1);

        System.out.println("\n=== P09: intentar confirmar una reserva cancelada ===");
        intentar(r1::confirmar);
        System.out.println(r1);

        System.out.println("\n=== P11: finalizar otra reserva confirmada ===");
        Reserva r2 = crear(fachada, "E004", "Samuel");
        r2.finalizar();
        System.out.println(r2);

        System.out.println("\n=== Intentar cancelar una reserva finalizada ===");
        intentar(r2::cancelar);
        System.out.println(r2);
    }

    private static Reserva crear(ReservaFacade fachada, String id, String nombre) {
        return fachada.realizarReserva(
            new Estudiante(id, nombre),
            LocalDate.now().plusDays(7),
            LocalTime.of(14, 0),
            2,
            2,
            new SeleccionPorCapacidad()
        ).orElseThrow();
    }

    private static void intentar(Runnable operacion) {
        try {
            operacion.run();
        } catch (IllegalStateException ex) {
            System.out.println("Operación rechazada: " + ex.getMessage());
        }
    }
}
