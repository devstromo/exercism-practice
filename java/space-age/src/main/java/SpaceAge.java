import static java.lang.Math.round;

class SpaceAge {
    private final double ageInSeconds;

    SpaceAge(double seconds) {
        this.ageInSeconds = seconds;
    }

    double getSeconds() {
        return ageInSeconds;
    }

    double onEarth() {
        return generateAge(1.0);
    }

    double onMercury() {
        return generateAge(0.2408467);
    }

    double onVenus() {
        return generateAge(0.61519726);
    }

    double onMars() {
        return generateAge(1.8808158);
    }

    double onJupiter() {
        return generateAge(11.862615);
    }

    double onSaturn() {
        return generateAge(29.447498);
    }

    double onUranus() {
        return generateAge(84.016846);
    }

    double onNeptune() {
        return generateAge(164.79132);
    }

    private double generateAge(double planetConstant) {
        return (double) round((ageInSeconds / (planetConstant * 31557600)) * 100) / 100;
    }
}
