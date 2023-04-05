import static java.lang.String.format;

public class ElonsToyCar {
    private int countDrives;

    public ElonsToyCar() {
        this.countDrives = 0;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return format("Driven %d meters", countDrives * 20);
    }

    public String batteryDisplay() {
        int remainder = 100 - countDrives;
        if (remainder == 0) {
            return "Battery empty";
        }
        return format("Battery at %d%%", remainder);
    }

    public void drive() {
        if (countDrives < 100)
            countDrives = countDrives + 1;
    }
}
