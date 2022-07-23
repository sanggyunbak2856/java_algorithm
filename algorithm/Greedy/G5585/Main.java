package algorithm.Greedy.G5585;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coin = new int[] {500, 100, 50, 10, 5, 1};
        int price = Integer.parseInt(br.readLine());
        int changes = 1000 - price;
        int count = 0;

        for(int i = 0; i < coin.length; i++) {
            if(coin[i] > changes) continue;

            count += (changes / coin[i]);
            changes %= coin[i];
        }

        System.out.println(count);
    }
}
