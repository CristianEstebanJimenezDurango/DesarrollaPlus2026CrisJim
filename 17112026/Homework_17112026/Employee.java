package Homework_17112026;

public class Employee {
    
    protected String name;
    protected double salaryBase;

    public Employee(String name, double salaryBase) {
        this.name = name;
        this.salaryBase = salaryBase;
    }

    public double calculateSalary() {
        return salaryBase;
    }

    public void raiseSalary (double value){
        if (value > 0) {
            this.salaryBase += value;
        }
    }

    public void raiseSalary(double value, boolean isPercentage){
        if (value > 0) {
            if (isPercentage){
                this.salaryBase += this.salaryBase *(value/100.00);
            }else{
                this.salaryBase += value;
            }
        }
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + calculateSalary());
    }
}
