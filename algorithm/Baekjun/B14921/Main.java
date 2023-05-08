package algorithm.Baekjun.B14921;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int diff = Integer.MAX_VALUE;

        while(left < right) {
            if(right == arr.length) break;
            int sum = arr[left] + arr[right];

            diff = Math.abs(sum) < Math.abs(diff) ? sum : diff;

            if(sum == 0) break;
            else if(sum < 0) right++;
            else {
                left++;
            }
        }

        bw.write(diff + "\n");
        br.close();
        bw.close();
    }
}
