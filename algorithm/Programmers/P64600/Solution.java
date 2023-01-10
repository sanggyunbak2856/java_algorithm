package algorithm.Programmers.P64600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static boolean checkUmm(String str) {
        char[] chars = str.toCharArray();
        if(chars[0] != 'U') return false;
        if(chars.length <= 2) return false;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == 'm') continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String substr = str.substring(a - 1, b);
            if(checkUmm(substr)) {
                bw.write("YES\n");
                bw.flush();
            }
            else {
                bw.write("NO\n");
                bw.flush();
            }
        }

        br.close();
        bw.close();
    }
}
