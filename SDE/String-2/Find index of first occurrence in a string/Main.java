import javax.print.DocFlavor.STRING;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String args[]) {
        Solution ob = new Solution();
        String s1 = "sadbutsad";
        String s2 = "sad";
        int n = ob.strStr(s1, s2);
        System.out.println(n);
    }
}