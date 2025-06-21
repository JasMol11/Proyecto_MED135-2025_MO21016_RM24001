package structure;

import entity.ContactNode;

public class ContactList {
    private ContactNode head;

    public void addAtBeginning(String name, String phone) {
        if (!isValidPhone(phone) || isDuplicate(name)) return;
        ContactNode newNode = new ContactNode(name, phone);
        newNode.next = head;
        head = newNode;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("✅ CONTACTO AGREGADO AL INICIO ✅");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public void addAtEnd(String name, String phone) {
        if (!isValidPhone(phone) || isDuplicate(name)) return;
        ContactNode newNode = new ContactNode(name, phone);
        if (head == null) {
            head = newNode;
        } else {
            ContactNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("✅ CONTACTO AGREGADO AL FINAL ✅");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void delete(String name) {
        if (head == null) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ LISTA VACÍA ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            return;
        }

        if (head.getName().equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("✅ CONTACTO ELIMINADO ✅");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
            return;
        }

        ContactNode prev = head;
        ContactNode curr = head.next;

        while (curr != null && !curr.getName().equalsIgnoreCase(name)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ CONTACTO NO ENCONTRADO ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } else {
            prev.next = curr.next;
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("✅ CONTACTO ELIMINADO ✅");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ NADA QUE ORDENAR ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

            return;
        }

        for (ContactNode i = head; i != null; i = i.next) {
            for (ContactNode j = i.next; j != null; j = j.next) {
                if (i.getName().compareToIgnoreCase(j.getName()) > 0) {
                    String tempName = i.getName();
                    String tempPhone = i.getPhone();
                    i.setName(j.getName());
                    i.setPhone(j.getPhone());
                    j.setName(tempName);
                    j.setPhone(tempPhone);
                }
            }
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("✅ LISTA ORDENADA POR  NOMBRE ✅");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void printAll() {
        if (head == null) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ LISTA VACÍA ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~");

            return;
        }
        System.out.println("\n=========================================");
        System.out.println("=======☎️ CONTACTOS REGISTRADOS ☎️=======");
        System.out.println("=========================================");
        ContactNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("-----------------------------------------");
    }

    public void clear() {
        head = null;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
        System.out.println("✅ LISTA VACIADA ✅");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

    }

    public void searchByName(String name) {
        ContactNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.getName().equalsIgnoreCase(name)) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~ 🔍 CONTACTO ENCONTRADO 🔍 ~~");
                System.out.println("→ Nombre  : " + temp.getName());
                System.out.println("→ Teléfono: " + temp.getPhone());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ CONTACTO NO ENCONTRADO ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }



    private boolean isValidPhone(String phone) {
        if (!phone.matches("\\d{8}")) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("⚠️ NÚMERO INVÁLIDO - Debe contener exactamente 8 dígitos ⚠️");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            return false;
        }
        return true;
    }

    private boolean isDuplicate(String name) {
        ContactNode temp = head;
        while (temp != null) {
            if (temp.getName().equalsIgnoreCase(name)) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("⚠️ YA EXISTE UN CONTACTO CON ESE NOMBRE ⚠️");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
