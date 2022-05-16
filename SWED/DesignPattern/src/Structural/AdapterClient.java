package Structural;

public class AdapterClient {
    public static void main(String[] args) {

        IPhone iPhone = new IPhone();
        USBC toLightning = new USBCToLighting(iPhone);
        toLightning.connect();
        toLightning.charge();
    }
}

interface Lightning {
    public void connect();

    public void charge();
}

interface USBC {
    public void connect();

    public void charge();
}

class Huawei implements USBC {
    public void connect() {
        System.out.println("Huawei USBC connected");
    }

    public void charge() {
        System.out.println("Huawei USBC charging");
    }
}

class IPhone implements Lightning {
    public void connect() {
        System.out.println("IPhone Lightning connected");
    }

    public void charge() {
        System.out.println("IPhone Lightning charging");
    }
}

class USBCToLighting implements USBC {
    private Lightning lightning;

    public USBCToLighting(Lightning lightning) {
        this.lightning = lightning;
    }

    public void connect() {
        lightning.connect();
    }

    public void charge() {
        lightning.charge();
    }
}
