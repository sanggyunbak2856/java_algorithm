package algorithm.Greedy.G1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int calc(String str) {
        int sum = 0;
        if(str.contains("+")) {
            StringTokenizer st = new StringTokenizer(str, "+");
            while(st.hasMoreTokens()) {
                sum += (Integer.parseInt(st.nextToken()));
            }
        }
        else {
            sum = Integer.parseInt(str);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int answer = 0;
        boolean isFirst = true;
        while(st.hasMoreTokens()) {
            if(isFirst) {
                answer = calc(st.nextToken());
                isFirst = false;
                continue;
            }
            answer -= calc(st.nextToken());
        }

        System.out.println(answer);

        br.close();
    }
}
