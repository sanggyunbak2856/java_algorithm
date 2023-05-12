package algorithm.swexpert.S9229;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int max = 0;
            for(int k = 0; k < n - 1; k++) {
                for(int j = i + 1; j < n; j++) {
                    int sum = arr[k] + arr[j];
                    if(sum <= m) {
                        max = sum > max ? sum : max;
                    }
                }
            }

            if(max == 0) bw.write("#" + (i + 1) + " -1\n");
            else bw.write("#" + (i + 1) + " " + max + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
