import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < n - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans + map.get(s.charAt(n - 1));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();

        System.out.print("Enter a Roman numeral: ");
        String roman = sc.nextLine().toUpperCase(); // ensures valid uppercase input

        int result = ob.romanToInt(roman);
        System.out.println("Integer value: " + result);

        sc.close();
    }
}
