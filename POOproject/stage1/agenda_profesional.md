# 📑 Ejercicio: Agenda Profesional en Java

## 🎯 Objetivo
Desarrollar un sistema modular de gestión de contactos en Java utilizando programación orientada a objetos (POO), encapsulamiento, manipulación de arreglos de objetos, validaciones de datos y un menú interactivo.

---

## 🏗️ Arquitectura del Proyecto

El proyecto está organizado en tres paquetes principales para garantizar la separación de responsabilidades:

```text
src/
├── modelo/
│   └── Contacto.java        # Representa la entidad individual Contacto
├── utilidades/
│   └── Agenda.java          # Lógica de negocio y gestión del arreglo de contactos
└── principal/
    └── Main.java            # Menú interactivo (do-while + switch) y pruebas
```

---

## 📋 Descripción de Clases y Funcionalidades

### 1. `modelo.Contacto`
Clase representativa que contiene los atributos de cada contacto.

* **Atributos:**
  * `nombre` (`String`): Nombre completo del contacto.
  * `edad` (`int`): Edad del contacto.
  * `correo` (`String`): Correo electrónico.
  * `telefono` (`String`): Número telefónico.
  * `favorito` (`boolean`): Estado si el contacto es favorito o no.
  * `direccion` (`String`): Dirección física.
* **Métodos principales:**
  * Constructor con todos los parámetros.
  * Getters y Setters necesarios.
  * `mostrarContacto()`: Imprime la información formateada mediante `printf`.

---

### 2. `utilidades.Agenda`
Clase encargada de administrar la colección de contactos almacenada en un arreglo estático (`Contacto[]`).

* **Atributos:**
  * `contactos` (`Contacto[]`): Arreglo de tamaño fijo.
  * `cantidad` (`int`): Contador de contactos guardados actualmente.
  * `capacidad` (`int`): Límite máximo de almacenamiento.

* **Métodos y Operaciones:**

| Método | Firma | Descripción |
| :--- | :--- | :--- |
| **Agregar** | `boolean agregarContacto(Contacto c)` | Agrega un contacto validando formato de correo y que la agenda no esté llena. |
| **Eliminar** | `boolean eliminar(String nombre)` | Elimina el contacto por nombre y realiza el desplazamiento de índices hacia la izquierda. |
| **Buscar** | `Contacto buscar(String nombre)` | Retorna el objeto `Contacto` coincidente o `null` si no existe. |
| **Listar** | `void mostrarContactos()` | Muestra todos los contactos registrados en formato tabular. |
| **Listar Favoritos** | `void listarFavoritos()` | Muestra únicamente los contactos con `favorito == true`. |
| **Contar Favoritos**| `int contarFavoritos()` | Retorna la cantidad total de contactos favoritos. |
| **Helpers** | `boolean estaLlena()`, `boolean estaVacia()` | Verifican los límites del arreglo. |

---

### 3. Rules & Validaciones de Correo Electronico

Al intentar agregar un contacto (`agregarContacto`), este debe superar las siguientes validaciones:
1. **Verificación de nulidad y vacíos:** El correo no debe ser `null` ni contener solo espacios en blanco.
2. **Formato:** Debe contener los caracteres `@` y `.`.
3. **Longitud:** 
   * Longitud mínima aceptable: $\ge 15$ caracteres (ej. `a@b.co`).
   * Longitud máxima aceptable: $\le 50$ caracteres.

---

## 🧪 Pruebas Automatizadas (`TestAgenda`)

Se incluye una clase de prueba que hace uso de la sintaxis `assert` de Java para verificar automáticamente la lógica de la agenda.

### Casos de Prueba Evaluados:
* **Prueba 1:** Agenda vacía e incompleta al inicio.
* **Prueba 2:** Inserción de contacto válido (`Juan Perez`).
* **Prueba 3:** Rechazo por correo inválido (sin `@`).
* **Prueba 4:** Rechazo por correo demasiado largo ($>50$ caracteres).
* **Prueba 5:** Rechazo por correo demasiado corto ($<15$ caracteres).
* **Prueba 6:** Rechazo por correo con espacios en blanco.
* **Prueba 7:** Correcto desplazamiento de elementos al eliminar un contacto intermedio.

> 💡 **Nota de ejecución:** Para ejecutar las pruebas habilitando los `assert`, recuerda agregar el argumento `-ea` (*enable assertions*) en tu terminal o IDE:
> ```bash
> java -ea src.Pruebas.TestAgenda
> ```