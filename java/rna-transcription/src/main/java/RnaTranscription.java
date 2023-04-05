import java.util.stream.Collectors;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
            .mapToObj(this::mapValue)
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    private char mapValue(int charRepresentation) {
        switch ((char) charRepresentation) {
        case 'G':
            return 'C';
        case 'C':
            return 'G';
        case 'T':
            return 'A';
        default:
            return 'U';
        }
    }
}
