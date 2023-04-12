class Bob {
    public String hey(String input) {
        if (input == null || input.trim()
          .isEmpty()) {
            return "Fine. Be that way!";
        }
        var hasLetters = hasLetters(input.trim());
        var isUpperString = hasLetters && isUppercase(input.trim());
        var isQuestion = isQuestion(input.trim());
        if (isQuestion && isUpperString) {
            return "Calm down, I know what I'm doing!";
        } else if (isUpperString) {
            return "Whoa, chill out!";
        } else if (isQuestion) {
            return "Sure.";
        }
        return "Whatever.";
    }

    private boolean isUppercase(String input) {
        return input.chars()
          .filter(Character::isAlphabetic)
          .mapToObj(value -> (char) value)
          .allMatch(Character::isUpperCase);
    }

    private boolean hasLetters(String input) {
        return input.chars()
          .filter(Character::isAlphabetic)
          .mapToObj(value -> (char) value)
          .findAny()
          .isPresent();
    }

    private boolean isQuestion(String input) {
        return input.charAt(input.length() - 1) == '?';
    }
}
