package algorithm.Baekjun.B17144;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static int r, c, t;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int airPosUpY, airPosUpX;
    static int airPosDownY, airPosDownX;
    static void draw(int[][] newMap) throws IOException {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                bw.write(newMap[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void diffusion() {
        int[][] newMap = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 0) continue;
                if(map[i][j] == -1) {
                    newMap[i][j] = -1;
                    continue;
                }

                int currentDust = map[i][j];
                // diffusion
                for(int k = 0; k < 4; k++) {
                    int nearY = i + dy[k];
                    int nearX = j + dx[k];

                    if(nearY < 0 || nearX < 0 || nearY >= r || nearX >= c) continue;
                    if(map[nearY][nearX] == -1) continue;
                    newMap[nearY][nearX] += (map[i][j] / 5);
                    currentDust -= (map[i][j] / 5);
                }
                newMap[i][j] += currentDust;
            }
        }
        map = newMap;
    }
    static void cycle() {
        // up
        int currentY = airPosUpY;
        int currentX = airPosUpX + 1;
        int currentD = 0;
        int currentDust = map[currentY][currentX];
        map[currentY][currentX] = 0;
        while(true) {
            int nextY = currentY + dy[currentD];
            int nextX = currentX + dx[currentD];

            if(nextY < 0 || nextX < 0 || nextY >= r || nextX >= c){
                currentD = (currentD + 1) % 4;
                continue;
            }
            if(map[nextY][nextX] == -1) break;
            
            int tmp = map[nextY][nextX];
            map[nextY][nextX] = currentDust;
            currentDust = tmp;
            currentY = nextY;
            currentX = nextX;
        }

        // down
        currentY = airPosDownY;
        currentX = airPosDownX + 1;
        currentD = 0;
        currentDust = map[currentY][currentX];
        map[currentY][currentX] = 0;
        while(true) {
            int nextY = currentY + dy[currentD];
            int nextX = currentX + dx[currentD];

            if(nextY < 0 || nextX < 0 || nextY >= r || nextX >= c){
                currentD -= 1;
                if(currentD == -1) currentD = 3;
                continue;
            }
            if(map[nextY][nextX] == -1) break;
            
            int tmp = map[nextY][nextX];
            map[nextY][nextX] = currentDust;
            currentDust = tmp;
            currentY = nextY;
            currentX = nextX;
        }
    }
    static int count() {
        int sum = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
    static void simulation() {
        for(int i = 0; i < t; i++) {
            diffusion();
            cycle();
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        boolean upFound = false;
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    if(!upFound) {
                        airPosUpY = i;
                        airPosUpX = j;
                        upFound = true;
                    }
                    else {
                        airPosDownY = i;
                        airPosDownX = j;
                    }
                }
            }
        }
        simulation();
        int answer = count();
        bw.write((answer + 2) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
