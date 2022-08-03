package algorithm.DataStructure.D11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<Integer> hashSet = new HashSet<>();
    static void add(int x) {
        hashSet.add(x);
    }
    static void remove(int x) {
        if(hashSet.contains(x)) hashSet.remove(x);
    }
    static boolean check(int x) {
        if (hashSet.contains(x)) return true;
        else return false;
    }
    static void toggle(int x) {
        if(hashSet.contains(x)) hashSet.remove(x);
        else hashSet.add(x);
    }
    static void all() {
        hashSet.clear();
        for(int i = 1; i < 21; i++) {
            hashSet.add(i);
        }
    }
    static void empty() {
        hashSet.clear();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if(command.equals("add")) add(Integer.parseInt(st.nextToken()));
            if(command.equals("remove")) remove(Integer.parseInt(st.nextToken()));
            if(command.equals("check")) {
                if(check(Integer.parseInt(st.nextToken()))) bw.write("1\n");
                else bw.write("0\n");
            }
            if(command.equals("toggle")) toggle(Integer.parseInt(st.nextToken()));
            if(command.equals("all")) all();
            if(command.equals("empty")) empty();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
