package biblioteca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sala> disponibles = List.of(
            new Sala("A", "Sala A", 2),
            new Sala("B", "Sala B", 4),
            new Sala("C", "Sala C", 6),
            new Sala("D", "Sala D", 8)
        );

        System.out.println("=== P03: selección por capacidad ===");
        EstrategiaSeleccionSala porCapacidad = new SeleccionPorCapacidad();
        System.out.println("Para 4 personas: "
            + porCapacidad.seleccionar(disponibles, 4).orElse(null));

        System.out.println("\n=== P04: sala preferida C ===");
        EstrategiaSeleccionSala preferida = new SeleccionSalaPreferida("C");
        System.out.println("Preferida C: "
            + preferida.seleccionar(disponibles, 4).orElse(null));

        System.out.println("\n=== P05: sala preferida B para 7 personas ===");
        EstrategiaSeleccionSala preferidaNoAdecuada = new SeleccionSalaPreferida("B");
        System.out.println("Preferida B para 7: "
            + preferidaNoAdecuada.seleccionar(disponibles, 7).orElse(null));
    }
}
