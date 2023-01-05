package algorithm.dp.D1010;

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
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[31][31];
            for(int j = 0; j < 31; j++) {
                dp[1][j] = j;
            }

            for(int j = 0; j < 31; j++) {
                if(j == 0 || j == 1) continue;
                for(int k = 0; k < 31; k++) {
                    if(k < j) continue;
                    else if(k == j) dp[j][k] = 1;
                    else dp[j][k] = dp[j - 1][k - 1] + dp[j][k - 1];
                }
            }

            bw.write(dp[n][m] + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
