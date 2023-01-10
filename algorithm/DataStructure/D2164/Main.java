package algorithm.DataStructure.D2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        if(q.size() == 1) bw.write(q.poll() + "\n");
        else if(q.size() == 2) {
            q.poll();
            bw.write(q.poll() + "\n");
        }
        else {
            while(q.size() > 2) {
                q.poll();
                int p = q.poll();
                q.add(p);
            }
            q.poll();
            bw.write(q.poll() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
