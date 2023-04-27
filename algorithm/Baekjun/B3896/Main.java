package algorithm.Baekjun.B3896;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[1299710]; // false -> 소수, true -> 소수 아님
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(1299710); i++) {
            if(!prime[i]) {
                for(int j = i * i; j <= 1299709; j += i) {
                    prime[j] = true;
                }
            }
        }
        
        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++) {
            int k = Integer.parseInt(br.readLine());
            if(prime[k]) {
                int left = k;
                int right = k;
                while(left > 0) {
                    if(!prime[--left]) break;
                }
                while(right < 1299710) {
                    if(!prime[++right]) break;
                }
                bw.write((right - left) + "\n");
            }
            else {
                bw.write("0\n");
            }
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
