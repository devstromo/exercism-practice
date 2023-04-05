import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {
    private final Map<String, Integer> colors = new LinkedHashMap<>() {{
        put("black", 0);
        put("brown", 1);
        put("red", 2);
        put("orange", 3);
        put("yellow", 4);
        put("green", 5);
        put("blue", 6);
        put("violet", 7);
        put("grey", 8);
        put("white", 9);
    }};

    int colorCode(String color) {
        return colors.get(color.toLowerCase());
    }

    String[] colors() {
        return colors.keySet()
            .toArray(new String[0]);
    }
}
