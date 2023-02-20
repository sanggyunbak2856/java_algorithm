package algorithm.Baekjun.B1806;

import java.io.*;
import java.util.*;

public class NonPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[end];
        int min = 100001;

        while(start < n && end < n) {
            if(sum < s) {
                if(end + 1 >= n) break;
                sum += arr[++end];
            }
            else {
                min = (end - start) < min ? (end - start) : min;
                sum -= arr[start++];
                continue;
            }
        }

        if(min == 100001) bw.write("0\n");
        else bw.write(min + 1 +  "\n");
        br.close();
        bw.close();
    }
}
