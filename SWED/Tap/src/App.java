public class App {
    public static void main(String[] args) throws Exception {
        Tap tap = new Tap();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            tap.tap(Key.a);
        }
        tap.tap(Key.Capslock);
        for (int i = 0; i < 10; i++) {
            tap.tap(Key.a);
        }
        tap.tap(Key.Capslock);
        for (int i = 0; i < 10; i++) {
            tap.tap(Key.a);
        }

    }
}

enum Key {
    q,
    Q,
    a,
    A,
    Capslock
}

class Tap {
    int count = 0;
    boolean isCapslock = false;

    public void tap(Key key) {
        if (key == Key.Capslock) {
            isCapslock = !isCapslock;
        } else {
            if (count == 0 && !isCapslock) {
                System.out.println(key.toString().toLowerCase());
                count++;
            } else {
                System.out.println(key.toString().toUpperCase());
                count++;
            }
            if (count >= 3) {
                count = 0;
            }
        }
    }
}