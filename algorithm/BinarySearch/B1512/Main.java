package algorithm.BinarySearch.B1512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        int min = 0;
        int max = Integer.MIN_VALUE;
        int std = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            max = arr[i] > max ? arr[i] : max;
            total += arr[i];
        }

        if(total <= std) {
            System.out.println(max);
            return;
        }

        int pivot = (min + max) / 2;

        while(true) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(pivot > arr[i]) sum += arr[i];
                else sum += pivot;
            }
            if(sum < std && Math.abs(std - sum) < n) break;
            if(sum > std) {
                max = pivot;
                pivot = (min + max) / 2;
            }
            else {
                min = pivot;
                pivot = (min + max) / 2;
            }
        }

        System.out.println(pivot);

        br.close();
    }
}
