public class Vehicle {
    private String brand;
    private String model;
    private double speed;

    public Vehicle (String brand, String model){
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }

    public void accelerate(double increment) {
        if (increment < 0) {
            System.out.println("Increment must be positive.");
            return;
        }
        speed += increment;
        System.out.println("Accelerating. New speed: " + speed + " km/h");
    }

    public void brake(double decrement) {
        if (decrement < 0) {
            System.out.println("Decrement must be positive.");
            return;
        }
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Braking. New speed: " + speed + " km/h");
    }


    public void showinfo() {
        System.out.println("Vehicle brand: " + brand);
        System.out.println("Vehicle model: " + model);
        System.out.println("Current speed: " + speed + " km/h");
        System.out.println("-----------------------------");
    }

}
