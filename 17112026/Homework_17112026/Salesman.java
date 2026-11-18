 package Homework_17112026;

public class Salesman extends Employee{

    private double Monthlysales;
    private double comission;

    public Salesman(String name, double salaryBase, double Monthlysales, double comission){
        super(name, salaryBase);
        this.Monthlysales = Monthlysales;
        this.comission = comission;
    }
    
    @Override 
    public double calculateSalary() {
        return salaryBase + (Monthlysales * comission);
    }

     @Override 
     public void showInfo() {
        System.out.println("Vendedor: " + name);
        System.out.println("Ventas mes:" + Monthlysales);
        System.out.println("Base Salary: " + salaryBase);
    }

    
}