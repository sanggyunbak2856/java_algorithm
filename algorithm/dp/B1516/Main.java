package algorithm.dp.B1516;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int min = 0;
            String[] words = sc.nextLine().split(" ");
            for(int j = 0; j < words.length - 1; j++) {
                if(j == 0) min += Integer.parseInt(words[j]);
                else min += dp[Integer.parseInt(words[j])];
            }
            dp[i] = min;
        }

        for(int i = 1; i < n; i++) {
            System.out.println(dp[i]);
        }


    }
}
