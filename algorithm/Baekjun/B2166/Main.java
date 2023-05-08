package algorithm.Baekjun.B2166;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];

        long sumA = 0, sumB = 0;
        for(int i = 0; i < n; i++) {
            sumA += x[i] * y[i + 1];
            sumB += x[i + 1] * y[i];
        }

        bw.write(String.format("%.1f", (Math.abs(sumA - sumB)) / 2.0));
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
