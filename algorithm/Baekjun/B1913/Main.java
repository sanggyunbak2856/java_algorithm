package algorithm.Baekjun.B1913;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int answerY, answerX;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static void draw() throws IOException {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void snail() {
        int currentY = 0;
        int currentX = 0;
        int currentD = 0;
        int currentNum = map.length * map.length;

        while(true) {
            if(currentY == map.length / 2 && currentX == map.length / 2) {
                map[currentY][currentX] = 1;
                if(currentNum == m) {
                    answerY = currentY;
                    answerX = currentX;
                }
                break;
            }

            map[currentY][currentX] = currentNum;
            visited[currentY][currentX] = true;

            if(currentNum == m) {
                answerY = currentY;
                answerX = currentX;
            }
            
            int nextY = currentY + dy[currentD];
            int nextX = currentX + dx[currentD];
            int nextNum = currentNum - 1;

            if(nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map.length) {
                currentD = (currentD + 1) % 4;
                nextY = currentY + dy[currentD];
                nextX = currentX + dx[currentD];
            }
            if(visited[nextY][nextX]) {
                currentD = (currentD + 1) % 4;
                nextY = currentY + dy[currentD];
                nextX = currentX + dx[currentD];
            }

            currentY = nextY;
            currentX = nextX;
            currentNum = nextNum;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int size = n % 2 == 0 ? n + 1 : n;
        map = new int[size][size];
        visited = new boolean[size][size];
        map[n / 2][n / 2] = 1;
        snail();
        draw();
        bw.write((answerY + 1) + " " + (answerX + 1) + "\n");
        br.close();
        bw.close();
    }
}
