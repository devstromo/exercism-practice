import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return scores;
    }

    Integer latest() {
        return scores.get(scores.size() - 1);
    }

    Integer personalBest() {
        return scores.stream()
          .max(Integer::compareTo)
          .orElse(-1);
    }

    List<Integer> personalTopThree() {
        return scores.stream()
          .sorted(Comparator.reverseOrder())
          .limit(3)
          .collect(Collectors.toList());
    }

}
