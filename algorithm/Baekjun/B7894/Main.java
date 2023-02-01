package algorithm.Baekjun.B7894;

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
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            double sum = 0;
            for(int j = 2; j <= m; j++) {
                sum += Math.log10(j);
            }
            int answer = (int) sum + 1;

            bw.write(answer + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
