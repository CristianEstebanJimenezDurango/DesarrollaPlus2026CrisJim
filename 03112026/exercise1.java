

class Empleado{

    private String nombre;
    private int edad;
    private String cargo;
    private double salario;
    private int antiguedad;

    public Empleado(String nombre, int edad, String cargo, double salario, int antiguedad ) {
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = cargo;
        this.salario = salario;
        this.antiguedad = antiguedad;    
    }

    public double calcularBono(){
        if (antiguedad >= 5) {
            return salario * 0.20;
        } else {
            return salario * 0.10;
        }
    }

    public void cumplirAnio(){
        this.edad += 1;
        this.antiguedad += 1;
        this.salario += this.salario * 0.03;
    }

    public void mostrarFicha(){
        double bono = calcularBono();
        System.out.printf("--- Ficha de Empleado ---\n");
        System.out.printf("Nombre     : %s\n", nombre);
        System.out.printf("Edad       : %d años\n", edad);
        System.out.printf("Cargo      : %s\n", cargo);
        System.out.printf("Salario    : $%.2f\n", salario);
        System.out.printf("Antigüedad : %d años\n", antiguedad);
        System.out.printf("Bono       : $%.2f\n", bono);
        System.out.println("-------------------------");
    }


}

public class exercise1 {
    
    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Carlos Pérez", 30, "Desarrollador Java", 2500.0, 4);
        Empleado emp2 = new Empleado("María Gómez", 42, "Gerente de Proyectos", 4800.0, 7);
        Empleado emp3 = new Empleado("Juan Rodríguez", 25, "Analista Junior", 1500.0, 1);

        System.out.println("=== ESTADO INICIAL DE LOS EMPLEADOS ===");
        emp1.mostrarFicha();
        emp2.mostrarFicha();
        emp3.mostrarFicha();


        System.out.println("\n>>> Simulando el paso del tiempo: Carlos Pérez cumple 2 años en la empresa <<<\n");
        emp1.cumplirAnio();
        emp1.cumplirAnio();

  
        System.out.println("=== FICHAS FINALES DESPUÉS DE LOS CAMBIOS ===");
        emp1.mostrarFicha();
        emp2.mostrarFicha();
        emp3.mostrarFicha();
    }
}


