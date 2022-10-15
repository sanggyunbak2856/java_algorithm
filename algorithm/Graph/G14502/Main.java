package algorithm.Graph.G14502;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static void bfs(List<Integer[]> list) {
        Queue<List<Integer[]>> q = new LinkedList<>();
        q.add(list);

        while(!q.isEmpty()) {
            List<Integer[]> p = q.poll();
            List<Integer[]> nextList = new LinkedList<>();

            for(Integer[] point : p) {
                for(int i = 0; i < 4; i++) {
                    int newY = point[0] + dy[i];
                    int newX = point[1] + dx[i];

                    if(newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length)
                        continue;
                    if(map[newY][newX] == 2 || map[newY][newX] == 1 || map[newY][newX] == 3)
                        continue;
                    
                    nextList.add(new Integer[] {newY, newX});
                    map[newY][newX] = 3;
                }
            }
            System.out.println(nextList.size());
            printMap();
            if(nextList.isEmpty()) break;
            if(nextList.size() == 3) {
                countZero();
                break;
            }
            q.add(nextList);
        }
    }
    static void countZero() {
        for(int[] row : map) {
            for(int point : row) {
                if(point == 0) count++;
            }
        }
    }
    static void printMap() {
        System.out.println("------------------------");
        for(int[] row : map) {
            for(int point : row) {
                System.out.print(point + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer size = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(size.nextToken());
        int n = Integer.parseInt(size.nextToken());

        map = new int[m][n];
        List<Integer []> newList = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    newList.add(new Integer[] {i, j});
                } 
            }
        }

        System.out.println();

        bfs(newList);

        System.out.println(count);
        br.close();
    }
}
