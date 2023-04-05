import java.util.Map;

class ResistorColorDuo {
    private final Map<String, Integer> colorsMap = Map.of("black", 0, "brown", 1, "red", 2, "orange", 3, "yellow", 4, "green", 5, "blue", 6, "violet", 7,
        "grey", 8, "white", 9);

    int value(String[] colors) {
        return Integer.parseInt(colorsMap.get(colors[0]) + (colors.length > 1 ? String.valueOf(colorsMap.get(colors[1])) : ""));
    }
}
