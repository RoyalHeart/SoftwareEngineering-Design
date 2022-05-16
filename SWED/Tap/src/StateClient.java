public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        for (int i = 0; i < 5; i++) {
            context.tap(Key.a);
        }
        context.tap(Key.Capslock);
        for (int i = 0; i < 5; i++) {
            context.tap(Key.a);
        }

    }
}

enum Key {
    a,
    q,
    Capslock,
}

class Context {
    private State state;

    public Context() {
        this.state = new InitialState();
    }

    public void tap(Key key) {
        state.tap(this, key);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

interface State {
    public void tap(Context context, Key key);
}

class InitialState implements State {
    public void tap(Context context, Key key) {
        if (key == Key.Capslock) {
            context.setState(new CapslockState());
        } else {
            System.out.println(key.toString().toLowerCase());
        }
    }
}

class CapslockState implements State {
    public void tap(Context context, Key key) {
        if (key == Key.Capslock) {
            context.setState(new InitialState());
        } else {
            System.out.println(key.toString().toUpperCase());
        }
    }
}