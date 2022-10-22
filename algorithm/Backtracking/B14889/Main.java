package algorithm.Backtracking.B14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n;
    static int depth;
    static int[][] point;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static void backtracking(int curDepth, int[] element) {
        if(curDepth == depth) {
            // 1. 능력치 합 구하기
            int sum = 0;
            for(int i = 0; i < element.length; i++) {
                for(int j = i; j < element.length; j++) {
                    sum += point[element[i] - 1][element[j] - 1];
                    sum += point[element[j] - 1][element[i] - 1];
                }
            }
            
            // 2. 반대편 능력치 합 구하기
            int oppositeSum = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                boolean isContain = false;
                for(int j = 0; j < element.length; j++) {
                    if (i + 1 == element[j]) {
                        isContain = true;
                        break;
                    }
                }
                if(isContain) {
                    isContain = false;
                    continue;
                }
                list.add(i+1);
            }

            for(int i = 0; i < list.size(); i++) {
                for(int j = i; j < list.size(); j++) {
                    oppositeSum += point[list.get(i) - 1][list.get(j) - 1];
                    oppositeSum += point[list.get(j) - 1][list.get(i) - 1];
                }
            }

            

            // 3. 차이 구하고 min과 비교
            int result = Math.abs(sum - oppositeSum);
            min = result < min ? result : min;

            return;
        }

        for(int i = 0; i < n; i++) {
            if(curDepth == 0) {
                element[0] = 1;
            }
            else if(element[curDepth - 1] >= i + 1) continue;

            element[curDepth] = i + 1;
            int[] newElement = Arrays.copyOf(element, element.length);
            backtracking(curDepth + 1, newElement);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        point = new int[n][n];
        depth = n / 2;
        arr = IntStream.range(1, n + 1).toArray();
        int[] element = new int[n / 2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, element);

        System.out.println(min);

        br.close();
    }
}
