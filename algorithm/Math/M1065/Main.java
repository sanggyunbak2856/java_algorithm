package algorithm.Math.M1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static boolean isHansu(int n) {
        if(n < 100) return true;
        int m = n % 10;
        n /= 10;
        int l = n % 10;
        int diff = m - l;
        while(n >= 10) {
            m = n % 10;
            n /= 10;
            l = n % 10;
            if((m - l) == diff) continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(isHansu(i)) count+=1;
        }
        bw.write(count + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
