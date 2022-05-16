package Structural;

public class DecoratorClient {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator1(new ConcreteComponent());
        component.display();
    }
}

interface Component {
    public void display();
}

class ConcreteComponent implements Component {
    public void display() {
        System.out.println("Display: concrete component");
    }
}

abstract class Decorator implements Component {
    private Component component;

    Decorator(Component component) {
        this.component = component;
    }

    public void display() {
        component.display();
    }
}

class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    public void display() {
        System.out.println("hihi");
        super.display();
        System.out.println("hihi");
    }
}