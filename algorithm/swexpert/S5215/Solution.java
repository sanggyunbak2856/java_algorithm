package algorithm.swexpert.S5215;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static int max = 0;
    static void dfs(int count, int cal, int taste, int l, int[][] arr) {
        if(cal > l) return;
        if(count == arr.length) {
            max = taste > max ? taste : max;
            return;
        }
        max = taste > max ? taste : max;
        dfs(count + 1, cal + arr[count][1], taste + arr[count][0], l, arr);
        dfs(count + 1, cal, taste, l, arr);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
            dfs(0, 0, 0, l, arr);
            bw.write("#" + (i + 1) + " " + max + "\n");
            bw.flush();
            max = 0;
        }

        br.close();
        bw.close();
    }
}
