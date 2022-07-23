package algorithm.dp.D11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp_inc = new int[n + 1];
        int[] dp_dec = new int[n + 1];
        Arrays.fill(dp_inc, 1);
        Arrays.fill(dp_dec, 1);
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < str.length; i++) {
            arr[i + 1] = Integer.parseInt(str[i]);
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[i] > arr[j]) {
                    dp_inc[i] = Math.max(dp_inc[i], dp_inc[j] + 1);
                }
            }
        }

        int max = 1;
        for(int i = n; i > 0; i--) {
            for(int j = i; j < n + 1; j++) {
                if(arr[i] > arr[j]) {
                    dp_dec[i] = Math.max(dp_dec[i], dp_dec[j] + 1);
                }
            }
            max = dp_inc[i] + dp_dec[i] - 1 > max ?
                  dp_inc[i] + dp_dec[i] - 1: max;
        }

        System.out.println(max);
        br.close();
    }
}
