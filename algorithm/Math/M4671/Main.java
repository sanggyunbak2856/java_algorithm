package algorithm.Math.M4671;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int generateNumber(int n) {
        int sum = n;
        while(n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] selfNumber = new boolean[100001];
        Arrays.fill(selfNumber, true);
        for(int i = 1; i < 10001; i++) {
            int n = generateNumber(i);
            if(n <= 10000) selfNumber[n] = false;
        }

        for(int i = 1; i < 10001; i++) {
            if(selfNumber[i]) bw.write(i + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
