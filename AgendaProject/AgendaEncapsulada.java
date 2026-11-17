public class AgendaEncapsulada {

    // ===== PUNTO 1 · ATRIBUTOS =====
    private Contacto[] contactos;          // el array interno (NUNCA se devuelve)
    private int cantidad;                  // cuántos contactos hay realmente guardados
    private final int capacidadInicial;    // final, se asigna una sola vez en el constructor

    // ===== PUNTO 2 · CONSTRUCTOR =====
    public AgendaEncapsulada(int capacidadInicial) {
        // TODO 2 completa el constructor
        //  Pista 1. capacidadInicial es final, así que solo se puede asignar aquí
        //  Pista 2. reserva el array con ese tamaño usando new Contacto[...]
        //  Pista 3. al inicio la agenda está vacía, ¿cuánto vale cantidad?
        //  Pista 4 (extra). ¿qué pasa si alguien manda 0 o un número negativo?
        this.capacidadInicial = capacidadInicial; // esta línea déjala, completa lo demás
        int capacidadValidad = Math.max(1, capacidadInicial); // asegura que sea al menos 1
        this.contactos = new Contacto[capacidadValidad];
        this.cantidad = 0;
    }

    // ===== PUNTO 3 · AGREGAR =====
    public boolean agregar(Contacto c) {

        // TODO 3.1 (regla 1) el contacto no puede ser null y debe ser válido
        //  Si c es null o c.esValido() es false, return false
        //  Ojo con el orden, primero pregunta por null
        if (c == null || !c.esValido()) {
            return false;
        }


        // TODO 3.2 (regla 2) el email no se puede repetir
        //  Recorre solo las posiciones ocupadas, for (int i = 0; i < cantidad; i++)
        //  Compara emails con equalsIgnoreCase(), no con ==
        //  Si ya hiciste buscar(), puedes usarlo aquí
        if (buscar(c.getEmail()) != null) {
            return false;
        }


        // RESUELTO 3.3 (regla 3) si el array está lleno, lo redimensionamos
        if (cantidad == contactos.length) {
            redimensionar();
        }
        contactos[cantidad] = c;
        cantidad++;
        return true;
    }

    // ===== PUNTO 4 · ELIMINAR =====
    public boolean eliminar(String email) {
        // TODO 4 busca por email, sácalo y corre los siguientes una posición
        //  Pista 1. primero encuentra el índice, si no está return false
        //  Pista 2. for (int i = indice; i < cantidad - 1; i++) contactos[i] = contactos[i + 1];
        //  Pista 3. pon en null la última posición ocupada y descuenta 1 a cantidad
        if (email == null) {
            return false;
        }

        int indice = -1;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getEmail().equalsIgnoreCase(email)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            return false;
        }
        for (int i = indice; i < cantidad - 1; i++) {
            contactos[i] = contactos[i + 1];
        }
        contactos[cantidad - 1] = null;
        cantidad--;
        return true;
    }

    // ===== PUNTO 5 · BUSCAR =====
    public Contacto buscar(String email) {
        // TODO 5 devuelve el contacto con ese email, o null si no existe
        //  Pista 1. si email es null, devuelve null directamente
        //  Pista 2. mismo recorrido que en la regla 2 (i < cantidad)
        //  Pista 3. usa equalsIgnoreCase()
        if (email == null) {
            return null;
        }
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getEmail().equalsIgnoreCase(email)) {
                return contactos[i];
            }
        }
        return null;
    }

    // ===== PUNTO 6 · LISTAR (COPIA) ===== RESUELTO
    public Contacto[] listar() {
        Contacto[] copia = new Contacto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            copia[i] = contactos[i];
        }
        return copia;
    }

    // ===== PUNTO 7 · FILTRAR POR NOMBRE ===== RESUELTO
    public Contacto[] filtrarPorNombre(String prefijo) {
        if (prefijo == null) {
            return new Contacto[0];
        }
        String prefijoMin = prefijo.toLowerCase();

        int coincidencias = 0;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().toLowerCase().startsWith(prefijoMin)) {
                coincidencias++;
            }
        }

        Contacto[] resultado = new Contacto[coincidencias];
        int j = 0;
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().toLowerCase().startsWith(prefijoMin)) {
                resultado[j] = contactos[i];
                j++;
            }
        }
        return resultado;
    }

    // ===== PUNTO 8 · REDIMENSIONAR (PRIVADO) ===== RESUELTO
    private void redimensionar() {
        Contacto[] nuevo = new Contacto[contactos.length * 2];
        for (int i = 0; i < cantidad; i++) {
            nuevo[i] = contactos[i];
        }
        contactos = nuevo;
    }

    // ===== Métodos de apoyo (solo lectura) =====
    public int getCantidad() { return cantidad; }
    public int getCapacidadInicial() { return capacidadInicial; }
}