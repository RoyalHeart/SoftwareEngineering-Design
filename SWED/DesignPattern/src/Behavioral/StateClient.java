package Behavioral;

public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        context.tap("Shift");
        context.tap("Shift");
        context.tap("Shift");
    }
}

class Context {
    private State state;

    public Context() {
        this.state = new InitialState();
    }

    public void tap(String name) {
        state.tap(this, name);
    }

    public void setState(State state) {
        this.state = state;
    }
}

interface State {
    public void tap(Context context, String name);
}

class InitialState implements State {
    public void tap(Context context, String name) {
        if (name == "Shift") {
            context.setState(new ShiftState());
        }
        System.out.println("InitialState");
    }
}

class ShiftState implements State {
    public void tap(Context context, String name) {
        if (name == "Shift") {
            context.setState(new InitialState());
        }
        System.out.println("ShiftState");
    }
}