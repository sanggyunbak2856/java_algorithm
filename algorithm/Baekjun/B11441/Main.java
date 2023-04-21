package algorithm.Baekjun.B11441;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] prefix = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int answer = prefix[second] - prefix[first - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
