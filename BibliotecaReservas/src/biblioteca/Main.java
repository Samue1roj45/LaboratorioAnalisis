package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== P01: construcción con todos los datos ===");
        Reserva reserva = new ReservaBuilder()
            .estudiante(new Estudiante("E001", "Laura"))
            .fecha(LocalDate.now().plusDays(7))
            .horaInicio(LocalTime.of(14, 0))
            .duracionHoras(2)
            .cantidadPersonas(4)
            .sala(new Sala("B", "Sala B", 4))
            .build();
        System.out.println(reserva);

        System.out.println("\n=== P02: construcción sin estudiante ===");
        try {
            new ReservaBuilder()
                .fecha(LocalDate.now().plusDays(7))
                .horaInicio(LocalTime.of(14, 0))
                .duracionHoras(2)
                .cantidadPersonas(4)
                .sala(new Sala("B", "Sala B", 4))
                .build();
        } catch (IllegalStateException ex) {
            System.out.println("Construcción rechazada: " + ex.getMessage());
        }

        System.out.println("\n=== Prueba negativa: sala con capacidad insuficiente ===");
        try {
            new ReservaBuilder()
                .estudiante(new Estudiante("E001", "Laura"))
                .fecha(LocalDate.now().plusDays(7))
                .horaInicio(LocalTime.of(14, 0))
                .duracionHoras(2)
                .cantidadPersonas(6)
                .sala(new Sala("A", "Sala A", 2))
                .build();
        } catch (IllegalStateException ex) {
            System.out.println("Construcción rechazada: " + ex.getMessage());
        }
    }
}
