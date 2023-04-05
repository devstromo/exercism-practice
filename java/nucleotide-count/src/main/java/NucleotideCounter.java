import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

    private final String dnaString;
    private final Map<Character, Integer> dnaCount = new HashMap<>() {{
        put('A', 0);
        put('C', 0);
        put('G', 0);
        put('T', 0);
    }};

    public NucleotideCounter(String dnaString) {
        validate(dnaString);
        this.dnaString = dnaString;
    }

    public Map<Character, Integer> nucleotideCounts() {
        for (int i = 0; i < dnaString.length(); i++) {
            dnaCount.put(dnaString.charAt(i), dnaCount.getOrDefault(dnaString.charAt(i), 0) + 1);
        }
        return dnaCount;
    }

    private void validate(String dnaString) {
        for (int i = 0; i < dnaString.length(); i++) {
            if (!dnaCount.containsKey(dnaString.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}