package src.Principal;

import src.modelo.*;
import src.utilidades.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la agenda: ");
        int capacidad = scanner.nextInt();
        Agenda agenda = new Agenda(capacidad);

        // Aquí puedes agregar la lógica para interactuar con la agenda, como agregar contactos, mostrar contactos, etc.
        int opcion = 0;
        do {
            System.out.println("\n==================================");
            System.out.println("       MENÚ AGENDA PROFESIONAL    ");
            System.out.println("==================================");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Listar todos los contactos");
            System.out.println("5. Listar contactos favoritos");
            System.out.println("6. Contar favoritos");
            System.out.println("7. Ver estado (¿Llena o Vacía?)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                continue;
            }
            
            switch (opcion) {
                case 1:
                    if (agenda.estaLLena()) {
                        System.out.println("La agenda está llena. No se pueden agregar más contactos.");
                    } else {
                        System.out.print("Ingrese el nombre del contacto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la edad del contacto: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Ingrese el correo electrónico del contacto: ");
                        String correo = scanner.nextLine();
                        System.out.print("Ingrese el teléfono del contacto: ");
                        String telefono = scanner.nextLine();
                        System.out.print("¿Es favorito? (Si/No): ");
                        String favoritoStr = scanner.nextLine();
                        boolean favorito = favoritoStr.equalsIgnoreCase("Si");
                        System.out.print("Ingrese la dirección del contacto: ");
                        String direccion = scanner.nextLine();

                        Contacto nuevoContacto = new Contacto(nombre, edad, correo, telefono, favorito, direccion);
                        agenda.agregarContacto(nuevoContacto);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    Contacto contactoEliminar = agenda.buscarContacto(nombreEliminar);
                    if (contactoEliminar != null) {
                        agenda.eliminarContacto(contactoEliminar);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoBuscar = agenda.buscarContacto(nombreBuscar);
                    if (contactoBuscar != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println(contactoBuscar);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de todos los contactos:");
                    agenda.mostrarContactos();
                    break;
                case 5:
                    System.out.println("Lista de contactos favoritos:");
                    agenda.mostrarContactosFavoritos();
                    break;
                case 6:
                    int cantidadFavoritos = agenda.contarFavoritos();
                    System.out.println("Cantidad de contactos favoritos: " + cantidadFavoritos);
                    break;
                case 7:
                    if (agenda.estaLLena()) {
                        System.out.println("La agenda está llena.");
                    } else if (agenda.estaVacia()) {
                        System.out.println("La agenda está vacía.");
                    } else {
                        System.out.println("La agenda tiene espacio disponible.");
                    }
                case 8:
                    System.out.println("¡Saliendo de la agenda profesional. Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Elija entre 1 y 8");
                    break;
            }
    
        } while (opcion != 8);

        scanner.close();
    }
}

