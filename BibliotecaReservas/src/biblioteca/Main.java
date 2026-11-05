package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioSalas salas = new RepositorioSalasMemoria();
        RepositorioReservasMemoria reservas = new RepositorioReservasMemoria();
        ReservaFacade fachada = new ReservaFacade(salas, reservas,
            List.of(new NotificadorEstudiante(), new RegistroEventos()));

        System.out.println("=== P06: reserva exitosa mediante la fachada ===");
        fachada.realizarReserva(
            new Estudiante("E001", "Laura"),
            LocalDate.now().plusDays(7),
            LocalTime.of(14, 0),
            2,
            4,
            new SeleccionPorCapacidad()
        ).ifPresent(System.out::println);

        System.out.println("\n=== P10: solicitud para 10 personas ===");
        fachada.realizarReserva(
            new Estudiante("E003", "Camila"),
            LocalDate.now().plusDays(9),
            LocalTime.of(9, 0),
            2,
            10,
            new SeleccionPorCapacidad()
        );

        System.out.println("\nReservas registradas: " + reservas.obtenerTodas().size());
    }
}
