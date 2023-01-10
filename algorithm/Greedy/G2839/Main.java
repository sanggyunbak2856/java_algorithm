package algorithm.Greedy.G2839;

import java.io. BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int deliverWeight;
    static void bruteforce(int depth, int weight) {
        if(weight == deliverWeight) {
            min = depth < min ? depth : min;
            return;
        }

        if(weight > deliverWeight) return;
        bruteforce(depth + 1, weight + 3);
        bruteforce(depth + 1, weight + 5);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        deliverWeight = Integer.parseInt(br.readLine());
        bruteforce(0, 0);

        if(min == Integer.MAX_VALUE) bw.write("-1" + "\n");
        else bw.write(min + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
