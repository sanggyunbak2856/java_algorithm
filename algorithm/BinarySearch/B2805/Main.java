package algorithm.BinarySearch.B2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    static void findHeight(int[] arr, int m, long low, long high) {
        while(low < high) {
            long sum = 0;
            long mid = (low + high) / 2;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > mid) sum += (arr[i] - mid);
            }

            if(sum < m) high = mid;
            else if(sum > m) low = mid + 1;
            else {
                answer = mid;
                break;
            }
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
        int min = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = arr[i] > max ? arr[i] : max;
        }

        findHeight(arr, m, min, max);
        System.out.println(answer);
        br.close();
    }
}
