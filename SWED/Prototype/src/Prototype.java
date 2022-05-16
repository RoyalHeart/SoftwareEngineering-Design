import java.util.HashMap;

public class Prototype {
    public static void main(String[] args) throws Exception {
        ShapeFactory shapeFactory = new ShapeFactory();

        // create a rectangle
        Shape rectangle = shapeFactory.createShape("Rectangle");
        System.out.println("My type: " + rectangle.getType());

        // create a circle
        Shape circle = shapeFactory.createShape("Circle");
        System.out.println("My type: " + circle.getType());

        // create a square
        Shape square = shapeFactory.createShape("Square");
        System.out.println("My type: " + square.getType());

    }
}

// sometimes a object of a factory can be made and implement singleton design
// pattern
class ShapeFactory {
    // create hash map
    private static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

    // when create a factory object then the prototype will be created
    public ShapeFactory() {
        // create a rectangle
        Shape rectangle = new Rectangle(true);
        shapeMap.put("Rectangle", rectangle);

        // create a circle
        Shape circle = new Circle(true);
        shapeMap.put("Circle", circle);

        // create a square
        Shape square = new Square(true);
        shapeMap.put("Square", square);
    }

    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return (Shape) shapeMap.get("Rectangle").clone();
        } else if (shapeType.equalsIgnoreCase("Circle")) {
            return (Shape) shapeMap.get("Circle").clone();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return (Shape) shapeMap.get("Square").clone();
        } else {
            return null;
        }
    }
}

abstract class Shape implements Cloneable {
    private String type = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void copy(Shape source) {
        this.type = source.getType();
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    };
}

class Rectangle extends Shape {
    public Rectangle() {
        setType("Rectangle");
    }

    public Rectangle(boolean isPrototype) {
        if (isPrototype) {
            setType("Rectangle");
        }
    }
}

class Circle extends Shape {
    public Circle() {
        setType("Circle");
    }

    public Circle(boolean isPrototype) {
        if (isPrototype) {
            setType("Circle");
        }
    }
}

class Square extends Shape {
    public Square() {
        setType("Square");
    }

    public Square(boolean isPrototype) {
        if (isPrototype) {
            setType("Square");
        }
    }
}