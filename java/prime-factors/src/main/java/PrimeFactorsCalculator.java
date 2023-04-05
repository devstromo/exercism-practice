import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> primes = new ArrayList<>();
        long prime = 2;
        while (number > 1) {
            if (number % prime == 0) {
                primes.add(prime);                
                number /= prime;
            } else
                prime++;
        }
        return primes;
    }
}
