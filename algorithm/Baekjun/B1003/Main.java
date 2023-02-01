package algorithm.Baekjun.B1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 1; dp[0][1] = 0;
            if(n < 1) {
                bw.write(dp[0][0] + " " + dp[0][1] + "\n");
                bw.flush();
                continue;
            }
            dp[1][0] = 0; dp[1][1] = 1;    
            for(int j = 2; j < n + 1; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}