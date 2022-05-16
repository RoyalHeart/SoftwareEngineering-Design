package Behavioral;

import java.util.ArrayList;
import java.util.Scanner;

public class ObserverClient {
    public static void main(String[] args) {
        Source source = new Publisher();
        new ConcreteObserver(source);
        source.startProcessing();
    }
}

interface Source {
    public void attach(Observer observer);

    public String getState();

    public void startProcessing();
}

class Publisher implements Source {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void startProcessing() {
        System.out.println("Start processing");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            state = scanner.nextLine();
            for (Observer observer : observers) {
                observer.update();
            }
        }
        scanner.close();
    }

    public String getState() {
        return state;
    }
}

abstract class Observer {
    protected Source source;

    Observer(Source source) {
        this.source = source;
        this.source.attach(this);
    }

    public void update() {
    }
}

class ConcreteObserver extends Observer {
    public ConcreteObserver(Source source) {
        super(source);
    }

    @Override
    public void update() {
        System.out.println("ConcreteObserver: " + source.getState());
    }
}