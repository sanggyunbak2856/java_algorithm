package algorithm.Implementation.I1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder str = new StringBuilder(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int cursor = str.length();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            if(st.countTokens() > 1) { // P x
                String s = st.nextToken();
                String ins = st.nextToken();

                if(s.equals("P")) {
                    str.insert(cursor, ins);
                    cursor += 1;
                }
            }
            else { // L, D, B
                String s = st.nextToken();
                if(s.equals("L") && cursor > 0) cursor -= 1;
                if(s.equals("D") && cursor < str.length()) cursor += 1;
                if(s.equals("B") && cursor > 0) {
                    str.replace(cursor - 1, cursor, "");
                    cursor -= 1;
                }
            }
        }

        str.append("\n");
        bw.write(str.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
