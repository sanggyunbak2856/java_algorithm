package algorithm.swexpert.S15758;

import java.util.*;
import java.io.*;

public class Solution {
    static String smallestRepeatString(String str) {
        String answer = new String();
        for(int i = 1; i <= str.length(); i++) {
            String subString = str.substring(0, i);
            answer = subString;
            String temp = new String(str);
            temp = temp.replace(subString, "");
            if(temp.length() == 0) break;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String u = st.nextToken();

            String repeatStr = smallestRepeatString(s);
            String temp = u.replace(repeatStr, "");
            if(temp.equals("")) bw.write("#" + (t + 1) + " yes\n");
            else bw.write("#" + (t + 1) + " no\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
