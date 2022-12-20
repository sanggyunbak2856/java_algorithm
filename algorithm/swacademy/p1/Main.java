package algorithm.swacademy.p1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int calc(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return calc(b, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int ans = calc(a, b);
        System.out.println(ans);
        br.close();
    }
}
