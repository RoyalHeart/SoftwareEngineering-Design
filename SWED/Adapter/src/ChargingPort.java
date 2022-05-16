// Adapter design pattern
public class ChargingPort {
    public static void main(String[] args) {
        Android android = new Android();
        IPhone iPhone = new IPhone();
        MicroUSB microUSB = new AdapterMicroUSB(iPhone);
        microUSB.recharge();
        microUSB.useMicroUSB();
        Huawei huawei = new Huawei();
        new AdapterMicroUSB(huawei).useMicroUSB();
        android.useMicroUSB();
        android.recharge();
    }
}

class AdapterMicroUSB implements MicroUSB {
    private final Lightning lightning;

    public AdapterMicroUSB(Lightning lightning) {
        this.lightning = lightning;
    }

    public void useMicroUSB() {
        System.out.println("Adapter: useMicroUSB");
        lightning.useLightning();
    }

    public void recharge() {
        System.out.println("Adapter: recharge");
        lightning.recharge();
    }
}

interface MicroUSB {
    void useMicroUSB();

    void recharge();
}

interface Lightning {
    void useLightning();

    void recharge();
}

class Android implements MicroUSB {
    public void useMicroUSB() {
        System.out.println("Android is using MicroUSB");
    }

    public void recharge() {
        System.out.println("Android is recharge");
    }
}

class IPhone implements Lightning {
    public void useLightning() {
        System.out.println("Iphone is using Lightning");
    }

    public void recharge() {
        System.out.println("Iphone is recharge");
    }
}

class Huawei implements Lightning {
    public void useLightning() {
        System.out.println("Huawei is using Lightning");
    }

    public void recharge() {
        System.out.println("Huawei is recharge");
    }
}