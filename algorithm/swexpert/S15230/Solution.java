package algorithm.swexpert.S15230;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++) {
            char[] chars = br.readLine().toCharArray();

            char ch = 'a' - 1;
            int count = 0;
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == ch + 1) {
                    count++;
                    ch = (char) (ch + 1);
                }
                else break;
            }
            bw.write("#" + (t + 1) + " " + count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
