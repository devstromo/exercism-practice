import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {

    public boolean isPangram(String input) {
        Set<Character> charsSet = input.toLowerCase()
            .chars()
            .filter(value -> value > 96 && value < 123)
            .mapToObj(e -> (char) e)
            .collect(Collectors.toSet());
        return charsSet.size() == 26;
    }

}
