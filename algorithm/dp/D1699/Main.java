package algorithm.dp.D1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static int min = Integer.MAX_VALUE;
    static void count(int s, int left) {
        int count = 0;
        while(left > 0) {
            int pow = (int) Math.pow(s, 2);
            if(left >= pow) {
                left -= pow;
                count += 1;
                if(left == 0) break;
                if(count > min) break;
            }
            else s -= 1;
        }
        min = count < min ? count : min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(n);
        int left = n;
        for(int i = sqrt; i > 0; i--) {
            count(i, left);
        }

        bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
