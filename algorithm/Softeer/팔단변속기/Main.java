package algorithm.Softeer.팔단변속기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int diff = prev - second;
        StringBuilder answer = new StringBuilder();
        for(int i = 2; i < 8; i++) {
            prev = second;
            second = Integer.parseInt(st.nextToken());
            int newdiff = prev - second;
            if(diff > 0) {
                if(newdiff < 0) {
                    answer.append("mixed\n");
                    break;
                }
            }
            else {
                if(newdiff > 0) {
                    answer.append("mixed\n");
                    break;
                }
            }
        }
        if(answer.length() == 0 && diff < 0) answer.append("ascending\n");
        if(answer.length() == 0 && diff > 0) answer.append("descenging\n");
        bw.write(answer.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
