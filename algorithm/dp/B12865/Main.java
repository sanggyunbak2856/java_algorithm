package algorithm.dp.B12865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] val = new int[n+1];
        int[] weight = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        val[0] = 0; weight[0] = 0; dp[0][0] = 0;

        for(int i = 1; i < n + 1; i++) {
            String[] numStrings = sc.nextLine().split(" ");
            weight[i] = Integer.parseInt(numStrings[0]);
            val[i] = Integer.parseInt(numStrings[1]);
            dp[i][0] = 0; dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(weight[i] > j) dp[i][j] = dp[i][j-1];
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i][j-weight[i]] + val[i]);
                }
            }
        }

        System.out.println(dp[n][n]);
    }
}
