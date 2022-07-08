package algorithm.dp.B11048;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i < n + 1; i++) {
            String[] nums = sc.nextLine().split(" ");
            for(int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(nums[j-1]);
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i][j-1] + map[i][j], dp[i-1][j] + map[i][j]);
            }
        }

        System.out.println(dp[n][m]);

    }
}
