package Ejercicio1.modelo;


public class Contacto {
    private String nombre;
    private String email;
    private String telefono;
    private int edad;

    public Contacto(String nombre, String email, String telefono, int edad) {
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
        setEdad(edad);
    }

    private boolean formatoEmailValido(String e) {
        if (e == null) return false;
        return e.contains("@") && e.contains(".");
    }

    private boolean formatoTelefonoValido(String t) {
        if (t == null || t.isEmpty()) return false;
        // Verifica que todos los caracteres sean dígitos numéricos
        for (char c : t.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && nombre.trim().length() >= 2) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public boolean setEmail(String email) {
        if (formatoEmailValido(email)) {
            this.email = email;
            return true;
        }
        return false;
    }

    public boolean setTelefono(String telefono) {
        if (formatoTelefonoValido(telefono)) {
            this.telefono = telefono;
            return true;
        }
        return false;
    }

    public boolean setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
            return true;
        }
        return false;
    }

    public void mostrarInfo() {
        System.out.printf("Contacto -> Nombre: %-12s | Email: %-20s | Tel: %-10s | Edad: %d\n",
                nombre, email, telefono, edad);
    }
}