public class SingletonBuilder implements Builder {
    private static Singleton instance = null;

    public void reset() {
        System.out.println("Reset SingletonBuilder");
        instance = null;
    }

    public Singleton createObject() {
        if (instance == null) {
            instance = Singleton.createObject();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonBuilder builder = new SingletonBuilder();
        Singleton singleton = builder.createObject();
        Singleton singleton2 = builder.createObject();
        System.out.println(singleton == singleton2); // the two object of class Singleton are the same object
    }

}

class Singleton {
    private String name = "Singleton";

    // hide the constructor
    private Singleton() {
        System.out.println("A new instance of Singleton is created");
        System.out.println();
    }

    public static Singleton createObject() {
        return new Singleton();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

interface Builder {
    public void reset();

    public Singleton createObject();
}
