public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String input = "babad";
        String result = sol.longestPalindrome(input);

        System.out.println("Longest Palindromic Substring: " + result);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i); // for odd length palindromes
            int even = expandAroundCenter(s, i, i + 1); // for even length palindromes
            int max_len = Math.max(odd, even);

            if (max_len > end - start) {
                start = i - (max_len - 1) / 2;
                end = i + max_len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
