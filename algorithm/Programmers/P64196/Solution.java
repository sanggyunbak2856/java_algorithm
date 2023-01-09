package algorithm.Programmers.P64196;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt1 = 0;
            int cnt2 = 0;

            char[] chars = br.readLine().toCharArray();
            boolean startCount = false;
            for(int j = 0; j < n; j++) {
                if((chars[j] == '@' || chars[j] == 'O') && !startCount) {
                    startCount = true;
                    continue;
                }
                if(startCount && chars[j] == '#') cnt1 += 1;
                if(startCount && (chars[j] == '@' || chars[j] == 'O')) break;
            }
            startCount = false;

            for(int j = 0; j < n; j++) {
                if((chars[j] == '@' || chars[j] == 'G') && !startCount) {
                    startCount = true;
                    continue;
                }
                if(startCount && chars[j] == '#') cnt2 += 1;
                if(startCount && (chars[j] == '@' || chars[j] == 'G')) break;        
            }

            if((cnt1 <= m) || (cnt2 <= m)) bw.write("HAHA!\n");
            else bw.write("HELP!\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
    
}
