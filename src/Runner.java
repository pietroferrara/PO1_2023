public class Runner {

    public static void main(String[] args) {
        Car car = new Car();
        Car car2 = new Car();
        car.refuel(10);
        car.accelerate(100);
        car.accelerate(100);
        car.fullBreak();

        car2.accelerate(1000);
    }
}
