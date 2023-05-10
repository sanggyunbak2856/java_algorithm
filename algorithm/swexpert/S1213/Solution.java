package algorithm.swexpert.S1213;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 1; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String str = br.readLine();
            int diff = str.length() - str.replace(s, "").length();

            bw.write("#" + n + " " + diff / s.length() + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
