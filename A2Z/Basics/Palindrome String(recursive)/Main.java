class Main {

    static boolean palindrome(int i, String s) {

        // Base Condition
        // If i exceeds half of the string, means all the elements
        // are compared, we return true.
        if (i >= s.length() / 2)
            return true;

        // If start is not equal to end, not palindrome.
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;

        // If both characters are same, increment i and check start+1 and end-1.
        return palindrome(i + 1, s);

    }

    public static void main(String[] args) {

        // Example string.
        String s = "madam";
        System.out.println(palindrome(0, s));
    }
}