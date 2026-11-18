public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

   @Override 
    public void showinfo() {
        super.showinfo();
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("-----------------------------");
    }
    
}
