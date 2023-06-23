class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        var isbn = stringToVerify.replace("-", "");
        if (isbn.length() != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                return false;
            }
            sum += (digit * (10 - i));
        }

        char lastChar = isbn.charAt(9);
        if (lastChar != 'X' && (lastChar < '0' || lastChar > '9')) {
            return false;
        }

        sum += (lastChar == 'X' ? 10 : (lastChar - '0'));

        return (sum % 11 == 0);
    }

}
