package src.Pruebas;

import src.modelo.*;
import src.utilidades.*;

public class TestAgenda {

    public static void main(String[] args) {
        
        System.out.println("=== INICIANDO PRUEBAS AUTOMATIZADAS DE LA AGENDA ===");

        Agenda agenda = new Agenda(3);

        assert !agenda.estaLLena() : "La agenda debería estar vacía al inicio.";
        assert agenda.estaVacia() : "La agenda debería estar vacía al inicio.";

        Contacto contacto1 = new Contacto("Juan Perez", 30, "JuanPerez@gmail.com", "1234567890", true, "Calle Falsa 123");
        Contacto contacto2 = new Contacto("Maria Lopez", 25,"correo-malo.com", "0987654321", false, "Avenida Siempre Viva 456");
        Contacto contacto3 = new Contacto("Carlos Sanchez", 40, "jklahsdkjahsdjkahsdkjashdkajshdkjawhdjkawhdjkawhdjkawhdjkadhjkawhdkajdhjkaw@gmail.com", "1122334455", true, "Boulevard de los Sueños Rotos 789");
        Contacto contacto4 = new Contacto("Ana Torres", 28, "1@gmail.com", "6677889900", false, "Calle del Sol 101");
        Contacto contacto5 = new Contacto("Luis Ramirez", 35, " ", "5566778899", true, "Calle Luna 202");
        Contacto contacto6 = new Contacto("Pedro Martinez", 32, "pedro.martinez@gmail.com", "4455667788", false, "Calle Principal 303");

        boolean agregado1 = agenda.agregarContacto(contacto1);
        boolean agregado2 = agenda.agregarContacto(contacto2);
        boolean agregado3 = agenda.agregarContacto(contacto3);
        boolean agregado4 = agenda.agregarContacto(contacto4);
        boolean agregado5 = agenda.agregarContacto(contacto5);
        boolean agregado6 = agenda.agregarContacto(contacto6);


        assert agregado1 : "El contacto 1 debería haberse agregado correctamente.";
        assert !agregado2 : "El contacto 2 no debería haberse agregado debido a un correo inválido.";
        assert !agregado3 : "El contacto 3 no debería haberse agregado debido a un correo demasiado largo.";
        assert !agregado4 : "El contacto 4 no debería haberse agregado debido a un correo demasiado corto.";
        assert !agregado5 : "El contacto 5 no debería haberse agregado debido a un espacio.";
        assert agregado6 : "El contacto 6 debería haberse agregado correctamente.";

        assert !agenda.estaVacia() : "La agenda no debería estar vacía después de agregar contactos.";

        Contacto contacto7 = new Contacto("Luis Ramirez", 35, "Luisramirez@gmail.com", "5566778899", true, "Calle Luna 202");

        boolean agregado7 = agenda.agregarContacto(contacto7);
        assert !agregado7 : "El contacto 7 debería haberse agregado correctamente.";


        Contacto contacto8 = new Contacto("Pedro Martinez", 32, "PedroMartinez@gmail.com", "4455667788", false, "Calle Principal 303"); 
        boolean agendaLLena = agenda.agregarContacto(contacto8);
        assert !agendaLLena : "El contacto 8 no debería haberse agregado porque la agenda está llena.";

        agenda.mostrarContactos();

        assert agenda.estaLLena() : "La agenda debería estar llena después de agregar contactos.";

        assert agenda.contarFavoritos() == 2 : "Debería haber 2 contactos favoritos en la agenda.";

        agenda.mostrarContactosFavoritos();

        Contacto encontrado = agenda.buscarContacto("Juan Perez");
        assert encontrado != null : "El contacto 'Juan Perez' debería encontrarse en la agenda.";

        Contacto noEncontrado = agenda.buscarContacto("No Existe");
        assert noEncontrado == null : "El contacto 'No Existe' no debería encontrarse en la agenda.";   

        boolean eliminado = agenda.eliminarContacto(contacto1);
        assert eliminado : "El contacto 'Juan Perez' debería haberse eliminado correctamente.";
        assert agenda.buscarContacto("Juan Perez") == null : "El contacto 'Juan Perez' no debería encontrarse después de ser eliminado.";
        assert agenda.estaLLena() == false : "La agenda no debería estar llena después de eliminar un contacto.";

        System.out.println("=== PRUEBAS AUTOMATIZADAS COMPLETADAS EXITOSAMENTE ===");
    }
}
