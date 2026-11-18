public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla");
        vehicle.showinfo();
        vehicle.accelerate(50);
        vehicle.brake(20);
        vehicle.showinfo();

        Car car = new Car("Honda", "Civic", 4);
        car.showinfo();
        car.accelerate(60);
        car.brake(30);
        car.showinfo();

        Motorbike motorbike = new Motorbike("Yamaha", "R1", 1000, true);
        motorbike.showinfo();
        motorbike.accelerate(80);
        motorbike.brake(40);
        motorbike.showinfo();
    }
}
