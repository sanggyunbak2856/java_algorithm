package algorithm.Baekjun.B6593;

import java.io.*;
import java.util.*;

public class Main {
    // Integer.MAX_VALUE -> 길 없음
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int bfs(int[] positionS, int[] positionE, char[][][] map, boolean[][][] visited) {
        int answer = Integer.MAX_VALUE;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {positionS[0], positionS[1], positionS[2], 0});
        visited[positionS[0]][positionS[1]][positionS[2]] = true;

        int limitZ = map.length;
        int limitY = map[0].length;
        int limitX = map[0][0].length;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            
            for(int i = 0; i < 6; i++) {
                int newZ = p[0] + dz[i];
                int newY = p[1] + dy[i];
                int newX = p[2] + dx[i];
                int newCount = p[3] + 1;

                if(newZ < 0 || newY < 0 || newX < 0 || 
                    newZ >= limitZ || newY >= limitY || newX >= limitX) continue;
                if(visited[newZ][newY][newX]) continue;
                if(map[newZ][newY][newX] == '#') continue;
                q.add(new Integer[] {newZ, newY, newX, newCount});
                visited[newZ][newY][newX] = true;
                if(newZ == positionE[0] && newY == positionE[1] && newX == positionE[2]) {
                    answer = newCount < answer ? newCount : answer;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;
            char[][][] map = new char[l][r][c];
            boolean[][][] visisted = new boolean[l][r][c];
            int[] positionS = new int[3]; // 0 : l, 1 : r, 2 : c
            int[] positionE = new int[3];

            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    char[] chars = br.readLine().toCharArray();
                    for(int k = 0; k < c; k++) {
                        map[i][j][k] = chars[k];
                        if(chars[k] == 'S') {
                            positionS = new int[] {i, j, k};
                        }
                        if(chars[k] == 'E') {
                            positionE = new int[] {i, j, k};
                        }
                    }
                }
                br.readLine();
            }

            int count = bfs(positionS, positionE, map, visisted);
            if(count == Integer.MAX_VALUE) bw.write("Trapped!\n");
            else bw.write("Escaped in " + count + " minute(s).\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
