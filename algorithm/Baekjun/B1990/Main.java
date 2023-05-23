package algorithm.Baekjun.B1990;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[b + 1]; // false -> 소수
        isPrime[0] = true; isPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(b); i ++) {
            if(!isPrime[i]) {
                for(int j = 2 * i; j <= b; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for(int i = a; i <= b; i++) {
            if(!isPrime[i] && isPalindrome(i)) {
                bw.write(i + "\n");
                bw.flush();
            }
        }
        bw.write("-1\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
