package Creational;

public class BuilderClient {

    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        Car sportCar = carBuilder.buildSportCar();
        sportCar.run();
        Car familyCar = carBuilder.buildFamilyCar();
        familyCar.run();
    }
}

class CarBuilder {
    Car car;

    Car buildSportCar() {
        reset();
        car.setType("Sport");
        car.setEngine("Sport engine");
        return car;
    }

    Car buildFamilyCar() {
        reset();
        car.setType("Family");
        car.setEngine("Family engine");
        return car;
    }

    void reset() {
        car = new Car();
    }
}

class Car {
    private String type;
    private String engine;

    void setEngine(String engine) {
        this.engine = engine;
        System.out.println("Engine: " + this.engine);
    }

    void setType(String type) {
        this.type = type;
        System.out.println("Type: " + this.type);
    }

    void run() {
        System.out.println("Car is running");
    }
}