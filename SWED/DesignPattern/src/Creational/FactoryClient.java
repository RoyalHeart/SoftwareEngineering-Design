package Creational;

public class FactoryClient {
    public static void main(String[] args) {

        Dialog dialog = new WindowsDialog();
        dialog.render();
    }
}

interface Button {
    void render();

    void onClick();
}

class WinButton implements Button {
    public void render() {
        System.out.println("Rendering a Windows button");
    }

    public void onClick() {
        System.out.println("Windows button clicked");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Rendering a Mac button");
    }

    public void onClick() {
        System.out.println("Mac button clicked");
    }
}

abstract class Dialog {
    public void render() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WinButton();
    }
}

class MacDialog extends Dialog {

    @Override
    public Button createButton() {
        return new MacButton();
    }
}