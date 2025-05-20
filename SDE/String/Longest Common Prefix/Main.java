class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String pref = strs[0];
        int prefLen = pref.length();

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLen);
            }
        }

        return pref;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution ob = new Solution();

        // Example test case
        String[] input = { "flower", "flow", "flight" };
        String result = ob.longestCommonPrefix(input);

        System.out.println("Longest Common Prefix: " + result);
    }
}
