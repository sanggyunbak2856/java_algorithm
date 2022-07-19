package algorithm.Greedy.G1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] r = new int[n][2];
        int count = 0;
        int cur_end = 0;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            r[i][0] = Integer.parseInt(st.nextToken()); // start
            r[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        Arrays.sort(r, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for(int i = 0; i < n; i++) {
            if(r[i][0] >= cur_end) {
                count++;
                cur_end = r[i][1];
            }
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
