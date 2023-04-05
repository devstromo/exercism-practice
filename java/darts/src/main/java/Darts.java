import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

class Darts {
    int score(double xOfDart, double yOfDart) {
        double d = distance(xOfDart, yOfDart);
        if (d <= 1) {
            return 10;
        }
        if (d <= 5) {
            return 5;
        }
        if (d <= 10) {
            return 1;
        }
        return 0;
    }

    private double distance(double x, double y) {
        return sqrt(abs(x * x + y * y));
    }
}
