public class RunLengthEncoding {

    public String encode(String input) {
        StringBuilder encoding = new StringBuilder();
        int n = input.length();
        for (int index = 0; index < n; index++) {
            int count = 1;
            while (index < n - 1 && input.charAt(index) == input.charAt(index + 1)) {
                count++;
                index++;
            }
            if (count == 1) {
                encoding.append(input.charAt(index));
            } else {
                encoding.append(count)
                  .append(input.charAt(index));
            }
        }
        return encoding.toString();
    }

    public String decode(String input) {

        int n = input.length();
        StringBuilder sb = new StringBuilder();
        String number = "";
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(input.charAt(i))) {
                number += input.charAt(i) + "";
            } else {
                int cant = number.length() > 0 ? Integer.parseInt(number) : 1;
                sb.append(repeat(cant, input.charAt(i)));
                number = "";
            }
        }
        return sb.toString();
    }

    private static String repeat(int length, char charAt) {
        return String.valueOf(charAt)
          .repeat(Math.max(0, length));
    }
}


