import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

import java.util.stream.IntStream;

public class NaturalNumber {
    private final Integer number;

    public NaturalNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = rangeClosed(1, number / 2).parallel()
            .filter(value -> number % value == 0)
            .sum();
        if (sum == number) {
            return Classification.PERFECT;
        } else if (sum < number) {
            return Classification.DEFICIENT;
        }
        return Classification.ABUNDANT;
    }

    private IntStream factors() {
        return range(1, number + 1).filter(value -> number % value == 0);
    }

    private int aliquot() {
        return factors().sum() - number;
    }
}
