package app;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void clearConsole() {
        // Simula limpiar la consola imprimiendo líneas en blanco
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void printHeader() {
        System.out.println("===================================");
        System.out.println("==== ☎️ AGENDA DE CONTACTOS ☎️ ====");
        System.out.println("===================================");
    }

    public int show() {
        System.out.println("1. Agregar contacto al inicio");
        System.out.println("2. Agregar contacto al final");
        System.out.println("3. Eliminar contacto por nombre");
        System.out.println("4. Ordenar contactos por nombre");
        System.out.println("5. Mostrar todos los contactos");
        System.out.println("6. Vaciar la lista");
        System.out.println("7. Buscar contacto por nombre");
        System.out.println("0. Salir");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("SELECCIONE UNA OPCIÓN: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public String readString(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }

    public String readPhone(String label) {
        System.out.print(label);
        return scanner.next();
    }

    public void pressEnterToContinue() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
        clearConsole();
    }
}
