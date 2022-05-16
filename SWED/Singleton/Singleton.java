public class Singleton {

    // hide the constructor from the client
    protected Singleton() {
        System.out.println("A new instance of Singleton is created");
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Singleton singleton = factory.getInstance();
        Singleton singleton2 = factory.getInstance();
        System.out.println(singleton == singleton2); // the two object of class Singleton are the same object
    }
}

// factory to create an only instance of Singleton
class Factory {
    private static Singleton INSTANCE = null;

    public Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}