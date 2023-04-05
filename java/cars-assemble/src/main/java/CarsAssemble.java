public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double rate = rate(speed);
        return speed * 221 * rate;
    }

    public int workingItemsPerMinute(int speed) {
        double rate = rate(speed);
        return (int) (speed * 221 * rate / 60);
    }

    private double rate(int speed) {
        double rate = 1.0;
        if (speed >= 5 && speed <= 8) {
            rate = .9;
        } else if (speed == 9) {
            rate = .8;
        } else if (speed == 10) {
            rate = .77;
        }
        return rate;
    }
}
