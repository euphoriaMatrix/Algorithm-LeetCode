import java.util.PriorityQueue;

/**
 * @author xwfstart
 * @create 2022-07-17 11:15
 */
public class Solution {
    public String fractionAddition(String expression) {
        int a = 0, b = 0, n = expression.length();
        int i = 0;
        while (i < n) {
            int j = i;
            int pos = 1;
            if (expression.charAt(j) == '-') {
                pos = -1;
                j++;
            } else if (expression.charAt(j) == '+') {
                j++;
            }

            int temp1 = 0;
            while (j < n && expression.charAt(j) != '/') {
                temp1 *= 10;
                temp1 += (expression.charAt(j) - '0');
                j++;
            }
            j++;
            int temp2 = 0;
            while (j < n && (expression.charAt(j) != '+' && expression.charAt(j) != '-')) {
                temp2 *= 10;
                temp2 += (expression.charAt(j) - '0');
                j++;
            }
            if (b == 0) {
                a = pos * temp1;
                b = temp2;
            } else {
                a = a * temp2 + pos * temp1 * b;
                b *= temp2;
            }
            int gcd = gcd(Math.abs(a), Math.abs(b));
            a /= gcd;
            b /= gcd;
            i = j;
        }
        return a + "/" + b;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        if (b > a) return gcd(b, a);
        int temp = a % b;
        return gcd(b, temp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition("-1/3+1/2"));
    }
}
