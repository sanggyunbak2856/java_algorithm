package algorithm.swexpert.S1225;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test = 0; test < 10; test++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
                int a = Integer.parseInt(st.nextToken());
                q.add(a);
            }

            int minus = 1;
            while(true) {
                int p = q.poll();
                p -= minus; 
                if(p <= 0) {
                    p = 0;
                    q.add(p);
                    break;
                }
                q.add(p);
                minus += 1;
                if(minus == 6) minus = 1;
            }

            bw.write("#" + n + " ");
            for(int i = 0; i < 8; i++) {
                bw.write(q.poll() + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
