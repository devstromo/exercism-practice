import java.util.stream.Collectors;

class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.strip().length() <= 1 || candidate.chars()
          .filter(c -> !Character.isSpaceChar(c))
          .filter(c -> !Character.isDigit(c))
          .mapToObj(c -> String.valueOf((char) c))
          .collect(Collectors.joining())
          .length() > 0) {
            return false;
        }

        var strippedValue = candidate.strip().chars()
          .filter(c -> !Character.isSpaceChar(c))
          .mapToObj(c -> String.valueOf((char) c))
          .collect(Collectors.joining());

        var sum = 0;
        var count = 1;
        for (int i = strippedValue.length() - 1; i >= 0; i--) {
            var value = Integer.parseInt(strippedValue.charAt(i) + "");
            if (count % 2 == 0) {
                if (value * 2 > 9) {
                    value = value * 2 - 9;
                } else {
                    value = value * 2;
                }
            }
            count++;
            sum += value;
        }
        return sum % 10 == 0;
    }

}
