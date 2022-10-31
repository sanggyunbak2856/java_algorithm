package algorithm.Backtracking.B14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] operators = new int[4]; // 0 -> +, 1 -> -, 2 -> *, 3 -> /
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static void bfs(int depth, int start, int curValue, int[] paramOperators, int operator) {
        if(depth == n - 1) {
            max = curValue > max ? curValue : max;
            min = curValue < min ? curValue : min;
        }

        for(int i = start; i < n; i++) {
            if(visited[i]) continue;
            int newValue = calc(curValue, arr[i], operator);
            visited[i] = true;

            // +
            if (paramOperators[0] > 0) {
                int[] newOperators= deepcopy(paramOperators);
                newOperators[0] -= 1;
                bfs(depth + 1, start + 1, newValue, newOperators, 0);
            }
            // -
            if (paramOperators[1] > 0) {
                int[] newOperators= deepcopy(paramOperators);
                newOperators[1] -= 1;
                bfs(depth + 1, start + 1, newValue, newOperators, 1);
            }
            // *
            if (paramOperators[2] > 0) {
                int[] newOperators= deepcopy(paramOperators);
                newOperators[2] -= 1;
                bfs(depth + 1, start + 1, newValue, newOperators, 2);
            }
            // /
            if (paramOperators[3] > 0) {
                int[] newOperators= deepcopy(paramOperators);
                newOperators[3] -= 1;
                bfs(depth + 1, start + 1, newValue, newOperators, 3);
            }

            bfs(depth + 1, start + 1, newValue, paramOperators, 0);

            visited[i] = false;
        }
    }
    static int calc (int x, int y, int operator) {
        int res = x;
        if (operator == 0) res += y;
        else if(operator == 1) res -= y;
        else if(operator == 2) res *= y;
        else if(operator == 3) res /= y;
        return res;
    }
    static int[] deepcopy(int[] arr) {
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                int[] newOperators = deepcopy(operators);
                newOperators[i] -= 1;
                bfs(0, 1, arr[0], newOperators, i);
            }
        }

        System.out.println(max);
        System.out.println(min);
        br.close();
    }   
}
