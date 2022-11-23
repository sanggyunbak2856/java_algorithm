package algorithm.swexpert.S1860;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int count = 0;
            int bread_num = 0;
            int current_person = q.poll();
            boolean isPossible = true;
            while(!q.isEmpty()) {
                count++;
                if(count % M == 0) bread_num+=K;

                if(count == current_person) {
                    if(bread_num - 1 < 0) {
                        isPossible = false;
                        break;
                    }
                    else {
                        bread_num -= 1;
                        current_person = q.poll();
                    }
                }
            }
            if(isPossible) System.out.printf("#%d Possible\n", test_case);
            if(!isPossible) System.out.printf("#%d Impossible\n", test_case);
        }
        br.close();
    }
}
