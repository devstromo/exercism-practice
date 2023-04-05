import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Anagram {
    private final String input;
    private final Map<Character, Integer> dictionary;

    public Anagram(String input) {
        this.input = input.toLowerCase();
        this.dictionary = new HashMap<>();
        for (int i = 0; i < this.input.length(); i++) {
            dictionary.put(this.input.charAt(i), dictionary.getOrDefault(this.input.charAt(i), 0) + 1);
        }
    }

    public List<String> match(List<String> words) {
        return words.stream()
          .filter(this::isAnagram)
          .collect(Collectors.toList());
    }

    private boolean isAnagram(String checkedWord) {
        if (this.input.length() != checkedWord.length() || this.input.equalsIgnoreCase(checkedWord)) {
            return false;
        }
        var internal = new HashMap<Character, Integer>();
        var lower = checkedWord.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            internal.put(lower.charAt(i), internal.getOrDefault(lower.charAt(i), 0) + 1);
        }
        var keys = dictionary.keySet();
        for (Character key : keys) {
            if (!internal.containsKey(key) || !internal.get(key)
              .equals(dictionary.get(key))) {
                return false;
            }
        }
        return true;
    }
}
