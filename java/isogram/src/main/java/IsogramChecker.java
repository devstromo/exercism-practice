import java.util.HashSet;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        var set = new HashSet<Character>();
        var lower = phrase.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            if (lower.charAt(i) == '-' || lower.charAt(i) == ' ')
                continue;
            if (set.contains(lower.charAt(i)))
                return false;
            set.add(lower.charAt(i));
        }
        return true;
    }
}
