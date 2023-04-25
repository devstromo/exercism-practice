import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        var wordCounts = new HashMap<String, Integer>();
        var pattern = Pattern.compile("([a-zA-Z0-9]+(?:'[a-zA-Z0-9]+)?)");
        var matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group()
              .toLowerCase();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }
}
