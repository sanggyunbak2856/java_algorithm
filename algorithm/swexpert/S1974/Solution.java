package algorithm.swexpert.S1974;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;


public class Solution {
    static int validate(int[][] map) {
        Set<Integer> horizontalSet;
        Set<Integer> verticleSet;

        for(int i = 0; i < 9; i++) {
            verticleSet = new HashSet<>();
            horizontalSet = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(verticleSet.contains(map[i][j])) return 0;
                if(horizontalSet.contains(map[j][i])) return 0;
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j += 3) {
                if(checkDiag(i, j, map)) continue;
                else return 0;
            }
        }

        return 1;
    }

    static boolean checkDiag(int y, int x, int[][] map) {
        Set<Integer> diagSet = new HashSet<>();

        for(int i = y; i < y + 3; i++) {
            for(int j = x; j < x + 3; j++) {
                if(diagSet.contains(map[i][j])) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int test = Integer.parseInt(br.readLine());
            int[][] map = new int[9][9];
            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int v = validate(map);
            System.out.printf("#%d %d", test, v);
        }



        br.close();
    }
}
