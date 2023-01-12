package algorithm.BinarySearch.B1654;

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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;
        long min = 0;
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = arr[i] > max ? arr[i] : max;
        }
        max += 1;

        while(min < max) {
            long mid = (max + min) / 2;
            long count = 0;

            for(int i = 0; i < k; i++) {
                count += (arr[i] / mid);
            }

            if(count < n) max = mid;
            else min = mid + 1;
        }

        bw.write((min - 1)+ "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
