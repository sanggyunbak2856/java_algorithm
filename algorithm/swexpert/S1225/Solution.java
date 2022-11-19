package algorithm.swexpert.S1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    static Queue<Integer> q;
    static void makePassword() {
        while(true) {
            for(int i = 1; i <= 8; i++) {
                int p = q.poll();
                if(p - i < 0) {
                    q.add(0);
                    return;
                }
                else {
                    q.add(p - i);
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            int t = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            makePassword();
            StringBuilder sb = new StringBuilder("#");
            sb.append(t).append(" ");
            for(int i = 0; i < 8; i++) {
                sb.append(q.poll()).append(" ");
            }
            System.out.println(sb.toString());

        }

        br.close();
    }
}
