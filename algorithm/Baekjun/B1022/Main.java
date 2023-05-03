package algorithm.Baekjun.B1022;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int r1, c1, r2, c2;
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int calcDigits(int n) {
        int digits = 1;
        while(true) {
            n /= 10;
            if(n == 0) break;
            digits++;
        }
        return digits;
    }
    static void drawPretty() throws IOException {
        int findBig = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                findBig = map[i][j] > findBig ? map[i][j] : findBig;
            }
        }
        int digits = calcDigits(findBig);


        for(int i = 0; i < map.length; i++) {
            StringBuilder line = new StringBuilder();
            for(int j = 0; j < map[0].length; j++) {
                String str = Integer.toString(map[i][j]);
                str = String.format("%" + digits + "s", str);
                line.append(str).append(" ");
            }
            line.trimToSize();
            bw.write(line.toString());
            bw.write("\n");
        }
        bw.flush();
    }
    static void makeTornado3() throws IOException {
        int std = size / 2;
        int newR1 = r1 + std, newC1 = c1 + std;
        int newR2 = r2 + std;
        int newC2 = c2 + std;

        int currentY = size - 1;
        int currentX = size - 1;
        int currentD = 0;
        int currentNum = size * size;

        while(true) {
            if (newR1 <= currentY && currentY <= newR2 && newC1 <= currentX && currentX <= newC2) {
                map[currentY - newR1][currentX - newC1] = currentNum;
            }
            visited[currentY][currentX] = true;

            if(currentNum == 1) break;
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];
            if(newY < 0 || newX < 0 || newY >= size || newX >= size) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            if(visited[newY][newX]) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            else {
                currentY = newY;
                currentX = newX;
                currentNum -= 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        

        int biggerR = Math.abs(r1) > r2 ? Math.abs(r1) : r2;
        int biggerC = Math.abs(c1) > c2 ? Math.abs(c1) : c2;
        size = biggerR > biggerC ? biggerR : biggerC;
        size = size * 2 + 1;
        map = new int[r2 - r1 + 1][c2 - c1 + 1];
        visited = new boolean[size][size];
        makeTornado3();
        drawPretty();

        br.close();
        bw.close();
    }
}
