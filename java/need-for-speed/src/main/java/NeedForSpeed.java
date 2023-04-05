class NeedForSpeed {
    int speed;
    int batteryDrain;

    int runs;

    boolean isNitro;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.runs = 0;
    }

    public boolean batteryDrained() {
        return runs * batteryDrain >= 100;
    }

    public int distanceDriven() {
        return runs * speed;
    }

    public void drive() {
        if (!batteryDrained())
            runs++;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (car.distanceDriven() < distance && !car.batteryDrained()) {
            car.drive();
        }
        return !car.batteryDrained() || car.distanceDriven() == distance;
    }
}
