package algorithm.Graph.G2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

public class Main {
    // 0: 왼쪽 1: 위쪽 2: 오른쪽 3: 아래
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strArr = str.split("");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        Queue<Point> queue = new LinkedList<>(); // bfs
        boolean[][] visited = new boolean[n][m];
        queue.add(new Point(0, 0));
        int count = 0;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x; int y = p.y;
            visited[x][y] = true;
            count++;
            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    if(graph[newX][newY] == 1 && visited[newX][newY] == false) {
                        queue.add(new Point(newX, newY));
                        graph[newX][newY] = graph[x][y] + 1;
                    }
                }
            }
        }

        bw.write(graph[n-1][m-1] + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
