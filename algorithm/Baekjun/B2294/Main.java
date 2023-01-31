package algorithm.Baekjun.B2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        for(int i = 1; i < k + 1; i++) {
            for(int j = 0; j < n; j++) {
                if(i < coin[j]) continue;
                if(i % coin[j] == 0) dp[i] = Math.min(dp[i], i / coin[j]);
                else {
                    if(dp[i - coin[j]] != 0) dp[i] = Math.min(dp[i - coin[j]] + 1, dp[i]);
                }
            }
        }

        if(dp[k] == Integer.MAX_VALUE - 1) bw.write(-1 + "\n");
        else bw.write(dp[k] + "\n");
        bw.flush();


        br.close();
        bw.close();
    }
}
