import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
          .map(charInt -> map(charInt, shiftKey))
          .mapToObj(i -> (char) i)
          .map(Object::toString)
          .collect(Collectors.joining());
    }

    private int map(int charInt, int shiftKey) {
        // space and dot
        if (charInt >= 32 && charInt <= 57) {
            return charInt;
        }
        // upper case
        if (charInt >= 65 && charInt <= 90) {
            return 65 + (charInt + shiftKey - 65) % 26;
        }
        // lower case
        if (charInt >= 97 && charInt <= 122) {
            return 97 + (charInt + shiftKey - 97) % 26;
        }
        return 0;
    }
}
