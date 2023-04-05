import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketChecker {
    private final String input;

    private static final Set<Character> bracketsCollection = Set.of('}', '{', ']', '[', ')', '(');
    private static final Map<Character, Character> brackets = Map.of('}', '{', ']', '[', ')', '(');

    public BracketChecker(String input) {
        this.input = input;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        if (input == null || input.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if(bracketsCollection.contains(character)){
                if (brackets.containsKey(character)) {

                    if (stack.isEmpty() || !stack.pop()
                      .equals(brackets.get(character))) {
                        return false;
                    }
                } else {
                    stack.push(character);
                }
            }
        }
        return stack.isEmpty();
    }
}