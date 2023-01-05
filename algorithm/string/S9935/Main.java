package algorithm.string.S9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String replacement = br.readLine();

        while(str.contains(replacement)) {
            str = str.replace(replacement, "");
        }

        if(str.length() == 0) bw.write("FRULA\n");
        else bw.write(str + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
