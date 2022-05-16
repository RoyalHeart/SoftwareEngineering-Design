package SWED;

public class Client {
    public static void main(String[] args) {
        Printer printer1 = new Printer1();
        printer1.print();
    }
}

class PrinterFactory {
    public static Printer getPrinter1() {
        return new Printer1();
    }
}

interface Printer {
    public void print();
}

class Printer1 implements Printer {
    private void print1() {
        System.out.println("This is printer 1");
    }

    @Override
    public void print() {
        print1();
    }
}
