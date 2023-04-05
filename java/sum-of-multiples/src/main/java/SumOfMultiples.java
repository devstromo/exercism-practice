import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    private final int[] set;
    private final int number;

    SumOfMultiples(int number, int[] set) {
        this.set = stream(set).filter(value -> value != 0)
          .toArray();
        this.number = number;
    }

    int getSum() {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i < number; i++) {
            for (int factor : set) {
                if (i % factor == 0) {
                    factors.add(i);
                }
            }
        }
        return factors.stream()
          .reduce(0, Integer::sum);
    }

    int getSumVariant() {
        return range(0, number)
          .filter(number -> stream(set).anyMatch(factor -> factor > 0 && number % factor == 0))
          .sum();
    }
}
