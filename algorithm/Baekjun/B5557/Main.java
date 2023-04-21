package algorithm.Baekjun.B5557;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 20; j++) {
                if(dp[i - 1][j] != 0) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];
                    if(plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if(minus >= 0) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }

        bw.write(dp[n - 2][arr[n - 1]] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
