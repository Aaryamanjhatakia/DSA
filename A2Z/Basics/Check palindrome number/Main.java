import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        int alias = x;
        int rev = 0;
        while (x > 0) {
            int rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        if (alias == rev)
            return true;
        else
            return false;

    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        System.out.println("enter a number");
        int n = sc.nextInt();
        System.out.println(ob.isPalindrome(n));
    }
}