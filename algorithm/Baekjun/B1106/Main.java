package algorithm.Baekjun.B1106;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[c + 101];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            for(int j = people; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - people] + cost);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = c; i < c + 101; i++) {
            answer = answer < dp[i] ? answer : dp[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
