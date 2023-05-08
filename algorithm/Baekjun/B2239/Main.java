package algorithm.Baekjun.B2239;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static List<Integer[]> list;
    static boolean sutokuFinished = false;
    static void checkVerticle(boolean[] digits, int y, int x) {
        for(int i = 0; i < 9; i++) {
            digits[map[y][i]] = false;
        }
    }
    static void checkHorizontal(boolean[] digits, int y, int x) {
        for(int i = 0; i < 9; i++) {
            digits[map[i][x]] = false;
        }
    }
    static void checkSquare(boolean[] digits, int y, int x) {
        int divideY = y / 3;
        int divideX = x / 3;

        for(int i = divideY * 3; i < (divideY + 1) * 3; i++) {
            for(int j = divideX * 3; j < (divideX + 1) * 3; j++) {
                digits[map[i][j]] = false;
            }
        }
    }
    static void print() throws IOException {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void backtracking(int depth) throws IOException {
        if(sutokuFinished) return;
        if(depth == list.size()) {
            sutokuFinished = true;
            print();
            return;
        }

        boolean[] digits = new boolean[10];
        Arrays.fill(digits, true);
        int y = list.get(depth)[0];
        int x = list.get(depth)[1];
        checkHorizontal(digits, y, x);
        checkVerticle(digits, y, x);
        checkSquare(digits, y, x);

        for(int i = 1; i < 10; i++) {
            if(digits[i]) {
                map[y][x] = i;
                backtracking(depth + 1);
                map[y][x] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[9][9];
        list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            String[] strs = br.readLine().split("");
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
                if(map[i][j] == 0) list.add(new Integer[] {i, j});
            }
        }

        backtracking(0);

        bw.flush();
        br.close();
        bw.close();
    }
}
