package algorithm.Baekjun.B15683;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] map;
    static List<Integer[]> cctvs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num >= 1 && num <= 5) cctvs.add(new Integer[] {i, j});
                map[i][j] = num;
            }
        }


        br.close();
        bw.close();
    }
}
