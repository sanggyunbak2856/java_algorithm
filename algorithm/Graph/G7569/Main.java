package algorithm.Graph.G7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int[][][] map; // 3차원 arraylist, (z, y, x)
    static int[][] move = {{1, 0, 0}, {-1, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, 1, 0}, {0, -1, 0}};
    static int n, m, h;
    static ArrayList<Integer[]> initial_tomato = new ArrayList<>();

    static int bfs() {
        int current_day = 0;
        Queue<Integer[]> q = new LinkedList<>();
        for(Integer[] t : initial_tomato) {
            q.add(new Integer[] {t[0], t[1], t[2], current_day});
        }

        while(!q.isEmpty()) {
            Integer[] v = q.poll();

            current_day = v[3] + 1;
            for(int i = 0; i < 6; i++) {
                int newX = v[2] + move[i][2];
                int newY = v[1] + move[i][1];
                int newZ = v[0] + move[i][0];

                if((newX < 0) || (newY < 0) || (newZ < 0)) continue;
                if((newX >= m) || (newY >= n) || (newZ >= h)) continue;
                
                if(map[newZ][newY][newX] != 0)  continue;
                else {
                    q.add(new Integer[] {newZ, newY, newX, current_day});
                    map[newZ][newY][newX] = 1;
                }
            }
        }
        return current_day;
    }

    static boolean checkTomato() {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    // static void printMap() {
    //     System.out.println();
    //     for(int i = 0; i < h; i++) {
    //         for(int j = 0; j < n; j++) {
    //             for(int k = 0; k < m; k++) {
    //                 System.out.print(map[i][j][k] + " ");
    //             }
    //             System.out.println("");
    //         }
    //     }
    // }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];

        boolean allTomato = true;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                for(int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(str[k]);
                    if(map[i][j][k] == 1) {
                        initial_tomato.add(new Integer[] {i, j, k});
                    }
                    else if(map[i][j][k] == 0) allTomato = false;
                }                
            }
        }


        if(allTomato) {
            System.out.println(0);
        }
        else {
            int count = bfs();
            // printMap();
            if(checkTomato()) System.out.println(count - 1);
            else System.out.println(-1);
        }
        
        br.close();
    }
}
