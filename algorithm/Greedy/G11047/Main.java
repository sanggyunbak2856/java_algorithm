package algorithm.Greedy.G11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = 0; i < money.length; i++) {
            int curMoney = money[money.length - 1 - i];
            if(curMoney > k) continue;
            else if(curMoney == k) {
                count++;
                break;
            }
            else {
                int div = k / curMoney;
                count += div;
                k = k % curMoney;
            }
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
