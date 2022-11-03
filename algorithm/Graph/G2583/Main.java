package algorithm.Graph.G2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int m;
    static int n;
    static int k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o1 - o2;
    });
    static void bfs(int y, int x) {
        if(map[y][x]) return;
        if(visited[y][x]) return;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{y, x});
        int count = 1;

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            visited[p[0]][p[1]] = true;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= m || newX >= n) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX]) continue;

                visited[newY][newX] = true;
                q.add(new Integer[] {newY, newX});
                count++;
            }
        }

        pq.add(count);
    }
    static void drawMap(int x1, int y1, int x2, int y2) {
        for(int i = y1; i < y2; i++) {
            for(int j = x1; j < x2; j++) {
                map[i][j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            drawMap(x1, y1, x2, y2);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }

        System.out.println(pq.size());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}
