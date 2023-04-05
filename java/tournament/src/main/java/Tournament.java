import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Tournament {
    private final Map<String, Team> cache = new HashMap<>();

    String printTable() {
        String print = "Team                           | MP |  W |  D |  L |  P\n";
        print += cache.values()
          .stream()
          .sorted(Comparator.comparing(Team::getPoints)
            .reversed()
            .thenComparing(Team::getName))
          .map(Team::toString)
          .collect(Collectors.joining());
        return print;
    }

    void applyResults(String resultString) {
        resultString.lines()
          .forEach(line -> {
              String[] data = line.split(";");
              cache.putIfAbsent(data[0], new Team(data[0]));
              cache.putIfAbsent(data[1], new Team(data[1]));
              if (data[2].equals("win")) {
                  cache.get(data[0])
                    .addWin();
                  cache.get(data[1])
                    .addLoss();
              } else if (data[2].equals("loss")) {
                  cache.get(data[1])
                    .addWin();
                  cache.get(data[0])
                    .addLoss();
              } else {
                  cache.get(data[1])
                    .addDraw();
                  cache.get(data[0])
                    .addDraw();
              }
          });
    }

    private static class Team {
        private final String name;

        private int total;
        private int wins;
        private int loss;
        private int draw;
        private int points;

        public Team(String name) {
            this.name = name;
        }

        public void addWin() {
            this.wins++;
            updatePoint();
            updateTotal();
        }

        public void addLoss() {
            this.loss++;
            updatePoint();
            updateTotal();
        }

        public void addDraw() {
            this.draw++;
            updatePoint();
            updateTotal();
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }

        private void updatePoint() {
            this.points = wins * 3 + draw;
        }

        private void updateTotal() {
            this.total++;
        }

        @Override
        public String toString() {
            return String.format("%-31s| %2s | %2s | %2s | %2s | %2s\n", name, total, wins, draw, loss, points);
        }
    }
}
