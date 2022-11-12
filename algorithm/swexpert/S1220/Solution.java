package algorithm.swexpert.S1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i = 0; i < n; i++) {
                int last = 0;
                boolean isRedFound = false;
                for(int j = 0; j < n; j++) {
                    if(!isRedFound) {
                        if(map[j][i] == 1) {
                            isRedFound = true;
                            last = 1;
                        }
                    }
                    else {
                        if(map[j][i] == 0 || map[j][i] == last) continue;
                        else {
                            if(last == 1) count++;
                            last = map[j][i];
                        }
                    }
                }

            }

            System.out.printf("#%d %d\n", test_case, count);
        }

        br.close();
    }
}
