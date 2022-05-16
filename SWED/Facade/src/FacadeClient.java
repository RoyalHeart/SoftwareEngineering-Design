public class FacadeClient {
    public static void main(String[] args) throws Exception {
        HouseFacade houseFacade = new HouseFacade();
        houseFacade.drawHouse(); // hide the step need to draw a house
    }
}

interface Shape {
    public void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Draw a circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Draw a rectangle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Draw a triangle");
    }
}

class HouseShape implements Shape {
    private Rectangle rectangle;
    private Triangle triangle;

    HouseShape(Rectangle rectangle, Triangle triangle) {
        this.rectangle = rectangle;
        this.triangle = triangle;
    }

    public void draw() {
        rectangle.draw();
        triangle.draw();
    }
}

class HouseFacade {
    private Shape rectangle;
    private Shape triangle;

    public void drawHouse() {
        rectangle = new Rectangle();
        triangle = new Triangle();
        rectangle.draw();
        triangle.draw();
    }
}