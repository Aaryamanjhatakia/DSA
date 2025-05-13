import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter a string to convert to integer: ");
        String input = sc.nextLine();

        int result = solution.myAtoi(input);
        System.out.println("Converted integer: " + result);

        sc.close();
    }
}

class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Use long to handle overflow

        if (s.length() == 0)
            return 0;

        // Check for sign
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        // Process digits
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                break;

            res = res * 10 + (ch - '0');

            if (sign * res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }
}
