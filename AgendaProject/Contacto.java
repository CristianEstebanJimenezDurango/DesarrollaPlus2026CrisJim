public class Contacto {

    private String nombre;
    private String email;
    private String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    // Un contacto es válido si tiene nombre y un email con "@"
    public boolean esValido() {
        return nombre != null && !nombre.isBlank()
                && email != null && email.contains("@");
    }

    @Override
    public String toString() {
        return nombre + " <" + email + "> " + telefono;
    }
}