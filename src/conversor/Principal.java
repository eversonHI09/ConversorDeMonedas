package conversor;

import conversor.ConsultaConversor;
import conversor.Intercambio;

import javax.swing.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Variable para almacenar la opción del menú seleccionada por el usuario
        int option= 0;
        // Cadena multilínea para las opciones del menú
        JOptionPane.showMessageDialog(null,"Bienvenido al conversor de moneda");
        JOptionPane.showMessageDialog(null,"Eliga el tipo de cambio para el dia de hoy");


        String menu = """
                
                Elija una opcion:
                
                1) Peso argentino a Dólar americano
                2) Real brasileño a Dólar americano
                3) Peso colombiano a Dólar americano
                4) Dólar americano a Peso argentino
                5) Dólar americano a Real brasileño
                6) Dólar americano a Peso colombiano
                7) Soles peruanos a Dólar americano
                8) Dólar americano a Soles peruanos
                9) Salir
                
                """;

        // Variables para almacenar los códigos de moneda para la conversión
        String base = null;
        String objeto = null;
        // Variable para almacenar el monto a convertir
        int conversion = 0;
        // Crear una instancia de ConsultaConversor para las operaciones de conversión
        ConsultaConversor montoAConvertir = new ConsultaConversor();

        // Bucle hasta que el usuario elija salir (opción 9)
        while(option != 9){
            System.out.println(menu);
            // Crear un objeto Scanner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);
            // Leer la opción del menú seleccionada por el usuario
            option = scanner.nextInt();
            // Verificar si el usuario quiere salir
            if(option == 9){
                // Mostrar mensaje de salida
                System.out.println("Saliendo del programa");
                System.out.println("***Gracias por su preferencia***");

                break;
            }else if (option < 1 || option > 9){
                // Mostrar mensaje de opción no válida
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println("Opcion no valida");
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

            }else{
                // Solicitar al usuario que ingrese el monto a convertir
                System.out.println("ingrese monto a convertir");
                // Leer el monto a convertir
                conversion = scanner.nextInt();
                // Variable para almacenar el resultado de la conversión
                Intercambio devuelveCambio;

                // Determinar los códigos de moneda según la selección del usuario

                switch (option) {
                    case 1:
                        base = "ARS";
                        objeto = "USD";
                        break;
                    case 2:
                        base = "BRL";
                        objeto = "USD";
                        break;
                    case 3:
                        base = "COP";
                        objeto = "USD";
                        break;
                    case 4:
                        base = "USD";
                        objeto = "ARS";
                        break;
                    case 5:
                        base = "USD";
                        objeto = "BRL";
                        break;
                    case 6:
                        base = "USD";
                        objeto = "COP";
                        break;
                    case 7:
                        base = "PEN";
                        objeto = "USD";
                        break;
                    case 8:
                        base = "USD";
                        objeto = "PEN";
                        break;
                }
                // Realizar la conversión de moneda
                devuelveCambio= montoAConvertir.buscarMoneda(base,objeto, conversion);

                // Mostrar el resultado de la conversión con dos decimales
                //System.out.println("---------------------------------------------------------");
                System.out.printf(conversion + " " + base + " equivale a: " + devuelveCambio.conversion_result() + " " + objeto);
                //System.out.println("---------------------------------------------------------");
            }
        }
    }
}
