package algorithm.Baekjun.B1194;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int posY, posX;
    static Map<Character, Integer> mapKey = new HashMap<>();
    static Map<Character, Integer> mapDoor = new HashMap<>();
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {posY, posX, 0, 0, 0});
        visited[0][posY][posX] = true;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if(newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if(visited[p[2]][newY][newX]) continue;
                if(map[newY][newX] == '#') continue;
                else {
                    if(map[newY][newX] == '1') {
                        min = p[4] + 1 < min ? p[4] + 1 : min;
                    }
                    else if(map[newY][newX] == '.' || map[newY][newX] == '0') { // 빈칸 이동
                        q.add(new Integer[] {newY, newX, p[2], p[3], p[4] + 1});
                        visited[p[2]][newY][newX] = true;
                    }
                    else if((map[newY][newX] >= 'a') && (map[newY][newX] <= 'f')) { // 열쇠 획득
                        char key = map[newY][newX];
                        if(p[2] + 1 <= 6 && !visited[p[2] + 1][newY][newX]) {
                            if((p[3] & mapKey.get(key)) > 0) {
                                q.add(new Integer[] {newY, newX, p[2], p[3], p[4] + 1});
                            }
                            else {
                                q.add(new Integer[] {newY, newX, p[2] + 1, p[3] | mapKey.get(key), p[4] + 1});
                                visited[p[2] + 1][newY][newX] = true;
                            }
                        }
                    }
                    else if((map[newY][newX] >= 'A') && (map[newY][newX] <= 'F')) { // 문 열기
                        char door = map[newY][newX];
                        if((p[3] & mapDoor.get(door)) > 0) { // 0 보다 크다면 맞는 열쇠가 있는것임
                            q.add(new Integer[] {newY, newX, p[2], p[3], p[4] + 1});
                            visited[p[2]][newY][newX] = true;
                        }
                    }
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

        map = new char[n][m];
        visited = new boolean[7][n][m];
        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = chars[j];
                if(chars[j] == '0') {
                    posY = i;
                    posX = j;
                }
            }
        }

        // 열쇠
        mapKey.put('a', 1); mapKey.put('b', 2); mapKey.put('c', 4);
        mapKey.put('d', 8); mapKey.put('e', 16); mapKey.put('f', 32);
        // 문
        mapDoor.put('A', 1); mapDoor.put('B', 2); mapDoor.put('C', 4);
        mapDoor.put('D', 8); mapDoor.put('E', 16); mapDoor.put('F', 32);

        bfs();
        if(min == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(min + "\n");

        br.close();
        bw.close();
    }
}
