package algorithm.Baekjun.B14921;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int left = i;
            int right = n - 1;
            int sum = 100;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(mid == left) mid += 1;
                sum = arr[i] + arr[mid];

                if(sum == 0) break;
                if(sum > 0) right = mid - 1;
                if(sum < 0) left = mid + 1;
            }

            min = Math.abs(sum) < Math.abs(min) ? sum : min;
            if(min == 0) break;
        }
        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
