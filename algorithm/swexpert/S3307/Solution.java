package algorithm.swexpert.S3307;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] dp = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                dp[j] = 1;
            }

            int max = 0;
            for(int j = 1; j < n; j++) {
                for(int k = 0; k < j; k++) {
                    if(arr[j] > arr[k]) dp[j] = dp[j] > dp[k] + 1 ? dp[j] : dp[k] + 1;
                    max = dp[j] > max ? dp[j] : max;
                }
            }
            bw.write("#" + (i + 1) + " " + max + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
