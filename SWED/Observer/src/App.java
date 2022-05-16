import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Source source = new SourceImplementation();

        new Display(source);
        new Count(source);

        source.startProcessing();

    }
}

abstract class Observer {
    protected Source source;

    public Observer(Source source) {
        this.source = source;
    }

    public void update() {
    };
}

interface Source {
    public void attach(Observer observer);

    public void startProcessing();

    public ArrayList<String> getState();
}

class SourceImplementation implements Source {
    String line;
    int index;
    ArrayList<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public ArrayList<String> getState() {
        ArrayList<String> state = new ArrayList<String>();
        state.add(line);
        state.add((String) Integer.toString(index));
        return state;
    }

    public void startProcessing() {
        index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start input");
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            for (Observer o : observers) {
                o.update();
            }
            index++;
        }
    }

}

class Display extends Observer {

    public Display(Source source) {
        super(source);
        source.attach(this);
    }

    public void update() {
        ArrayList<String> state = source.getState();
        System.out.println("#" + state.get(1) + " Display: " + state.get(0));
    }
}

class Count extends Observer {
    public Count(Source source) {
        super(source);
        source.attach(this);
    }

    public void update() {
        ArrayList<String> state = source.getState();
        System.out.println("#" + state.get(1) + " Count: " + state.get(0).length());
    }
}