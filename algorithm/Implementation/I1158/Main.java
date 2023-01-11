package algorithm.Implementation.I1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(!list.isEmpty()) {
            idx = (idx + k - 1) % list.size();
            int r = list.remove(idx);
            answer.add(r);
        }

        bw.write("<");
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "");
            if(i != answer.size() - 1) bw.write(", ");
        }
        bw.write(">\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
