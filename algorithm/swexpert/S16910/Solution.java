package algorithm.swexpert.S16910;

import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j = (-1) * n; j <= n; j++) {
                for(int k = (-1) * n; k <= n; k++) {
                    double length = Math.sqrt(Math.pow((double) Math.abs(0 - j), 2) + Math.pow((double) Math.abs(0 - k), 2));
                    if(length <= n) {
                        count++;
                    }
                }
            }
            bw.write("#" + (i + 1) + " " + count + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
