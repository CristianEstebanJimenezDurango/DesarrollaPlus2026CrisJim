public class Motorbike extends Vehicle {
    private int cylinderCapacity;
    private boolean hasCylinder;

    public Motorbike(String brand, String model, int cylinderCapacity, boolean hasCylinder) {
        super(brand, model);
        if (!hasCylinder) {
            this.cylinderCapacity = 0;  
        } else {
            this.cylinderCapacity = cylinderCapacity;
        }
        this.hasCylinder = hasCylinder;
    
    }

    @Override
    public void showinfo() {
        super.showinfo();
        System.out.println("Has cylinder capacity: " + cylinderCapacity);
        System.out.println("Has cylinder: " + hasCylinder);
        System.out.println("-----------------------------");
    }
    
}
