package algorithm.Graph.G7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[][] map;
    public static ArrayList<int[]> arr = new ArrayList<>();
    public static int count = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs() {
        Queue<int []> q_tomorrow = new LinkedList<>();
        Queue<int []> q_today = new LinkedList<>();
        for(int[] location : arr) {
            q_today.add(location);
        }

        while (true) {
            while(!q_today.isEmpty()) {
                int[] location = q_today.poll();
                for(int i = 0; i < 4; i++) {

                    int newX = location[0] + dx[i];
                    int newY = location[1] + dy[i];

                    if(newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) continue;
                    if(map[newX][newY] == 0) {
                        map[newX][newY] = 1;
                        q_tomorrow.add(new int[] {newX, newY});
                    }
                }
            }
            count++;
            if(q_tomorrow.isEmpty()) return;
            q_today = new LinkedList<>(q_tomorrow);
            q_tomorrow = new LinkedList<>();
        }
    }

    public static boolean findZero() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]); // 가로
        int n = Integer.parseInt(str1[1]); // 세로
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] str2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str2[j]);
                if(map[i][j] == 1) {
                    arr.add(new int[] {i, j});
                }
            }
        }
        bfs();
        if(!findZero()) System.out.println(count - 1);
        else System.out.println(-1);
    }
}
