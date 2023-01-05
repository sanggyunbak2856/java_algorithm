package algorithm.Programmers.P64178;

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

            char[] chars = br.readLine().toCharArray();
            int count = 0;
            boolean startCount = false;
            for(int j = 0; j < n; j++) {
                if((chars[j] == 'O' || chars[j] == '@') && startCount == false) {
                    startCount = true;
                    continue;
                }
                if(chars[j] == '#' && startCount) {
                    count += 1;
                    continue;
                }
                if((chars[j] == 'O' || chars[j] == '@') && startCount) break;
            }

            if(count <= m) bw.write("HAHA!\n");
            else bw.write("HELP!\n");

            bw.flush();
        }

        br.close();
        bw.close();
    }
}
