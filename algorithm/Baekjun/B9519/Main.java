package algorithm.Baekjun.B9519;

import java.io.*;
import java.util.*;

public class Main {
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Map<String, Integer> map = new HashMap<>();

        int count = 0;
        boolean isFound = false;
        for(int i = 0; i < n; i++) {
            char[] chars = str.toCharArray();
            StringBuilder evenString = new StringBuilder();
            StringBuilder oddString = new StringBuilder();

            for(int j = 0; j < chars.length; j++) {
                if(j % 2 == 0) evenString.append(chars[j]);
                else oddString.append(chars[j]);
            }
            str = evenString.append(oddString.reverse()).toString();
            count = i;
            if(map.containsKey(str)) {
                isFound = true;
                break;
            }
            else map.put(str, i + 1);
        }
        if(isFound) {
            int index = count == 1 ? 1 : (n % count);
            map.forEach((k, v) -> {
                if(v == index) {
                    answer = k;
                }
            });
            bw.write(answer + "\n");
        }
        else {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.flush();
        br.close();
        bw.close();
    }
}
