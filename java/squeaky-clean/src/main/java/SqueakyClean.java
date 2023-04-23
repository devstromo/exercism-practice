class SqueakyClean {
    static String clean(String identifier) {
        var result = new StringBuilder();

        var kebabCase = false;

        for (var c : identifier.toCharArray()) {
            if (c == ' ') {
                result.append('_');
            } else if (Character.isISOControl(c)) {
                result.append("CTRL");
            } else if (c == '-') {
                kebabCase = true;
            } else if (Character.isLetter(c)) {
                if (kebabCase) {
                    result.append(Character.toTitleCase(c));
                    kebabCase = false;
                } else if (c < 'α' || c > 'ω') {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
