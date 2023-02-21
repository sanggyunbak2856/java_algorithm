package algorithm.Baekjun.B16139;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().toCharArray()[0];
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            char[] strArr = str.substring(start, end + 1).toCharArray();
            int[] prefix = new int[strArr.length + 1];
            
            for(int j = 1; j < strArr.length + 1; j++) {
                if(strArr[j - 1] == alphabet) prefix[j] = prefix[j - 1] + 1;
                else prefix[j] = prefix[j - 1];
            }

            bw.write(prefix[strArr.length] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
