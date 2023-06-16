public class Hamming {
    private final String leftStrand;
    private final String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        var count = 0;
        for (int i = 0; i < leftStrand.length(); i++)
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                count++;
        return count;
    }

    private static void validate(String leftStrand, String rightStrand) {
        String msg = null;
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) {
            return;
        } else if (leftStrand.isEmpty()) {
            msg = "left strand must not be empty.";
        } else if (rightStrand.isEmpty()) {
            msg = "right strand must not be empty.";
        } else if (leftStrand.length() != rightStrand.length()) {
            msg = "leftStrand and rightStrand must be of equal length.";
        }
        if (msg != null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
