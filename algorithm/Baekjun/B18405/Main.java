package algorithm.Baekjun.B18405;

import java.io.*;
import java.util.*;

public class Main {
    static void bfs(PriorityQueue<Integer[]> viruses, int[][] map, int s) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int height = map.length;
        int width = map[0].length;

        PriorityQueue<Integer[]> newViruses = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int l = 0; l < s; l++) {
            while(!viruses.isEmpty()) {
                Integer[] p = viruses.poll();
                for(int i = 0; i < 4; i++) {
                    int newY = p[0] + dy[i];
                    int newX = p[1] + dx[i];

                    if(newY < 0 || newX < 0 || newY >= height || newX >= width) continue;
                    if(map[newY][newX] != 0) continue;
                    map[newY][newX] = p[2];
                    newViruses.add(new Integer[] {newY, newX, p[2]});
                }
            }

            while(!newViruses.isEmpty()) {
                Integer[] p = newViruses.poll();
                viruses.add(p);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (o1, o2) -> o1[2] - o2[2]
        );

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int virus = Integer.parseInt(st.nextToken());
                map[i][j] = virus;
                if(virus != 0) {
                    pq.add(new Integer[] {i, j, virus});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        bfs(pq, map, s);
        bw.write(map[y - 1][x - 1] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
