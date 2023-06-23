import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GoCounting {
    private Player[][] board;

    public GoCounting(String boardString) {
        String[] rows = boardString.split("\n");
        int height = rows.length;
        int width = rows[0].length();
        board = new Player[height][width];
        for (int i = 0; i < height; i++) {
            String row = rows[i].trim();
            for (int j = 0; j < width; j++) {
                char c = row.charAt(j);
                if (c == 'B') {
                    board[i][j] = Player.BLACK;
                } else if (c == 'W') {
                    board[i][j] = Player.WHITE;
                } else {
                    board[i][j] = Player.NONE;
                }
            }
        }
    }

    public Player getTerritoryOwner(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            throw new IllegalArgumentException("Invalid coordinate");
        }

        if (board[x][y] != Player.NONE) {
            return Player.NONE;
        }

        Set<Point> visited = new HashSet<>();
        Set<Point> territory = new HashSet<>();
        boolean surrounded = dfs(x, y, visited, territory);
        if (surrounded) {
            Map<Player, Set<Point>> territories = getTerritories();
            if (territories.get(Player.BLACK)
              .containsAll(territory)) {
                return Player.BLACK;
            } else if (territories.get(Player.WHITE)
              .containsAll(territory)) {
                return Player.WHITE;
            }
        }

        return Player.NONE;
    }

    public Set<Point> getTerritory(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            throw new IllegalArgumentException("Invalid coordinate");
        }

        if (board[x][y] != Player.NONE) {
            return new HashSet<>();
        }

        Set<Point> visited = new HashSet<>();
        Set<Point> territory = new HashSet<>();
        dfs(x, y, visited, territory);
        return territory;
    }

    public Map<Player, Set<Point>> getTerritories() {
        int height = board.length;
        int width = board[0].length;
        Set<Point> visited = new HashSet<>();
        Map<Player, Set<Point>> territories = new HashMap<>();
        territories.put(Player.BLACK, new HashSet<>());
        territories.put(Player.WHITE, new HashSet<>());
        territories.put(Player.NONE, new HashSet<>());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited.contains(new Point(i, j)) && board[i][j] == Player.NONE) {
                    Set<Point> territory = new HashSet<>();
                    boolean surrounded = dfs(i, j, visited, territory);
                    if (surrounded) {
                        if (territories.get(Player.BLACK)
                          .containsAll(territory)) {
                            territories.get(Player.BLACK)
                              .addAll(territory);
                        } else if (territories.get(Player.WHITE)
                          .containsAll(territory)) {
                            territories.get(Player.WHITE)
                              .addAll(territory);
                        } else {
                            territories.get(Player.NONE)
                              .addAll(territory);
                        }
                    } else {
                        territories.get(Player.NONE)
                          .addAll(territory);
                    }
                }
            }
        }

        return territories;
    }

    private boolean dfs(int x, int y, Set<Point> visited, Set<Point> territory) {
        visited.add(new Point(x, y));

        boolean surrounded = true;
        int height = board.length;
        int width = board[0].length;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < height && ny >= 0 && ny < width) {
                Point neighbor = new Point(nx, ny);
                if (!visited.contains(neighbor)) {
                    if (board[nx][ny] == Player.NONE) {
                        if (!dfs(nx, ny, visited, territory)) {
                            surrounded = false;
                        }
                    } else if (board[nx][ny] == Player.BLACK) {
                        surrounded = false;
                    } else {
                        surrounded &= dfs(nx, ny, visited, territory);
                    }
                }
            } else {
                surrounded = false;
            }
        }

        if (surrounded) {
            territory.add(new Point(x, y));
        }

        return surrounded;
    }
    //
    //    public Player getTerritoryOwner(int x, int y) {
    //        if (!isValidCoordinate(x, y)) {
    //            throw new IllegalArgumentException("Invalid coordinate");
    //        }
    //
    //        if (board[x][y] != ' ') {
    //            return Player.NONE;
    //        }
    //
    //        Set<Point> territory = getTerritory(x, y);
    //        Set<Character> owners = new HashSet<>();
    //        boolean[][] visited = new boolean[rows][cols];
    //
    //        for (Point point : territory) {
    //            traverseTerritory(point.x, point.y, visited, new HashSet<>(), owners);
    //        }
    //
    //        if (owners.size() == 1) {
    //            return owners.contains('B') ? Player.BLACK : Player.WHITE;
    //        } else {
    //            return Player.NONE;
    //        }
    //    }
    //
    //    public Set<Point> getTerritory(int x, int y) {
    //        if (!isValidCoordinate(x, y)) {
    //            throw new IllegalArgumentException("Invalid coordinate");
    //        }
    //        var territory = new HashSet<Point>();
    //        var visited = new boolean[rows][cols];
    //        var player = board[x][y] == 'B' ? 'W' : board[x][y] == 'W' ? 'B' : ' ';
    //        traverseTerritory(x, y, visited, territory, new HashSet<>(player));
    //        return territory;
    //    }
    //
    //    public Map<Player, Set<Point>> getTerritories() {
    //        var territories = new HashMap<Player, Set<Point>>();
    //
    //        territories.put(Player.BLACK, new HashSet<>());
    //        territories.put(Player.WHITE, new HashSet<>());
    //        territories.put(Player.NONE, new HashSet<>());
    //
    //        for (int i = 0; i < rows; i++) {
    //            for (int j = 0; j < cols; j++) {
    //                if (board[i][j] == ' ') {
    //                    var owner = getTerritoryOwner(i, j);
    //                    var territory = getTerritory(i, j);
    //                    territories.get(owner)
    //                      .addAll(territory);
    //                }
    //            }
    //        }
    //        return territories;
    //    }
    //
    //    private char[][] convertStringToCharArray(String input) {
    //        var lines = input.split("\n");
    //        var rows = lines.length;
    //        var cols = lines[0].length();
    //        var result = new char[rows][cols];
    //        for (var i = 0; i < rows; i++) {
    //            result[i] = lines[i].toCharArray();
    //        }
    //        return result;
    //    }
    //
    //    private boolean isValidCoordinate(int x, int y) {
    //        return x >= 0 && x < rows && y >= 0 && y < cols;
    //    }
    //
    //    private void traverseTerritory(int x, int y, boolean[][] visited, Set<Point> territory, Set<Character> owners) {
    //        if (!isValidCoordinate(x, y) || visited[x][y]) {
    //            return;
    //        }
    //
    //        visited[x][y] = true;
    //
    //        if (board[x][y] == ' ') {
    //            territory.add(new Point(x, y));
    //        } else {
    //            owners.add(board[x][y]);
    //            return;
    //        }
    //
    //        traverseTerritory(x - 1, y, visited, territory, owners);
    //        traverseTerritory(x + 1, y, visited, territory, owners);
    //        traverseTerritory(x, y - 1, visited, territory, owners);
    //        traverseTerritory(x, y + 1, visited, territory, owners);
    //    }
}