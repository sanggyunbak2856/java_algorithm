package algorithm.Baekjun.B11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];

        for(int i = 1; i < n + 1; i++) {
            int max = 0;
            for(int j = 1; j <= i; j++) {
                max = max > dp[i - j] + arr[j] ? max : dp[i - j] + arr[j];
            }
            dp[i] = max;
        }
        bw.write(dp[n] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
