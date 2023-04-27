package algorithm.Baekjun.B17406;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static List<Integer[]> list = new ArrayList<>();
    static void draw() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void permutation(int depth, List<Integer[]> selectedList) {
        if(depth == list.size()) {
            int[][] newMap = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            for(Integer[] p : selectedList) {
                rotate(p[0], p[1], p[2], newMap);
            }
            calcMin(newMap);
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selectedList.add(list.get(i));
            permutation(depth + 1, selectedList);
            selectedList.remove(list.get(i));
            visited[i] = false;
        }
    }
    static void calcMin(int[][] newMap) {
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < m; j++) {
                sum += newMap[i][j];
            }
            min = sum < min ? sum : min;
        }
    }
    static void rotate(int r, int c, int s, int[][] newMap) {
        if(s == 0) return;
        Deque<Integer> dq = new LinkedList<>();

        // 한 겹을 dp에 넣기
        int currentY = r - s - 1;
        int currentX = c - s - 1;
        int currentD = 0;
        dq.addLast(newMap[currentY][currentX]);
        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == r - s - 1 && newX == c - s - 1) break;
            if(newY < r - s - 1 || newX < c - s - 1 || newY > r + s - 1 || newX > c + s - 1) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            else {
                dq.addLast(newMap[newY][newX]);
                currentY = newY;
                currentX = newX;
            }
        }

        // 회전
        int last = dq.removeLast();
        dq.addFirst(last);

        // 회전한 값을 배열에 넣기
        currentY = r - s - 1;
        currentX = c - s - 1;
        currentD = 0;
        newMap[currentY][currentX] = dq.removeFirst();
        while(true) {
            int newY = currentY + dy[currentD];
            int newX = currentX + dx[currentD];

            if(newY == r - s - 1 && newX == c - s - 1) break;
            if(newY < r - s - 1 || newX < c - s - 1 || newY > r + s - 1 || newX > c + s - 1) {
                currentD = (currentD + 1) % 4;
                continue;
            }
            else {
                int p = dq.removeFirst();
                newMap[newY][newX] = p;
                currentY = newY;
                currentX = newX;
            }
        }
        rotate(r, c, s - 1, newMap);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Integer[] {r, c, s});
        }
        visited = new boolean[list.size()];
        permutation(0, new ArrayList<>());
        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
