public class DecoratorClient {
    public static void main(String[] args) throws Exception {
        Component component = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent()));
        component.display();
    }
}

interface Component {
    public void display();
}

class ConcreteComponent implements Component {
    public void display() {
        System.out.println("ConcreteComponent");
    }
}

abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void display() {
        component.display();
    }
}

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void display() {
        super.display();
        System.out.println("ConcreteDecoratorA");
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void display() {
        super.display();
        System.out.println("ConcreteDecoratorB");
    }
}
