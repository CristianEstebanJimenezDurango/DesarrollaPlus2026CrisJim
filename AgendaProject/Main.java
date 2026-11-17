import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgendaEncapsulada agenda = new AgendaEncapsulada(2); 
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("       MENÚ AGENDA ENCAPSULADA          ");
            System.out.println("========================================");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto (por email)");
            System.out.println("3. Buscar contacto (por email)");
            System.out.println("4. Listar todos los contactos");
            System.out.println("5. Filtrar por nombre (prefijo)");
            System.out.println("6. Ver estado (Cantidad y Capacidad inicial)");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese email (debe contener '@'): ");
                    String email = sc.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = sc.nextLine();
                    
                    boolean agregado = agenda.agregar(new Contacto(nombre, email, telefono));
                    if (agregado) {
                        System.out.println("¡Contacto agregado con éxito!");
                    } else {
                        System.out.println(" No se pudo agregar (Contacto inválido o email duplicado).");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el email del contacto a eliminar: ");
                    String emailEliminar = sc.nextLine();
                    boolean eliminado = agenda.eliminar(emailEliminar);
                    if (eliminado) {
                        System.out.println("Contacto eliminado y posiciones reacomodadas con éxito.");
                    } else {
                        System.out.println("No se encontró ningún contacto con ese email.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el email del contacto a buscar: ");
                    String emailBuscar = sc.nextLine();
                    Contacto encontrado = agenda.buscar(emailBuscar);
                    if (encontrado != null) {
                        System.out.println("¡Contacto encontrado!");
                        System.out.println("   -> " + encontrado);
                    } else {
                        System.out.println(" Contacto no encontrado (null).");
                    }
                    break;

                case 4:
                    System.out.println("\n--- LISTA GENERAL DE CONTACTOS (COPIA DEFENSIVA) ---");
                    Contacto[] lista = agenda.listar();
                    if (lista.length == 0) {
                        System.out.println("La agenda está vacía.");
                    } else {
                        for (Contacto c : lista) {
                            System.out.println("  " + c);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el prefijo del nombre a buscar: ");
                    String prefijo = sc.nextLine();
                    Contacto[] filtrados = agenda.filtrarPorNombre(prefijo);
                    System.out.println("\n--- RESULTADOS DEL FILTRO ('" + prefijo + "') ---");
                    if (filtrados.length == 0) {
                        System.out.println(" No hay contactos que coincidan con ese prefijo.");
                    } else {
                        for (Contacto c : filtrados) {
                            System.out.println("  " + c);
                        }
                    }
                    break;

                case 6:
                    System.out.println(" Contactos guardados actualmente: " + agenda.getCantidad());
                    System.out.println(" Capacidad inicial configurada: " + agenda.getCapacidadInicial());
                    break;

                case 7:
                    System.out.println("¡Saliendo de la agenda encapsulada. ¡Hasta luego!");
                    break;

                default:
                    System.out.println(" Opción inválida. Elija una opción entre 1 y 7.");
            }
        } while (opcion != 7);

        sc.close();
}

}

