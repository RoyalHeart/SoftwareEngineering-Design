package Creational;

public class SingletonClient {

    public static void main(String[] args) {
        SingletonObject object = SingletonObject.getInstance();
        object.doSomething();
        SingletonObject object2 = SingletonObject.getInstance();
        object2.doSomething();
        SingletonObject object3 = SingletonObject.getInstance();
        object3.doSomething();
        SingletonObject object4 = SingletonObject.getInstance();
        object4.doSomething();
    }
}

class SingletonObject {
    private static SingletonObject INSTANCE = null;
    private int value;

    private SingletonObject() {
        System.out.println("SingletonObject created");
        value = 0;
    }

    public static SingletonObject getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonObject();
        }
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("SingletonObject doing something");
        value++;
        System.out.println("value: " + value);
    }
}
