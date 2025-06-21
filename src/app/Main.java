package app;

import structure.ContactList;

public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Menu menu = new Menu();

        boolean continuar = true;

        while (continuar) {
            menu.clearConsole();
            menu.printHeader();
            int option = menu.show();

            switch (option) {
                case 1 -> {
                    menu.clearConsole();
                    System.out.println("\n=================================");
                    System.out.println("☎️ AGREGAR CONTACTO AL INICIO ☎️");
                    System.out.println("=================================");
                    System.out.println("---------------------------------");
                    String name = menu.readString("Ingrese el nombre: ");
                    String phone = menu.readPhone("Ingrese el teléfono (8 dígitos): ");
                    System.out.println("---------------------------------");
                    contactList.addAtBeginning(name, phone);
                }
                case 2 -> {
                    menu.clearConsole();
                    System.out.println("\n================================");
                    System.out.println("☎️ AGREGAR CONTACTO AL FINAL ☎️");
                    System.out.println("================================");
                    System.out.println("--------------------------------");
                    String name = menu.readString("Ingrese el nombre: ");
                    String phone = menu.readPhone("Ingrese el teléfono (8 dígitos): ");
                    System.out.println("--------------------------------");
                    contactList.addAtEnd(name, phone);
                }
                case 3 -> {
                    menu.clearConsole();
                    System.out.println("\n===================================");
                    System.out.println("☎️ ELIMINAR CONTACTO POR NOMBRE ☎️");
                    System.out.println("===================================");
                    System.out.println("-----------------------------------");
                    String name = menu.readString("Ingrese el nombre a eliminar: ");
                    System.out.println("-----------------------------------");
                    contactList.delete(name);
                }
                case 4 -> {
                    contactList.sort();
                    contactList.printAll();
                }
                case 5 -> {
                    menu.clearConsole();
                    contactList.printAll();
                }
                case 6 -> {
                    contactList.clear();
                }
                case 7 -> {
                    menu.clearConsole();
                    System.out.println("\n================================");
                    System.out.println("☎️ BUSCAR CONTACTO POR NOMBRE ☎️");
                    System.out.println("================================");
                    System.out.println("---------------------------------");
                    String name = menu.readString("Ingrese el nombre a buscar: ");
                    System.out.println("---------------------------------");
                    contactList.searchByName(name);
                }
                case 0 -> {
                    menu.clearConsole();
                    continuar = false;
                    System.out.println("\n~~~~~~~~~~~~~~~~~~");
                    System.out.println("☎️ SALIENDO... ☎️");
                    System.out.println("~~~~~~~~~~~~~~~~~~");
                    break;
                }
                default -> {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("⚠️ OPCIÓN INVÁLIDA ⚠️");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                }
            }

            if (continuar) {
                menu.pressEnterToContinue();
            }
        }
    }
}
