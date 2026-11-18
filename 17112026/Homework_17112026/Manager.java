package Homework_17112026;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double salaryBase, double bonus){
        super(name, salaryBase);
        this.bonus = bonus;
    }

    @Override 
    public double calculateSalary(){
        return salaryBase + bonus;
    }

    @Override 
    public void showInfo() {
        System.out.println("Vendedor: " + name);
        System.out.println("Bono:" + bonus);
        System.out.println("Base Salary: " + salaryBase);
    }
    
}
