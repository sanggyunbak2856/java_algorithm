package algorithm.dp.D11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10]; // 0번째 행 넘어가기
        
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
            dp[1][i] = 10 - i;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < 10; j++) {
                int sum = 0;
                for(int k = j; k < 10; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum % 10007;
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += dp[n - 1][i];
        }

        sum %= 10007;


        System.out.println(sum);
        br.close();
    }
}
