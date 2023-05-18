package algorithm.swexpert.S7272;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static String zero = "CEFGHIJKLMNSTUVWXYZ";
    static String one = "ADOPQR";
    static String two = "B";
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();
            StringBuilder leftsb = new StringBuilder();
            StringBuilder rightsb = new StringBuilder();

            if(left.length() != right.length()) {
                bw.write("#" + (i + 1) + " DIFF\n");
                continue;
            }
            for(int j = 0; j < left.length(); j++) {
                char ch = left.charAt(j);
                if(zero.contains(String.valueOf(ch))) leftsb.append("0");
                if(one.contains(String.valueOf(ch))) leftsb.append("1");
                if(two.equals(String.valueOf(ch))) leftsb.append("2");
                char rch = right.charAt(j);
                if(zero.contains(String.valueOf(rch))) rightsb.append("0");
                if(one.contains(String.valueOf(rch))) rightsb.append("1");
                if(two.equals(String.valueOf(rch))) rightsb.append("2");
            }

            if(leftsb.toString().equals(rightsb.toString())) bw.write("#" + (i + 1) + " SAME\n");
            else bw.write("#" + (i + 1) + " DIFF\n");
        }

        br.close();
        bw.close();
    }
}
