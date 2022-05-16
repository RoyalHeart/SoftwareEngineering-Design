enum Key {
    Q, CAPS_LOCK, SHIFT, FN, F11, F12
}

interface State {
    void tap(Context context, Key key);

    void hold(Context context, Key key);

    void release(Context context, Key key);
}

class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void tap(Key key) {
        state.tap(this, key);
    }

    public void hold(Key key) {
        state.hold(this, key);
    }

    public void release(Key key) {
        state.release(this, key);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

// initial state is when no key is pressed
class InitialState implements State {

    @Override
    public void tap(Context context, Key k) {
        switch (k) {
            case Q: {
                System.out.println("Initial tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Initial tap Capslock");
                context.setState(new CapslockState());
                break;
            }
            case SHIFT: {
                System.out.println("Initial tap shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void hold(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Initial hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Initial hold Capslock");
                context.setState(new CapslockState());
                break;
            }
            case SHIFT: {
                System.out.println("Initial hold shift");
                context.setState(new ShiftState());
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void release(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Initial release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Initial release Capsloc");
                break;
            }
            case SHIFT: {
                System.out.println("Initial release Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

}

// state when capslock is pressed
class CapslockState implements State {

    @Override
    public void tap(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Capslock tap Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Caplock tap Capslock");
                context.setState(new InitialState());
                break;
            }
            case SHIFT: {
                System.out.println("Capslock tap Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void hold(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Capslock hold Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Capslock hold Capslock");
                context.setState(new InitialState());
                break;
            }
            case SHIFT: {
                context.setState(new CapslockShiftState());
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void release(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Capslock release Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Capslock release Capslock");
                break;
            }
            case SHIFT: {
                System.out.println("Capslock release Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// State for shift key after initial state
class ShiftState implements State {
    @Override
    public void tap(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Shift Tap Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Shift Tap Capslock");
                context.setState(new CapslockShiftState());
                break;
            }
            case SHIFT: {
                System.out.println("Shift Tap Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void hold(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Shift hold Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Shift hold Capslock");
                context.setState(new CapslockShiftState());
                break;
            }
            case SHIFT: {
                System.out.println("Shift hold Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void release(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("Shift release Q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Shift release Capslock");
                break;
            }
            case SHIFT: {
                System.out.println("Shift release Shift");
                context.setState(new InitialState());
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// state for shift key after capslock state
class CapslockShiftState implements State {
    @Override
    public void tap(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("CapShift tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapShift tap Capslock");
                context.setState(new ShiftState());
                break;
            }
            case SHIFT: {
                System.out.println("CapShift tap Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void hold(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("CapShift hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapShift hold Capslock");
                context.setState(new ShiftState());
                break;
            }
            case SHIFT: {
                System.out.println("CapShift hold Shift");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }

    @Override
    public void release(Context context, Key key) {
        switch (key) {
            case Q: {
                System.out.println("CapShift release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapShift release Capslock");
                break;
            }
            case SHIFT: {
                System.out.println("CapShift release Shift");
                context.setState(new CapslockState());
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

public class Client {
    public static void main(String args[]) {
        System.out.println("Initial");
        System.out.println("===============");
        Context context = new Context(new InitialState());
        context.tap(Key.Q);
        context.tap(Key.CAPS_LOCK);
        context.tap(Key.Q);
        context.tap(Key.SHIFT);
        context.tap(Key.Q);
        context.hold(Key.CAPS_LOCK);
        context.tap(Key.Q);
        context.hold(Key.SHIFT);
        context.tap(Key.Q);
        context.tap(Key.CAPS_LOCK);
        context.tap(Key.Q);
        context.release(Key.CAPS_LOCK);
        context.tap(Key.Q);
        context.release(Key.SHIFT);
        context.tap(Key.Q);
        context.tap(Key.CAPS_LOCK);
        context.tap(Key.Q);
    }
}
