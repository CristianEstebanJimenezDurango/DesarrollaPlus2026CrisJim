package src.utilidades;

import src.modelo.*;

public class Agenda {

    private Contacto[] contactos;
    private int cantidad;
    private int capacidad;

    public Agenda( int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new Contacto[capacidad];
        this.cantidad = 0;
    }

    public boolean estaLLena(){
        return cantidad >= capacidad;
    }

    public boolean estaVacia(){
        return cantidad == 0;
    }

    private boolean validarEmail(String correo) {
        
        String correoRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!correo.matches(correoRegex)) {
            System.out.println("Correo electrónico inválido. Debe tener el formato: usuario@dominio.com");
            return false;
        }
        if (correo.length() > 50) {
            System.out.println("Correo electrónico demasiado largo. Debe tener un máximo de 50 caracteres.");
            return false;
        }
        if (correo.length() < 15) {
            System.out.println("Correo electrónico demasiado corto. Debe tener un mínimo de 15 caracteres.");
            return false;
        }
        
        return true;
    }

    public boolean agregarContacto(Contacto contacto) {
        if (estaLLena()) {
            System.out.println("La agenda está llena. No se puede agregar más contactos.");
            return false;
        }
        if (!validarEmail(contacto.getCorreo())) {
             return false;
        }
        contactos[cantidad] = contacto;
        cantidad++;
        System.out.println("Contacto agregado exitosamente.");
        return true;
    }

    public boolean eliminarContacto(Contacto contacto) {

        int indiceEncontrado = -1;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].equals(contacto)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("Contacto no encontrado.");
            return false;
        }

        for (int i = indiceEncontrado; i < cantidad - 1; i++) {
            contactos[i] = contactos[i + 1];
        }

        contactos[cantidad - 1] = null;
        cantidad--;
        System.out.println("Contacto eliminado exitosamente.");
        return true;
    }

    public Contacto buscarContacto(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return contactos[i];
            }
        }
        System.out.println("Contacto no encontrado.");
        return null;
    }

    public void mostrarContactos() {
        if (estaVacia()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("Contactos en la agenda:");
        for (int i = 0; i < cantidad; i++) {
            contactos[i].mostrarContacto();
        }
    }

    public void mostrarContactosFavoritos() {
        if (estaVacia()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("Contactos favoritos en la agenda:");
        boolean hayFavoritos = false;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].isFavorito()) {
                contactos[i].mostrarContacto();
                hayFavoritos = true;
            }
        }
        if (!hayFavoritos) {
            System.out.println("No hay contactos favoritos en la agenda.");
        }
    }

    public int contarFavoritos() {
        int contadorFavoritos = 0;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].isFavorito()) {
                contadorFavoritos++;
            }
        }
        return contadorFavoritos;
    }
}
