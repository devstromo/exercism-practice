import java.util.regex.Pattern;

class SqueakyClean {
    static String clean(String identifier) {
        identifier = replaceControl(identifier);
        identifier = replaceNoLetters(identifier);
        identifier = replaceSpace(identifier);
        identifier = replaceGreeksUpper(identifier);
        identifier = kebabToCamel(identifier);
        return identifier;
    }

    private static String replaceSpace(String identifier) {
        return identifier.replaceAll(" ", "_");
    }

    private static String replaceControl(String identifier) {
        return identifier.replaceAll("\\p{C}", "CTRL").replaceAll("[\\r\\n\\t]", "CTRL");
    }

    private static String kebabToCamel(String identifier) {
        return Pattern.compile("-(.)")
            .matcher(identifier)
            .replaceAll(mr -> mr.group(1)
                .toUpperCase());
    }

    private static String replaceNoLetters(String identifier) {
        return identifier.replaceAll("[^\\p{L} ]", "");
    }
    private static String replaceGreeksUpper(String identifier) {
        return identifier.replaceAll("[\u03B1-\u03C9]", "");
    }
}
