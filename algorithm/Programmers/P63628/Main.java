package algorithm.Programmers.P63628;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        int firstPrice = Integer.parseInt(br.readLine());
        String last = br.readLine();
        int lastPrice = Integer.parseInt(br.readLine());

        if(firstPrice > lastPrice) System.out.println(first);
        else System.out.println(last);

        br.close();
    }
}
