package examenParcial2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPerfiles gestorPerfiles = new GestorPerfiles("perfiles.dat");
        Jugador jugador = mostrarMenuDePerfil(gestorPerfiles);

        System.out.println("Bienvenido, " + jugador.getNombre() + "!");
        Programa programa = new Programa(jugador);
        programa.ejecutar();
        
        
    }

    public static Jugador mostrarMenuDePerfil(GestorPerfiles gestorPerfiles) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al juego. ¿Qué desea hacer?");
            System.out.println("1. Crear un nuevo perfil");
            System.out.println("2. Seleccionar un perfil existente");
            System.out.println("3. Salir del juego");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.next();
                gestorPerfiles.crearPerfil(nombre);
                return gestorPerfiles.seleccionarPerfil(nombre);
            } else if (opcion == 2) {
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.next();
                Jugador jugador = gestorPerfiles.seleccionarPerfil(nombre);

                if (jugador != null) {
                    return jugador;
                } else {
                    System.out.println("Perfil no encontrado. Intente nuevamente.");
                }
            } else if (opcion == 3) {
                System.out.println("Gracias por jugar. Hasta luego.");
                System.exit(0);
            } else {
                System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
            }
        }
    }
}
