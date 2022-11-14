package algorithm.swexpert.S2819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    static int[][] map;
    static Set<String> set;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void dfs(int y, int x, int depth, StringBuilder sb) {
        if(depth == 7) {
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY >= 4 || newX >= 4) continue;
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(map[newY][newX]);
            dfs(newY, newX, depth + 1, newSb);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            map = new int[4][4];
            set = new HashSet<>();
            for(int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    dfs(i, j, 0, new StringBuilder(""));
                }
            }

            System.out.printf("#%d %d\n", test_case, set.size());
        }

        br.close();
    }
}
