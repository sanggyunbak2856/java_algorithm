package algorithm.Baekjun.B2302;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] vips = new int[Integer.parseInt(br.readLine())];
        for(int i = 0; i < vips.length; i++) {
            vips[i] = Integer.parseInt(br.readLine());
        }

        long[] dp = new long[n + 1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        long answer = 0;
        if(vips.length <= 0) {
            answer = dp[n];
        }
        else {
            answer = dp[vips[0] - 1];
            int current = vips[0];
            int idx = 1;
            while(true) {
                if(idx >= vips.length) break;
                int currentLength = vips[idx] - current - 1;
                answer *= dp[currentLength];
                current = vips[idx];
                idx += 1;
            }
            if(vips[vips.length - 1] < n) {
                int length = n - vips[vips.length - 1];
                answer *= dp[length];
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
