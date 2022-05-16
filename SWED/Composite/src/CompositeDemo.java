import java.util.List;
import java.util.ArrayList;

/** "Component" */
interface Graphic {
    // Prints the graphic.
    public void print();
}

/** "Composite" */
class CompositeGraphic implements Graphic {
    // Collection of child graphics.
    private final List<Graphic> childGraphics = new ArrayList<>();

    // Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    // Prints the graphic.
    @Override
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print(); // Delegation
        }
    }
}

/** "Leaf" */
class Ellipse implements Graphic {
    // Prints the graphic.
    @Override
    public void print() {
        System.out.println("Ellipse");
    }
}

/** Client */
class CompositeDemo {
    public static void main(String[] args) {
        // Initialize four ellipses
        Graphic ellipse1 = new Ellipse();
        Graphic ellipse2 = new Ellipse();
        Graphic ellipse3 = new Ellipse();
        Graphic ellipse4 = new Ellipse();

        // Creates two composites containing the ellipses
        CompositeGraphic compositGraphic2 = new CompositeGraphic();
        compositGraphic2.add(ellipse1);
        compositGraphic2.add(ellipse2);
        compositGraphic2.add(ellipse3);

        CompositeGraphic compositGraphic3 = new CompositeGraphic();
        compositGraphic3.add(ellipse4);

        // Create another graphics that contains two graphics
        CompositeGraphic compositGraphic = new CompositeGraphic();
        compositGraphic.add(compositGraphic2);
        compositGraphic.add(compositGraphic3);

        // Prints the complete graphic (Four times the string "Ellipse").
        compositGraphic.print();
    }
}
