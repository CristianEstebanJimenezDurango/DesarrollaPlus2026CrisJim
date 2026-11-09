package src.modelo;
public class Contacto {
    private String nombre;
    private int edad;
    private String correo;
    private String telefono;
    private boolean favorito;
    private String direccion;

    public Contacto(String nombre, int edad, String correo, String telefono, boolean favorito, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.favorito = favorito;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public String getDireccion(){
        return direccion;
    }

    public void mostrarContacto(){
        String favTexto = favorito ? "Favorito" : "";
        System.out.printf("Nombre: %-12s | Edad: %-3d | Tel: %-10s | Correo: %-20s | Dirección: %-15s | %s\n", 
                  nombre, edad, telefono, correo, direccion, favTexto);
    }


}