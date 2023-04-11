package algorithm.swexpert.S14178;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int count = 2 * d + 1;
            double answer = n / (double) count;

            bw.write("#" + (i + 1) + " " + ((int) Math.ceil(answer)) + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
