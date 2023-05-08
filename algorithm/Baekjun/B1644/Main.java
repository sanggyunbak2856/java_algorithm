package algorithm.Baekjun.B1644;

import java.io.*;

public class Main {
    static int calc(int n, boolean[] isPrime){
        int sum = 2;
        int left = 2;
        int right = 2;
        int count = 0;

        while(left <= right) {
            if(right > n) break;
            if(sum == n) {
                if(left == 4000000 && right == 4000000) break;
                count += 1;
                right += 1;
                if(right > 4000000) break;
                while(isPrime[right] | right == 2) {
                    if(right == 4000000) break;
                    right += 1;
                }
                sum += right;
            }
            else if(sum < n) {
                right += 1;
                if(right > 4000000) break;
                while(isPrime[right] || right == 2) {
                    if(right == 4000000) break;
                    right += 1;
                }
                sum += right;
            }
            else {
                sum -= left;
                left += 1;
                if(left > 4000000) break;
                while(isPrime[left] || left == 2) {
                    if(left == 4000000) break;
                    if(left > right) break;
                    left += 1;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[4000001]; // false -> 소수, true -> 소수 아님
        isPrime[0] = true; isPrime[1] = true;

        for(int i = 2; i < Math.sqrt(isPrime.length); i++) {
            if(!isPrime[i]) {
                for(int j = 2 * i; j < 4000001; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for(int i = 0; i < 1; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = calc(n, isPrime);
            bw.write(answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
