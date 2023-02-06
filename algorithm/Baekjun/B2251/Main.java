package algorithm.Baekjun.B2251;

import java.io.*;
import java.util.*;

public class Main {
    static class Bottles{
        int a;
        int b;
        int c;

        Bottles(int a, int b, int c) {
            this.a = a; this.b = b; this.c = c;
        }

        @Override
        public boolean equals(Object newb) {
            Bottles bb = (Bottles) newb;
            if(this.a == bb.a && this.b == bb.b && this.c == bb.c) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return a + b + c;
        }
    }
    static int aLimit;
    static int bLimit;
    static int cLimit;
    static HashSet<Bottles> possibleC = new HashSet<>();
    static void dfs(int a, int b, int c) {
        Bottles bottle = new Bottles(a, b, c);
        if(possibleC.contains(bottle)) return;
        else possibleC.add(bottle);

        // a에 물이 있음
        if(a > 0) {
            // b에 물을 넣음
            int bDiff = bLimit - b;
            if(a <= bDiff) {
                b += a;
                a = 0;
                dfs(a, b, c);
            }
            else {
                b = bLimit;
                a = a - bDiff;
                dfs(a, b, c);
            }

            // c에 물을 넣음
            int cDiff = cLimit - c;
            if(a <= cDiff) {
                c += a;
                a = 0;
                dfs(a, b, c);
            }
            else {
                c = cLimit;
                a = a - cDiff;
                dfs(a, b, c);
            }
        }

        // b에 물이 있음
        if(b > 0) {
            // a에 물을 넣음
            int aDiff = aLimit - a;
            if(b <= aDiff) {
                a += b;
                b = 0;
                dfs(a, b, c);
            }
            else {
                a = aLimit;
                b = b - aDiff;
                dfs(a, b, c);
            }

            // c에 물을 넣음
            int cDiff = cLimit - c;
            if(b <= cDiff) {
                c += b;
                b = 0;
                dfs(a, b, c);
            }
            else {
                c = cLimit;
                b = b - cDiff;
                dfs(a, b, c);
            }
        }

        // c에 물이 있음
        if(c > 0) {
            // b에 물을 넣음
            int bDiff = bLimit - b;
            if(c <= bDiff) {
                b += c;
                c = 0;
                dfs(a, b, c);
            }
            else {
                b = bLimit;
                c = c - bDiff;
                dfs(a, b, c);
            }

            // a에 물을 넣음
            int aDiff = aLimit - a;
            if(c <= aDiff) {
                a += c;
                c = 0;
                dfs(a, b, c);
            }
            else {
                a = aLimit;
                c = c - aDiff;
                dfs(a, b, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        aLimit = Integer.parseInt(st.nextToken());
        bLimit = Integer.parseInt(st.nextToken());
        cLimit = Integer.parseInt(st.nextToken());

        dfs(0, 0, cLimit);
        ArrayList<Integer> answer = new ArrayList<>();
        possibleC.iterator().forEachRemaining(
            (i) -> answer.add(i.c)
        );
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + " ");
        } 
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
