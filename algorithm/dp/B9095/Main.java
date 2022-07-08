package algorithm.dp.B9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            System.out.println(dp[m]);
        }
    }
}
