package algorithm.swexpert.S13547;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int lose = 0;
            for(char ch : br.readLine().toCharArray()) {
                if(ch == 'x') lose++;
            }
            if(lose >= 8) bw.write("#" + (i + 1) + " NO\n");
            else bw.write("#" + (i + 1) + " YES\n");
        }
        bw.flush();
    }
}
