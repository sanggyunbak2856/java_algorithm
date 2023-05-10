package algorithm.swexpert.S1860;

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
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] person = new int[n];
            for(int j = 0; j < n; j++) {
                person[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(person);

            int second = 0;
            int idx = 0;
            int count = 0;
            boolean isPossible = true;
            while(true) {
                if(second > 11111) break;
                if(second > 0 && second % m == 0) count += k;
                if(second == person[idx] && count > 0) {
                    count -= 1;
                    idx++;
                    if(idx == person.length) break;
                }
                else if(second == person[idx] && count == 0) {
                    isPossible = false;
                    break;
                }
                second++;
            }

            if(isPossible) bw.write("#" + (i + 1) + " Possible\n");
            else bw.write("#" + (i + 1) + " Impossible\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
