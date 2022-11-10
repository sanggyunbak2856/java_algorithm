package algorithm.Greedy.G1439;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] chars = br.readLine().split("");
        int[] answer = new int[2];
        int curValue = Integer.parseInt(chars[0]);
        answer[curValue] += 1;
        for(int i = 1; i < chars.length; i++) {
            int num = Integer.parseInt(chars[i]);
            if(curValue == num) {
                continue;
            }
            else {
                curValue = num;
                answer[num] += 1;
            }
        }

        int result = Math.min(answer[0], answer[1]);
        System.out.println(result);
        
        br.close();
    }
}
