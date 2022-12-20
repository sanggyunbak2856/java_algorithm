package algorithm.swacademy.p5;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int row;
    static int column;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void bfs(int y, int x, char color) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        char oldColor = map[y][x];

        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            if(map[p[0]][p[1]] == oldColor) map[p[0]][p[1]] = color;
            visited[p[0]][p[1]] = true;

            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if(newY < 0 || newX < 0 || newY >= row || newX >= column) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] != oldColor) continue;

                map[newY][newX] = color;
                q.add(new Integer[] {newY, newX});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[0]);
        column = Integer.parseInt(str[1]);

        map = new char[row][];
        visited = new boolean[row][column];

        str = br.readLine().split(" ");
        int i = Integer.parseInt(str[0]); int j = Integer.parseInt(str[1]);
        char color = str[2].toCharArray()[0];
 
        for(int k = 0; k < row; k++) {
            map[k] = br.readLine().toCharArray();
        }

        bfs(i, j, color);
        StringBuilder sb = new StringBuilder();

        for(int k = 0; k < row; k++) {
            for(int l = 0; l < column; l++) {
                sb.append(map[k][l]);
            }
            if(k == row - 1) continue;
            sb.append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
