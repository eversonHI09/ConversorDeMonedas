package conversor;

// Declaración de una clase record llamada Intercambio
public record Intercambio(
        // Campo para almacenar la tasa de conversión
        String conversion_rate,
        // Campo para almacenar el resultado de la conversión
        String conversion_result,
        // Campo para almacenar el resultado (posiblemente un mensaje o descripción)
        String result) {
}
