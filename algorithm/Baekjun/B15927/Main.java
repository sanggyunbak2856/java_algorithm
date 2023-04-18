package algorithm.Baekjun.B15927;

import java.util.*;
import java.io.*;

public class Main {
    static boolean isPalindrome(char[] chars) {
        if(chars[0] != chars[chars.length - 1]) return false;
        for(int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length - i - 1]) return false;
        }
        return true;
    }
    static boolean isAllCharacterSame(char[] chars) {
        char ch = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] != ch) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        if(!isPalindrome(chars)) {
            bw.write(chars.length + "\n");
            bw.flush();
        }
        else {
            if(isAllCharacterSame(chars)) {
                bw.write("-1\n");
                bw.flush();
            }
            else {
                bw.write(chars.length - 1 + "\n");
                bw.flush();
            }
        }

        br.close();
        bw.close();
    }
}
