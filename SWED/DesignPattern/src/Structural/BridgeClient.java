package Structural;

public class BridgeClient {
    public static void main(String[] args) {

        Shape circle = new Circle(new ColorBrush("Red"));
        circle.draw();
    }
}

abstract class Shape {
    ColorBrush colorBrush;

    Shape(ColorBrush colorBrush) {
        this.colorBrush = colorBrush;
    }

    void draw() {
    };
}

class Circle extends Shape {

    Circle(ColorBrush colorBrush) {
        super(colorBrush);
    }

    @Override
    public void draw() {
        colorBrush.drawCircle();
    }
}

class ColorBrush {
    private String color;

    ColorBrush(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("ColorBrush drawing");
    }

    public void drawCircle() {
        System.out.println("ColorBrush drawing circle with color: " + color);
    }
}