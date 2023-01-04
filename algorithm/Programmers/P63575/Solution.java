package algorithm.Programmers.P63575;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from - 1] -= 1;
                arr[to - 1] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(arr[j]).append(" ");
            }
            System.out.println(sb);
        }

        br.close();
    }
}
