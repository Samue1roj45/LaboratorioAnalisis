# Estación 2 — Crear el dominio y ejecutar la primera versión

## Archivos creados
- `Estudiante.java`: representa a quien pide la sala (identificador y nombre).
- `Sala.java`: representa una sala fisica (codigo, nombre y capacidad).
- `Main.java` (version inicial): crea las cuatro salas de prueba y las muestra.

## Resultado esperado
Salen las cuatro salas (A: 2, B: 4, C: 6, D: 8) con su capacidad.

## Punto de control: ¿por que los atributos son privados y finales?
**Privados:** para que ninguna otra clase pueda meterse directamente a cambiar los datos.
Si alguien quiere saber el nombre de la sala lo pide con `getNombre()` y ya, pero no lo
puede tocar. Eso es el encapsulamiento, cada clase cuida sus propios datos.

**Finales:** porque una vez se crea el objeto ya no cambia. El constructor revisa que los
datos esten bien (que la sala no tenga capacidad 0, que el estudiante tenga nombre) y como
despues no se pueden modificar, el objeto siempre se queda valido. Asi uno no se lleva
sorpresas de que en algun punto del programa alguien le cambio algo por debajo.
