package algorithm.swexpert.S1954;

import java.util.Scanner;

public class Solution {
    static int n;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void dfs(int y, int x, int num, int dir) {
        map[y][x] = num;
        if(num == n * n) return;
        int newY = y + dy[dir];
        int newX = x + dx[dir];

        while(true) {
            if(newY < 0 || newX < 0 || newY >= n || newX >= n || map[newY][newX] != 0) {
                dir = (dir + 1) % 4;
                newY = y + dy[dir];
                newX = x + dx[dir];
                continue;
            }
            else break;
        }

        dfs(newY, newX, num + 1, dir);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= t; t++) {
            n = Integer.parseInt(sc.nextLine());
            map = new int[n][n];
            dfs(0, 0, 1, 0);

            StringBuilder sb = new StringBuilder("#");
            sb.append(t).append(" ").append("\n");
            System.out.println(sb);

            for(int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                System.out.println(sb);
            }
        }


    }
}
