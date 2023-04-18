package algorithm.Baekjun.B1105;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        // 자리수 세기
        String strl = String.valueOf(l);
        String strr = String.valueOf(r);

        if(strl.length() != strr.length()) {
            bw.write("0\n");
            bw.flush();
        }
        else {
            int count8 = 0;
            for(int i = 0; i < strl.length(); i++) {
                if(strl.charAt(i) != strr.charAt(i)) break;
                else {
                    if(strl.charAt(i) == '8') count8++;
                }
            }
            bw.write(count8 + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
