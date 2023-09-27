public class Car {
    double speed;
    double fuel;

    double CONS = 0.01;

    void accelerate(double amount) {
        speed += amount;
        fuel -= amount*CONS;
    }

    void fullBreak() {
        speed = 0;
    }

    void refuel(double amount) {
        fuel += amount;
    }


}
