package algorithm.Math.M2231;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < n; i++) {
            int sum = i;
            int value = i;
            while(value > 0) {
                sum += (value % 10);
                value /= 10;
            }
            if(sum == n) {
                answer = i;
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
