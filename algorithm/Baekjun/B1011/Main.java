package algorithm.Baekjun.B1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int centauri(int dist) {
        int max = (int) Math.sqrt(dist);

        if(max == Math.sqrt(dist))  return max * 2 - 1;
        else if(dist <= max * max + max) return max * 2;
        else return max * 2 + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int calc = centauri(y - x);
            bw.write(calc + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
