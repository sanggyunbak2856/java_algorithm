package algorithm.Programmers.P63949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        int count = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals('#')) count+=1;
        }

        if(count < 2) System.out.println("HAHA!");
        else System.out.println("HELP!");

        br.close();
    }
}
