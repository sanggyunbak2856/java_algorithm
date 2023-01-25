package algorithm.Baekjun.B2512;

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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int min = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = arr[i] > max ? arr[i] : max;
        }

        while(min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(mid > arr[i]) sum += arr[i];
                else sum += mid;
            }
            if(sum <= m) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        bw.write(max+ "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
