package algorithm.Programmers.P64551;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double n = Double.parseDouble(st.nextToken());
            String s = st.nextToken();


            if(s.equals("K")) {
                bw.write(df.format((double) (n / 1.6)) + "\n");
            }
            else {
                bw.write(df.format((double) (n * 1.6)) + "\n");
            }
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
