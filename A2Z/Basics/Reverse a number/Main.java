import java.util.*;

public class Main {
    static int reverse(int n) {
        int revnum = 0;
        while (n > 0) {
            int lastdigit = n % 10;
            revnum = (revnum * 10) + lastdigit;
            n = n / 10;
        }

        return revnum;

    }

    public static void main(String args[]) {
        int n = 12345;
        int rev = reverse(n);
        System.out.println(rev);
    }
}