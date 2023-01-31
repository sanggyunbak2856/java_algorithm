package algorithm.Baekjun.B14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map; // 0 : 청소 안한 빈 칸, 1: 벽, 2 : 청소 한 빈칸
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count = 0;
    static boolean checkAllCleanOrWall(int y, int x) {
        boolean allCleanOrWall = true;
        for(int i = 0; i < 4; i++) { // 네 방향이 이동 불가능 또는 청소 되어있음
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
            if(map[newY][newX] == 0) { // 청소 안한 부분 있음
                allCleanOrWall = false;
                break;
            }
        }
        return allCleanOrWall;
    }
    static boolean checkLeft(int y, int x, int d) {
        int leftD = (d + 1) % 4;
        int leftY = y + dy[leftD];
        int leftX = x + dx[leftD];
        if(leftY < 0 || leftX < 0 || leftY >= n || leftX >= m) return false;
        if(map[leftY][leftX] == 2 || map[leftY][leftX] == 1) return false;
        return true;
    }
    static boolean canGoRear(int y, int x, int d) { // 후진 가능한지 확인
        int rear = (d + 2) % 4;
        int newY = y + dy[rear];
        int newX = x + dx[rear];
        if(newY < 0 || newX < 0 || newY >= n || newX >= m) return false;
        if(map[newY][newX] == 1) return false;
        return true;
    }
    static void clean(int robotY, int robotX, int robotD) {
        map[robotY][robotX] = 2;
        count += 1;
        while(true) {
            // 1. 네 방향 모두 벽이거나 청소되었는지 확인
            if(checkAllCleanOrWall(robotY, robotX)) {
                if(canGoRear(robotY, robotX, robotD)) { // 뒤로 후진
                    robotY -= dy[robotD];
                    robotX -= dx[robotD];
                    continue;
                }
                else { // 뒤로 후진 불가능
                    break;
                }
            }
            // 2. 왼쪽 청소 되었는지 확인
            else {
                if(checkLeft(robotY, robotX, robotD)) { // 왼쪽 청소 가능
                    robotD = (robotD + 1) % 4;
                    robotY += dy[robotD];
                    robotX += dx[robotD];
                    map[robotY][robotX] = 2; // 현재 위치 청소
                    count += 1;
                }
                else {
                    robotD = (robotD + 1) % 4; // 회전
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int robotY = Integer.parseInt(st.nextToken());
        int robotX = Integer.parseInt(st.nextToken());
        int robotD = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(robotY, robotX, robotD);
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
