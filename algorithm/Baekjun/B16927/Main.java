package algorithm.Baekjun.B16927;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, r;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static void draw(int[][] newMap) throws IOException{
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
    }
    static void rotate(int l) throws IOException {
        if(visited[l][l]) return;

        Deque<Integer> dq = new LinkedList<>();
        int currentY = l;
        int currentX = l;
        int currentD = 0;
        if((n % 2 == 1) && (m % 2 == 1) && (currentY == n / 2) && (currentX == m / 2)) return;
        dq.addLast(map[currentY][currentX]);
        visited[currentY][currentX] = true;

        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == l && newX == l) break;
            if(newY < l || newX < l || newY >= n - l || newX >= m - l) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            if(visited[newY][newX]) return;
            else {
                dq.addLast(map[newY][newX]);
                visited[newY][newX] = true;
                currentY = newY;
                currentX = newX;
            }
        }

        int last = dq.removeFirst();
        dq.addLast(last);

        currentY = l;
        currentX = l;
        currentD = 0;
        map[currentY][currentX] = dq.removeFirst();
        newMap[currentY][currentX] = map[currentY][currentX];
        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == l && newX == l) break;
            if(newY < l || newX < l || newY >= n - l || newX >= m - l) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            else {
                map[newY][newX] = dq.poll();
                newMap[newY][newX] = map[newY][newX];
                currentY = newY;
                currentX = newX;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        newMap = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int newN = n;
        int newM = m;
        for(int i = 0; i < Math.min(n, m)/2; i++) {
            int line = 2 * newN + 2 * newM - 4;
            newN -= 2; newM -= 2;
            int repeat = r % line;
            for(int j = 0; j < repeat; j++) {
                rotate(i);
                visited = new boolean[n][m];
            }
        }

        // for(int i = 0; i < n / 2; i++) {
        //     int line = (n - 2 * i)* 2 + (m - 2 * i)* 2 - 4;
        //     int repeat = r % line;
        //     for(int j = 0; j < repeat; j++) {
        //         rotate(i);
        //         visited = new boolean[n][m];
        //     }
        // }

        draw(newMap);

        br.close();
        bw.close();
    }
}
