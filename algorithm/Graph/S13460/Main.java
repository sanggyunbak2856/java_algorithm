package algorithm.Graph.S13460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) { // 0: # 1: . 2: R 3: B 4: 0
            String[] line = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                switch(line[j]) {
                    case "#":
                        map[i][j] = 0;
                        break;
                    case ".":
                        map[i][j] = 1;
                        break;
                    case "R":
                        map[i][j] = 2;
                        break;
                    case "B":
                        map[i][j] = 3;
                        break;
                    case "O":
                        map[i][j] = 4;
                        break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
