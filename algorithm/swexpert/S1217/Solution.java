package algorithm.swexpert.S1217;

import java.util.*;
import java.io.*;

public class Solution {
    static int recursion(int a, int b, int depth) {
        if(depth == b) return a;
        else return a * recursion(a, b, depth + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = recursion(a, b, 1);
            bw.write("#" + n + " " + answer + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
