package Behavioral;

import java.util.ArrayList;

public class VisitorClient {
    public static void main(String[] args) {
        Visitor visitor = new DisplayVisitor();
        Computer c1 = new Computer();
        Keyboard k1 = new Keyboard();
        c1.addPart(k1);
        c1.accept(visitor);
    }
}

interface Visitor {
    void visit(Computer computer);

    void visit(Keyboard keyboard);

}

class DisplayVisitor implements Visitor {
    private int index = 0;
    private String space = "";

    String getSpace() {
        for (int i = 0; i < index; i++) {
            space += " ";
        }
        return space;
    }

    @Override
    public void visit(Computer computer) {
        System.out.println(getSpace() + "Display computer");
        index++;
        for (ComputerPart part : computer.parts) {
            part.accept(this);
        }
        index--;
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println(getSpace() + "Display keyboard");
    }
}

interface ComputerPart {
    void accept(Visitor visitor);
}

class Computer implements ComputerPart {
    ArrayList<ComputerPart> parts = new ArrayList<ComputerPart>();

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void addPart(ComputerPart part) {
        parts.add(part);
    }
}

class Keyboard implements ComputerPart {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
