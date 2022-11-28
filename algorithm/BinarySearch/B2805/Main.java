package algorithm.BinarySearch.B2805;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    static void findHeight(int[] arr, int m, int max, int min) {
        while(true) {
            int mid = (min + max) / 2;
            long sum = 0;

            for(int i = 0; i < arr.length; i++) {
                int diff = arr[i] - mid;
                if(diff > 0) sum += diff;
            }

            if(sum == m) {
                answer = mid;
                return;
            }
            else if(sum < m) max = mid;
            else min = mid + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = arr[i] > max ? arr[i] : max;
            min = min > arr[i] ? min : arr[i];
        }

        findHeight(arr, m, max, min);
        System.out.println(answer);
        br.close();
    }
}
