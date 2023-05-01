package algorithm.Baekjun.B16935;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, r;
    static int[][] map;
    static void draw(int[][] map) throws IOException {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void operation1() {
        int height = map.length;
        int width = map[0].length;
        for(int i = 0; i < height / 2; i++) {
            for(int j = 0; j < width; j++) {
                int tmp = map[i][j];
                map[i][j] = map[height - i - 1][j];
                map[height - i - 1][j] = tmp;

            }
        }
    }
    static void operation2() {
        int height = map.length;
        int width = map[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width / 2; j++) {
                int tmp = map[i][j];
                map[i][j] = map[i][width - j - 1];
                map[i][width - j - 1] = tmp;
            }
        }
    }
    static void operation3() {
        int height = map.length;
        int width = map[0].length;
        int[][] newMap = new int[width][height];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                newMap[j][height - i - 1] = map[i][j];
            }
        }
        map = newMap;
    }
    static void operation4() {
        int height = map.length;
        int width = map[0].length;
        int[][] newMap = new int[width][height];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                newMap[width - j - 1][i] = map[i][j];
            }
        }
        map = newMap;
    }
    static void operation5() {
        int[][] mapUpLeft = new int[map.length / 2][map[0].length / 2];
        int[][] mapUpRight = new int[map.length / 2][map[0].length / 2];
        int[][] mapDownRight = new int[map.length / 2][map[0].length / 2];
        int[][] mapDownLeft = new int[map.length / 2][map[0].length / 2];
        int[][] newMap = new int[map.length][map[0].length];

        for(int i = 0; i < map.length / 2; i++) {
            for(int j = 0; j < map[0].length / 2; j++) {
                mapUpLeft[i][j] = map[i][j];
                mapUpRight[i][j] = map[i][j + (map[0].length / 2)];
                mapDownLeft[i][j] = map[i + (map.length / 2)][j];
                mapDownRight[i][j] = map[i + (map.length / 2)][j + (map[0].length / 2)];
            }
        }

        for(int i = 0; i < map.length / 2; i++) {
            for(int j = 0; j < map[0].length / 2; j++) {
                newMap[i][j] = mapDownLeft[i][j];
                newMap[i][j + (map[0].length / 2)] = mapUpLeft[i][j];
                newMap[i + (map.length / 2)][j + (map[0].length / 2)] = mapUpRight[i][j];
                newMap[i + (map.length / 2)][j] = mapDownRight[i][j];
            }
        }
        map = newMap;
    }
    static void operation6() {
        int[][] mapUpLeft = new int[map.length / 2][map[0].length / 2];
        int[][] mapUpRight = new int[map.length / 2][map[0].length / 2];
        int[][] mapDownRight = new int[map.length / 2][map[0].length / 2];
        int[][] mapDownLeft = new int[map.length / 2][map[0].length / 2];
        int[][] newMap = new int[map.length][map[0].length];

        for(int i = 0; i < map.length / 2; i++) {
            for(int j = 0; j < map[0].length / 2; j++) {
                mapUpLeft[i][j] = map[i][j];
                mapUpRight[i][j] = map[i][j + (map[0].length / 2)];
                mapDownLeft[i][j] = map[i + (map.length / 2)][j];
                mapDownRight[i][j] = map[i + (map.length / 2)][j + (map[0].length / 2)];
            }
        }

        for(int i = 0; i < map.length / 2; i++) {
            for(int j = 0; j < map[0].length / 2; j++) {
                newMap[i][j] = mapUpRight[i][j];
                newMap[i][j + (map[0].length / 2)] = mapDownRight[i][j];
                newMap[i + (map.length / 2)][j + (map[0].length / 2)] = mapDownLeft[i][j];
                newMap[i + (map.length / 2)][j] = mapUpLeft[i][j];
            }
        }
        map = newMap;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int operand = Integer.parseInt(st.nextToken());
            if(operand == 1) operation1();
            if(operand == 2) operation2();
            if(operand == 3) operation3();
            if(operand == 4) operation4();
            if(operand == 5) operation5();
            if(operand == 6) operation6();
        }
        draw(map);

        br.close();
        bw.close();
    }
}
