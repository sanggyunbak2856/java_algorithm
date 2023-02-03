package algorithm.Baekjun.B12852;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        String[] arr = new String[1000001];
        
        dp[1] = 0;
        arr[1] = new String("1");
        dp[2] = 1;
        arr[2] = new String("2 1");
        dp[3] = 1;
        arr[3] = new String("3 1");

        for(int i = 4; i < 1000001; i++) {
            if(i % 2 == 0) {
                if(dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    arr[i] = (new StringBuilder(arr[i / 2])).insert(0, i + " ").toString();
                }
            }
            if(i % 3 == 0) {
                if(dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    arr[i] = (new StringBuilder(arr[i / 3])).insert(0, i + " ").toString();
                }
            }
            if(dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                arr[i] = (new StringBuilder(arr[i - 1])).insert(0, i + " ").toString();
            }
        }

        bw.write(dp[n] + "\n");
        bw.write(arr[n] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
