package algorithm.Baekjun.B3190;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Pair> commands = new LinkedList<Pair>();
    static int game() {
        Deque<Integer[]> snake = new LinkedList<>();
        Pair currentCommand = commands.poll();
        int currentDirection = 2;
        int currentTime = 0;

        snake.add(new Integer[] {0, 0});
        map[0][0] = 2;
        
        while(true) {
            currentTime++;

            Integer[] head = snake.peek();
            int newHeadY = head[0] + dy[currentDirection];
            int newHeadX = head[1] + dx[currentDirection];

            if(newHeadY < 0 || newHeadX < 0 || newHeadY >= n || newHeadX >= n) break; // 벽에 부딛힘
            if(map[newHeadY][newHeadX] == 2) break; // 자기 자신에 부딛힘

            if(map[newHeadY][newHeadX] == 1) { // 사과 먹음
                map[newHeadY][newHeadX] = 2;
                snake.addFirst(new Integer[] {newHeadY, newHeadX});
            }
            else if(map[newHeadY][newHeadX] == 0) { // 사과 안먹음
                map[newHeadY][newHeadX] = 2;
                snake.addFirst(new Integer[] {newHeadY, newHeadX});
                Integer[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            if(currentTime == currentCommand.time) {
                if(currentCommand.direction == 'D') {
                    currentDirection = (currentDirection + 1) % 4;
                    
                }
                else if(currentCommand.direction == 'L') { // L
                    currentDirection -= 1;
                    if(currentDirection == -1) currentDirection = 3;
                }

                if(!commands.isEmpty()) {
                    currentCommand = commands.poll();
                }
            }
        }
        return currentTime;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = 1; // apple
        }

        int l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().toCharArray()[0];
            commands.add(new Pair(time, ch));
        }

        int answer = game();
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
    static class Pair {
        public int time;
        public char direction;
        public Pair(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
