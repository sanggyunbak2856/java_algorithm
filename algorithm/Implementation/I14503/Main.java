package algorithm.Implementation.I14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int count = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 왼쪽
    static int[] dy = {1, 0, -1, 0};
    static boolean checkAllDirection(int y, int x) { // true -> 청소할 공간 없음, false -> 청소할 공간 있음
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(isOutOfBound(newY, newX) || map[newY][newX] == 1 || visited[newY][newX]) continue;
            else return false;
        }
        return true;
    }
    static boolean isOutOfBound(int y, int x) { // true -> 왼쪽 경계 밖, false -> 왼쪽 경계 안
        if(y < 0 || x < 0 || y >= N || x >= M) return true;
        else return false;
    }
    static void clean(int y, int x, int d) {
        int newD = d - 1 > -1 ? d - 1 : 3;
        int newY = y + dy[newD];
        int newX = x + dx[newD];

        if(!isOutOfBound(newY, newX) && map[newY][newX] == 0 && !visited[newY][newX]) { // 청소 공간 존재
            visited[newY][newX] = true; // 방문
            count+=1;
            clean(newY, newX, newD);
        }
        else { // 청소 공간 없음
            if(!checkAllDirection(y, x)) { // 2번 경우
                clean(y, x, newD);
            }
            else {
                int prevY = y - dy[d];
                int prevX = x - dx[d];

                if(isOutOfBound(prevY, prevX)) return; // 후진 불가
                if(map[prevY][prevX] == 1) return;
                else {
                    clean(prevY, prevX, newD);
                    return;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[y][x] = true;
        clean(y, x, d);
        System.out.println(count);

        br.close();
    }
}
