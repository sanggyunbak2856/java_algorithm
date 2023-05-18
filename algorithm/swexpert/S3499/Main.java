package algorithm.swexpert.S3499;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Queue<String> strUp = new LinkedList<>();
            Queue<String> strDown = new LinkedList<>();
            List<String> shuffle = new LinkedList<>();
            int half = n / 2;
            half += (n % 2);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < half; j++) {
                strUp.add(st.nextToken());
            }
            for(int j = half; j < n; j++) {
                strDown.add(st.nextToken());
            }

            for(int j = 0; j < half; j++) {
                shuffle.add(strUp.poll());
                shuffle.add(strDown.poll());
            }

            bw.write("#" + (i + 1) + " ");
            for(String s : shuffle) {
                if(s == null) break;
                bw.write(s + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
