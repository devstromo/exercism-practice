import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

    private final boolean[] sieve;

    Sieve(int maxPrime) {
        this.sieve = new boolean[maxPrime + 1];
    }

    List<Integer> getPrimes() {
        Arrays.fill(sieve, true);
        int limit = (int) sqrt(sieve.length - 1);
        for (int p = 2; p <= limit; p++) {
            if (sieve[p]) {
                for (int i = p * p; i <= sieve.length - 1; i += p) {
                    sieve[i] = false;
                }
            }
        }

        return IntStream.range(2, sieve.length)
            .filter(value -> sieve[value])
            .boxed()
            .collect(Collectors.toList());
    }
}
