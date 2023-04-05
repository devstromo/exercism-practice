class ReverseString {
    String reverse(String inputString) {
        int start = 0;
        int end = inputString.length() - 1;
        char[] reverse = inputString.toCharArray();
        while (start < end) {
            reverse[start] ^= reverse[end];
              reverse[end] ^= reverse[start];
            reverse[start] ^= reverse[end];
            start++;
            end--;
        }
        return String.valueOf(reverse);
    }
}
