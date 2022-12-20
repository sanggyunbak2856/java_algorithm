package algorithm.swacademy.p3;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        int p1 = 0; int p2 = 0;
        StringBuilder sb = new StringBuilder();

        while(true) {
            if(p1 < str1.length) {
                sb.append(str1[p1]).append(" ");
                p1++;
            }
            if(p2 < str2.length) {
                sb.append(str2[p2]).append(" ");
                p2++;
            }

            if(p1 == str1.length && p2 == str2.length) break;
        }
        System.out.println(sb);

        br.close();
    }
}
