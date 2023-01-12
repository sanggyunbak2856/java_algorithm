package algorithm.BinarySearch.B2805;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = arr[i] > max ? arr[i] : max;
        }

        int min = 0;
        int mid = 0;
        while(min < max) {
            mid = (max + min) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] > mid) sum += (arr[i] - mid);
            }

            if(sum < m) max = mid;
            else min = mid + 1;
        }

        bw.write(min - 1 + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
