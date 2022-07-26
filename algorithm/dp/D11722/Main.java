package algorithm.dp.D11722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        String[] element = br.readLine().split(" ");
        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(element[i - 1]);
        }

        int max = 0;
        for(int i = 1; i < n + 1; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);
        br.close();
    }
}
