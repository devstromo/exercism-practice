import static java.lang.Math.log10;
import static java.lang.Math.pow;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        if (numberToCheck == 0) {
            return true;
        }
        int digits = digits(numberToCheck);
        int sum = String.valueOf(numberToCheck)
            .chars()
            .mapToObj(digit -> String.valueOf((char) digit))
            .map(Integer::parseInt)
            .map(digit -> (int) pow(digit, digits))
            .reduce(0, Integer::sum);
        return sum == numberToCheck;
    }

    private int digits(int number) {
        return (int) (log10(number) + 1);
    }

}
