package algorithm.swexpert.p1;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int upMax = 0;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            upMax = (x - 1) > upMax ? (x - 1) : upMax;
            leftMax = (y - 1) > leftMax ? (y - 1) : leftMax;
            rightMax = (n - y) > rightMax ? (n - y) : rightMax;
        }

        int min = upMax + leftMax;
        min = upMax + rightMax < min ? upMax + rightMax : min;

        

        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
