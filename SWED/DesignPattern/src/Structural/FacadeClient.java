package Structural;

public class FacadeClient {
    public static void main(String[] args) {
        House house = new House();
        house.draw();
    }
}

interface ShapeFacade {
    void draw();
}

class Square implements ShapeFacade {
    @Override
    public void draw() {
        System.out.println("Square drawn");
    }
}

class Triangle implements ShapeFacade {
    @Override
    public void draw() {
        System.out.println("Triangle drawn");
    }
}

class House implements ShapeFacade {
    ShapeFacade square;
    ShapeFacade triangle;

    @Override
    public void draw() {
        square.draw();
        triangle.draw();
        System.out.println("House drawn");
    }

    House() {
        square = new Square();
        triangle = new Triangle();
    }

}
