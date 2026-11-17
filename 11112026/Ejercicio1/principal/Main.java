package Ejercicio1.principal;
import Ejercicio1.modelo.Contacto;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE ENCAPSULAMIENTO Y VALIDACIÓN ===\n");

        // Probando inserción correcta inicial
        Contacto c = new Contacto("Carlos", "carlos@correo.com", "3101234567", 30);
        c.mostrarInfo();

        System.out.println("\n--- Probando modificaciones inválidas ---");

        // c.setEdad(-50) debe retornar false y no modificar el valor anterior
        boolean resultadoEdad = c.setEdad(-50);
        System.out.println("¿Cambió edad a -50?: " + resultadoEdad + " (Edad actual: " + c.getEdad() + ")");

        // c.setEmail("xyz") debe retornar false y mantener el correo seguro
        boolean resultadoEmail = c.setEmail("xyz");
        System.out.println("¿Cambió email a 'xyz'?: " + resultadoEmail + " (Email actual: " + c.getEmail() + ")");

        // Probando un nombre muy corto
        boolean resultadoNombre = c.setNombre("A");
        System.out.println("¿Cambió nombre a 'A'?: " + resultadoNombre + " (Nombre actual: " + c.getNombre() + ")");

        System.out.println("\n--- Probando modificaciones válidas ---");
        c.setEdad(35);
        c.setEmail("carlos.nuevo@gmail.com");
        c.setNombre("Carlos Andrés");
        
        System.out.println("\nEstado final después de cambios válidos:");
        c.mostrarInfo();
    }
}