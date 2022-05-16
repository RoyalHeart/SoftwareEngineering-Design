enum Key {
    Q, CAPS_LOCK, SHIFT, FN, F11, F12,
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
            case FN: {
                System.out.println("Initial tap fn");
                break;
            }
            case F11: {
                System.out.println("Initial tap f11");
                break;
            }
            case F12: {
                System.out.println("Initial tap f12");
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
            case FN: {
                System.out.println("Initial hold fn");
                context.setState(new FnState());
                break;
            }
            case F11: {
                System.out.println("Initial hold f11");
                break;
            }
            case F12: {
                System.out.println("Initial hold f12");
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
                System.out.println("Initial release Capslock");
                break;
            }
            case SHIFT: {
                System.out.println("Initial release Shift");
                break;
            }
            case FN: {
                System.out.println("Initial release fn");
                break;
            }
            case F11: {
                System.out.println("Initial release f11");
                break;
            }
            case F12: {
                System.out.println("Initial release f12");
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
            case FN: {
                System.out.println("Capslock tap fn");
                break;
            }
            case F11: {
                System.out.println("Capslock tap f11");
                break;
            }
            case F12: {
                System.out.println("Capslock tap f12");
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
                System.out.println("Capslock hold Shift");
                context.setState(new CapslockShiftState());
                break;
            }
            case FN: {
                System.out.println("Capslock hold fn");
                context.setState(new CapslockFnState());
                break;
            }
            case F11: {
                System.out.println("Capslock hold f11");
                break;
            }
            case F12: {
                System.out.println("Capslock hold f12");
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
            case FN: {
                System.out.println("Capslock release fn");
                break;
            }
            case F11: {
                System.out.println("Capslock release f11");
                break;
            }
            case F12: {
                System.out.println("Capslock release f12");
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
            case FN: {
                System.out.println("Shift Tap Fn");
                break;
            }
            case F11: {
                System.out.println("Shift Tap F11");
                break;
            }
            case F12: {
                System.out.println("Shift Tap F12");
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
            case FN: {
                System.out.println("Shift hold Fn");
                context.setState(new ShiftFnState());
                break;
            }
            case F11: {
                System.out.println("Shift hold F11");
                break;
            }
            case F12: {
                System.out.println("Shift hold F12");
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
            case FN: {
                System.out.println("Shift release Fn");
                break;
            }
            case F11: {
                System.out.println("Shift release F11");
                break;
            }
            case F12: {
                System.out.println("Shift release F12");
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
            case FN: {
                System.out.println("CapShift tap Fn");
                break;
            }
            case F11: {
                System.out.println("CapShift tap F11");
                break;
            }
            case F12: {
                System.out.println("CapShift tap F12");
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
            case FN: {
                System.out.println("CapShift hold Fn");
                context.setState(new CapslockShiftFnState());
                break;
            }
            case F11: {
                System.out.println("CapShift hold F11");
                break;
            }
            case F12: {
                System.out.println("CapShift hold F12");
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
            case FN: {
                System.out.println("CapShift release Fn");
                break;
            }
            case F11: {
                System.out.println("CapShift release F11");
                break;
            }
            case F12: {
                System.out.println("CapShift release F12");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// Fn state after initial state
class FnState implements State {
    @Override
    public void tap(Context context, Key k) {
        switch (k) {
            case Q: {
                System.out.println("Fn tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Fn tap Capslock");
                context.setState(new CapslockFnState());
                break;
            }
            case SHIFT: {
                System.out.println("Fn tap shift");
                break;
            }
            case FN: {
                System.out.println("Fn tap fn");
                break;
            }
            case F11: {
                System.out.println("Fn tap f11");
                System.out.println("Decrease volumn");
                break;
            }
            case F12: {
                System.out.println("Fn tap f12");
                System.out.println("Increase volumn");
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
                System.out.println("Fn hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Fn hold Capslock");
                context.setState(new CapslockFnState());
                break;
            }
            case SHIFT: {
                System.out.println("Fn hold shift");
                context.setState(new ShiftFnState());
                break;
            }
            case FN: {
                System.out.println("Fn hold fn");
                break;
            }
            case F11: {
                System.out.println("Fn hold f11");
                break;
            }
            case F12: {
                System.out.println("Fn hold f12");
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
                System.out.println("Fn release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("Fn release Capsloc");
                break;
            }
            case SHIFT: {
                System.out.println("Fn release Shift");
                break;
            }
            case FN: {
                System.out.println("Fn release fn");
                context.setState(new InitialState());
                break;
            }
            case F11: {
                System.out.println("Fn release f11");
                break;
            }
            case F12: {
                System.out.println("Fn release f12");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// Fn state after capslock state
class CapslockFnState implements State {
    @Override
    public void tap(Context context, Key k) {
        switch (k) {
            case Q: {
                System.out.println("CapslockFn tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockFn tap Capslock");
                context.setState(new FnState());
                break;
            }
            case SHIFT: {
                System.out.println("CapslockFn tap shift");
                break;
            }
            case FN: {
                System.out.println("CapslockFn tap fn");
                break;
            }
            case F11: {
                System.out.println("CapslockFn tap f11");
                System.out.println("Decrease luminosity");
                break;
            }
            case F12: {
                System.out.println("CapslockFn tap f12");
                System.out.println("Increase luminosity");
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
                System.out.println("CapslockFn hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockFn hold Capslock");
                context.setState(new FnState());
                break;
            }
            case SHIFT: {
                System.out.println("CapslockFn hold shift");
                context.setState(new CapslockShiftFnState());
                break;
            }
            case FN: {
                System.out.println("CapslockFn hold fn");
                context.setState(new FnState());
                break;
            }
            case F11: {
                System.out.println("CapslockFn hold f11");
                break;
            }
            case F12: {
                System.out.println("CapslockFn hold f12");
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
                System.out.println("CapslockFn release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockFn release Capsloc");
                break;
            }
            case SHIFT: {
                System.out.println("CapslockFn release Shift");
                break;
            }
            case FN: {
                System.out.println("CapslockFn release fn");
                context.setState(new CapslockState());
                break;
            }
            case F11: {
                System.out.println("CapslockFn release f11");
                break;
            }
            case F12: {
                System.out.println("CapslockFn release f12");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// Fn state after shift state
class ShiftFnState implements State {
    @Override
    public void tap(Context context, Key k) {
        switch (k) {
            case Q: {
                System.out.println("ShiftFn tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("ShiftFn tap Capslock");
                context.setState(new CapslockShiftFnState());
                break;
            }
            case SHIFT: {
                System.out.println("ShiftFn tap shift");
                break;
            }
            case FN: {
                System.out.println("ShiftFn tap fn");
                break;
            }
            case F11: {
                System.out.println("ShiftFn tap f11");
                System.out.println("Decrease luminosity");
                break;
            }
            case F12: {
                System.out.println("ShiftFn tap f12");
                System.out.println("Increase luminosity");
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
                System.out.println("ShiftFn hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("ShiftFn hold Capslock");
                context.setState(new CapslockShiftFnState());
                break;
            }
            case SHIFT: {
                System.out.println("ShiftFn hold shift");
                break;
            }
            case FN: {
                System.out.println("ShiftFn hold fn");
                break;
            }
            case F11: {
                System.out.println("ShiftFn hold f11");
                break;
            }
            case F12: {
                System.out.println("ShiftFn hold f12");
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
                System.out.println("ShiftFn release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("ShiftFn release Capslock");
                break;
            }
            case SHIFT: {
                System.out.println("ShiftFn release Shift");
                context.setState(new FnState());
                break;
            }
            case FN: {
                System.out.println("ShiftFn release fn");
                context.setState(new ShiftState());
                break;
            }
            case F11: {
                System.out.println("ShiftFn release f11");
                break;
            }
            case F12: {
                System.out.println("ShiftFn release f12");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

// Fn state after capslock shift state
class CapslockShiftFnState implements State {
    @Override
    public void tap(Context context, Key k) {
        switch (k) {
            case Q: {
                System.out.println("CapslockShiftFn tap q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockShiftFn tap Capslock");
                context.setState(new ShiftFnState());
                break;
            }
            case SHIFT: {
                System.out.println("CapslockShiftFn tap shift");
                break;
            }
            case FN: {
                System.out.println("CapslockShiftFn tap fn");
                break;
            }
            case F11: {
                System.out.println("CapslockShiftFn tap f11");
                System.out.println("Decrease volumn");
                break;
            }
            case F12: {
                System.out.println("CapslockShiftFn tap f12");
                System.out.println("Increase volumn");
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
                System.out.println("CapslockShiftFn hold q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockShiftFn hold Capslock");
                context.setState(new ShiftFnState());
                break;
            }
            case SHIFT: {
                System.out.println("CapslockShiftFn hold shift");
                break;
            }
            case FN: {
                System.out.println("CapslockShiftFn hold fn");
                break;
            }
            case F11: {
                System.out.println("CapslockShiftFn hold f11");
                break;
            }
            case F12: {
                System.out.println("CapslockShiftFn hold f12");
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
                System.out.println("CapslockShiftFn release q");
                break;
            }
            case CAPS_LOCK: {
                System.out.println("CapslockShiftFn release Capsloc");
                break;
            }
            case SHIFT: {
                System.out.println("CapslockShiftFn release Shift");
                context.setState(new CapslockFnState());
                break;
            }
            case FN: {
                System.out.println("CapslockShiftFn release fn");
                context.setState(new CapslockShiftState());
                break;
            }
            case F11: {
                System.out.println("CapslockShiftFn release f11");
                break;
            }
            case F12: {
                System.out.println("CapslockShiftFn release f12");
                break;
            }
            default: {
                System.out.println("UNKNOWN KEY");
            }
        }
    }
}

public class ClientExtend {
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
        context.tap(Key.F11);
        context.hold(Key.FN);
        context.tap(Key.F11);
        context.tap(Key.F12);
        context.hold(Key.SHIFT);
        context.tap(Key.F11);
        context.release(Key.SHIFT);
        context.tap(Key.CAPS_LOCK);
        context.tap(Key.F11);
        context.tap(Key.F12);
        context.hold(Key.SHIFT);
        context.tap(Key.F11);
        context.tap(Key.F12);
    }
}
