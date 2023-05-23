package algorithm.swexpert.S8016;

import java.io.*;
import java.math.BigInteger;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 1) {
                bw.write("#" + (i + 1) + " 1 1\n");
                bw.flush();
                continue;
            }
            if(n == 2) {
                bw.write("#" + (i + 1) + " 3 7\n");
                bw.flush();
                continue;
            }

            BigInteger left = BigInteger.valueOf(n - 1);
            left = left.pow(2);
            left = left.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
            BigInteger right = BigInteger.valueOf(n);
            right = right.pow(2);
            right = right.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(1));
            bw.write("#" + (i + 1) + " " + left.toString() + " " + right.toString() + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
