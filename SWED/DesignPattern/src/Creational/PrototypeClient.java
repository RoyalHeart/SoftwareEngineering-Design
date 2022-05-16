package Creational;

import java.util.HashMap;
import java.util.Map;

public class PrototypeClient {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        ShapeCache shapeCache = new ShapeCache();
        Shape circle = (Shape) shapeCache.getShape("Circle");
        circle.draw();
    }

}

abstract class Shape implements Cloneable {
    protected String type;

    abstract void draw();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class ShapeCache {
    private static Map<String, Shape> cache = new HashMap<String, Shape>();

    public static void loadCache() {
        cache.put("Circle", new Circle());
    }

    public Shape getShape(String type) {
        if (type.equals("Circle")) {
            return (Shape) cache.get(type).clone();
        }
        return null;
    }
}
