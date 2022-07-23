package algorithm.dp.D11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        String[] str = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(str[i]);
            dp[i + 1] = arr[i + 1];
        }
        
        int max = dp[1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);
    }
}
