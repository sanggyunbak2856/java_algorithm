package algorithm.Greedy.G2217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = arr[arr.length - 1];
        for(int i = arr.length - 1; i > -1; i--) {
            int count = arr.length - i;
            max = max > arr[i] * count ? max : arr[i] * count;
        }

        System.out.println(max);

        br.close();
    }
}
