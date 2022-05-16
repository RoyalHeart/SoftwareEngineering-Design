import java.util.ArrayList;

import org.w3c.dom.css.CSS2Properties;

public class VisitorClient {
    public static void main(String[] args) throws Exception {
        Computer computer = new Computer();
        Mouse mouse1 = new Mouse();
        Keyboard keyboard1 = new Keyboard();
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();
        Monitor monitor2 = new Monitor();
        Keyboard keyboard2 = new Keyboard();
        Monitor monitor3 = new Monitor();
        Keyboard keyboard3 = new Keyboard();
        Computer computer11 = new Computer();
        Keyboard keyboard11 = new Keyboard();
        computer2.addPart(monitor3);
        computer2.addPart(keyboard3);

        computer1.addPart(computer2);
        computer1.addPart(monitor2);
        computer1.addPart(keyboard2);
        computer11.addPart(keyboard11);
        computer.addPart(mouse1);
        computer.addPart(keyboard1);
        computer.addPart(computer1);
        computer.addPart(computer11);

        VisitorPrint visitorPrint = new VisitorPrint();
        VisitorAssign visitorAssign = new VisitorAssign();
        computer.accept(visitorAssign);
        computer.accept(visitorPrint);
    }
}

interface VisitorInterface {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}

class VisitorAssign implements VisitorInterface {
    int level = 0;
    int innerLevel = 0;

    public void visit(Computer computer) {
        computer.id = Integer.toString(level) + Integer.toString(innerLevel);
        int temp = innerLevel;
        level += 1;
        innerLevel = 0;
        for (ComputerPart part : computer.parts) {
            innerLevel += 1;
            part.accept(this);
        }
        innerLevel = temp;
        level -= 1;
    }

    public void visit(Mouse mouse) {
        mouse.id = Integer.toString(level) + Integer.toString(innerLevel);
    }

    public void visit(Keyboard keyboard) {
        keyboard.id = Integer.toString(level) + Integer.toString(innerLevel);
    }

    public void visit(Monitor monitor) {
        monitor.id = Integer.toString(level) + Integer.toString(innerLevel);
    }
}

class VisitorPrint implements VisitorInterface {
    int level = 0;

    String getLevel() {
        String spaces = "";
        for (int i = 0; i < level; i++) {
            spaces += "-";
        }
        return spaces;
    }

    public void visit(Computer computer) {
        System.out.println(getLevel() + " Computer " + computer.id);
        level += 1;
        for (ComputerPart part : computer.parts) {
            part.accept(this);
        }
        level -= 1;
    }

    public void visit(Mouse mouse) {
        System.out.println(getLevel() + " Mouse " + mouse.id);
    }

    public void visit(Keyboard keyboard) {
        System.out.println(getLevel() + " Keyboard " + keyboard.id);
    }

    public void visit(Monitor monitor) {
        System.out.println(getLevel() + " Monitor " + monitor.id);
    }
}

abstract class ComputerPart {
    public String id;

    void accept(VisitorInterface visitor) {
    };
}

class Computer extends ComputerPart {
    String id;
    ArrayList<ComputerPart> parts = new ArrayList<>();

    public Computer() {
    };

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }

    public void addPart(ComputerPart part) {
        parts.add(part);
    }

    public void removePart(ComputerPart part) {
        parts.remove(part);
    }
}

class Mouse extends ComputerPart {
    String id;

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}

class Keyboard extends ComputerPart {
    String id;

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}

class Monitor extends ComputerPart {
    String id;

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}