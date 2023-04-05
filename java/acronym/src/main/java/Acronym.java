import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Acronym {
    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        return Stream.of(phrase.split("[ -]"))
            .map(this::process)
            .collect(Collectors.joining());
    }

    private String process(String word) {
        var value = word.toUpperCase()
            .chars()
            .filter(Character::isAlphabetic)
            .findFirst();
        return value.isPresent() ? String.valueOf((char) value.getAsInt()) : "";
    }
}
