package algorithm.Baekjun.B2343;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static long parametricSearch(long total) {
        long left = arr[arr.length - 1];
        long right = total;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0, sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(sum + arr[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += arr[i];
            }
            if(sum != 0) count++;

            if(count > m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        long total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        Arrays.sort(arr);

        long answer = parametricSearch(total);
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
