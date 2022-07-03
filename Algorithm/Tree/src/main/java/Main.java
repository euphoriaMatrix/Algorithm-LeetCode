import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    int n, k;
    int[] dp;
    int ans = Integer.MIN_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        dp = new int[k];
        this.n = cookies.length;
        this.k = k;
        dfs(0, cookies);
        return ans;
    }

    private void dfs(int i, int[] cookies) {
        if (i == n) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[j] == 0) return;
                count = Math.min(dp[j], count);
            }
            ans = Math.max(ans, count);
        }
        for (int j = i; j < n; j++) {
            for (int l = 0; l < k; l++) {
                dp[l] += cookies[j];
                dfs(j + 1, cookies);
                dp[l] -= cookies[j];
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] cookies = {8,15,10,20,8};
        System.out.println(main.distributeCookies(cookies, 2));
        String s = "1";
        System.out.println(s.substring(1).length());
        char c = 'a';
        System.out.println(++c);
    }
}

