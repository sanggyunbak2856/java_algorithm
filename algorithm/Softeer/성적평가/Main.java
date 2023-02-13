package algorithm.Softeer.성적평가;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[4][n];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            score[3][i] = score[0][i] + score[1][i] + score[2][i];
        }

        for(int i = 0; i < 4; i++) {
            PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1[1] == o2[1]) return o1[0] - o2[0];
                    else return o2[1] - o1[1];
                }
            );
            int[] answer = new int[n];

            for(int j = 0; j < n; j++) {
                pq.add(new Integer[] {j, score[i][j]});
            }

            int currentGrade = 0;
            int currentScore = 0;
            int count = 1;
            while(!pq.isEmpty()) {
                Integer[] p = pq.poll();
                if(currentScore != p[1]) {
                    answer[p[0]] = currentGrade + count;
                    currentGrade += count;
                    currentScore = p[1];
                    count = 1;
                }
                else {
                    answer[p[0]] = currentGrade;
                    count += 1;
                }
            }
            // output
            for(int j = 0; j < n; j++) {
                bw.write(answer[j] + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
