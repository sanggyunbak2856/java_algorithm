package algorithm.swexpert.S1873;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static int h, w;
    static char[][] map;
    static char[] commands;
    static int[] dx = {0, 0, -1, 1}; // 위 아래 왼 오른
    static int[] dy = {-1, 1, 0, 0};
    static int tankY, tankX;
    static void shoot(int d) throws IOException {
        int curY = tankY;
        int curX = tankX;
        while(true) {
            int newY = curY + dy[d];
            int newX = curX + dx[d];

            if(newY < 0 || newX < 0 || newY >= h || newX >= w) break;
            if(map[newY][newX] == '*') {
                map[newY][newX] = '.';
                break;
            }
            if(map[newY][newX] == '#') break;

            curY = newY;
            curX = newX;
        }
    }
    static void move(int d) {
        if(d == 0) map[tankY][tankX] = '^';
        if(d == 1) map[tankY][tankX] = 'v';
        if(d == 2) map[tankY][tankX] = '<';
        if(d == 3) map[tankY][tankX] = '>';

        int newY = tankY + dy[d];
        int newX = tankX + dx[d];
        if(newY < 0 || newX < 0 || newY >= h || newX >= w) return;
        if(map[newY][newX] == '.') {
            char tank = map[tankY][tankX];
            map[newY][newX] = tank;
            map[tankY][tankX] = '.';
            tankY = newY;
            tankX = newX;
        }
    }
    static void draw() throws IOException {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for(int j = 0; j < h; j++) {
                char[] chars = br.readLine().toCharArray();
                for(int k = 0; k < chars.length; k++) {
                    map[j][k] = chars[k];
                    if(chars[k] == '<' || chars[k] == '^' || chars[k] == 'v' || chars[k] == '>') {
                        tankY = j; tankX = k;
                    }
                } 
            }
            int n = Integer.parseInt(br.readLine());
            commands = br.readLine().toCharArray();
            for(char cmd : commands) {
                if(cmd == 'S') {
                    char tank = map[tankY][tankX];
                    if(tank == '^') shoot(0);
                    if(tank == 'v') shoot(1);
                    if(tank == '<') shoot(2);
                    if(tank == '>') shoot(3);
                }
                else {
                    if(cmd == 'U') move(0);
                    if(cmd == 'D') move(1);
                    if(cmd == 'L') move(2);
                    if(cmd == 'R') move(3);
                }
            }
            bw.write("#" + (i + 1) + " ");
            draw();
        }

        br.close();
        bw.close();
    }
}
