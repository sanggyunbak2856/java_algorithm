package algorithm.swexpert.S12712;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static int countCross(int[][] map, int y, int x, int m) throws IOException {
        int sum = 0;
        // horizontal
        for(int i = x - (m - 1); i <= x + (m - 1); i++) {
            if(i < 0 || i >= map.length) continue;
            bw.write("y : " + y + " , x : " + i + "\n");
            sum += map[i][x];
        }
        // verticle
        for(int i = y - (m - 1); i <= y + (m - 1); i++) {
            if(i < 0 || i >= map.length) continue;
            bw.write("y : " + i + " , x : " + x + "\n");
            sum += map[y][i];
        }
        sum -= map[y][x];
        return sum;
    }
    static int countDiag(int[][] map, int y, int x, int m) {
        int sum = map[y][x];
        // 가운데 -> 왼쪽 위
        int curY = y - 1;
        int curX = x - 1;
        for(int i = 0; i < m - 1; i++) {
            if(curY < 0 || curX < 0 || curY >= map.length || curX >= map.length) break;
            sum += map[curY][curX];
            curY -= 1;
            curX -= 1;
        }
        curY = y - 1;
        curX = x + 1;
        for(int i = 0; i < m - 1; i++) {
            if(curY < 0 || curX < 0 || curY >= map.length || curX >= map.length) break;
            sum += map[curY][curX];
            curY -= 1;
            curX -= 1;
        }
        curY = y + 1;
        curX = x - 1;
        for(int i = 0; i < m - 1; i++) {
            if(curY < 0 || curX < 0 || curY >= map.length || curX >= map.length) break;
            sum += map[curY][curX];
            curY -= 1;
            curX -= 1;
        }
        curY = y + 1;
        curX = x + 1;
        for(int i = 0; i < m - 1; i++) {
            if(curY < 0 || curX < 0 || curY >= map.length || curX >= map.length) break;
            sum += map[curY][curX];
            curY -= 1;
            curX -= 1;
        }
        return sum;
    }
    static int killFly(int[][] map, int m) throws IOException {
        int max = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                bw.write("--------------------------\n");
                bw.write("y " + i + " x " + j + "\n");
                bw.write("--------------------------\n");
                int cross = countCross(map, i, j, m);
                int diag = countDiag(map, i, j, m);
                int bigger = cross > diag ? cross : diag;
                max = bigger > max ? bigger : max;
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = killFly(map, m);
            bw.write("#" + (i + 1) + " " + max + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
