package Behavioral;

public class IteratorClient {

    public static void main(String[] args) {
        Container container = new Container();
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

class Container {
    private String[] items = { "A", "B", "C", "D", "E" };

    public Iterator getIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator {
        private int index;

        ConcreteIterator() {
            index = 0;
        }

        public boolean hasNext() {
            if (index < items.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.hasNext()) {
                return items[index++];
            }
            return null;
        }
    }
}
