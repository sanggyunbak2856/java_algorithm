package algorithm.Baekjun.B19236;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int max = 0;
    static void draw(int[][] map) throws IOException {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void fishMove(int[][] map, Fish[] fishes, Shark shark) throws IOException {
        Fish[] f = fishes;
        for(int i = 1; i < 17; i++) {
            if(fishes[i] == null) continue;
            while(true) {
                int newY = fishes[i].positionY + dy[fishes[i].direction];
                int newX = fishes[i].positionX + dx[fishes[i].direction];

                if(newY < 0 || newX < 0 || newY >= 4 || newX >= 4 || (newY == shark.positionY && newX == shark.positionX)) { // 경계 밖
                    fishes[i].direction = (fishes[i].direction + 1) % 8;
                    continue;
                }
                if(map[newY][newX] == 0) { // 물고기 없음
                    map[fishes[i].positionY][fishes[i].positionX] = 0;
                    fishes[i].positionY = newY;
                    fishes[i].positionX = newX;
                    map[newY][newX] = fishes[i].value;
                    break;
                }
                else { // 물고기 있음
                    int changeValue = map[newY][newX];
                    if(fishes[map[newY][newX]] == null) {
                        int x = 1;
                    }
                    map[fishes[i].positionY][fishes[i].positionX] = fishes[map[newY][newX]].value;
                    map[newY][newX] = fishes[i].value;

                    int tmpY = fishes[i].positionY;
                    int tmpX = fishes[i].positionX;
                    fishes[i].positionY = fishes[changeValue].positionY;
                    fishes[i].positionX = fishes[changeValue].positionX;
                    fishes[changeValue].positionY = tmpY;
                    fishes[changeValue].positionX = tmpX;
                    break;
                }
            }
            // if(i == 15 && map[0][0] == 15) {
            //     int x = 1;
            // }
            // bw.write(i + "\n");
            // draw(map);
        }
    }
    static void simulation(Shark shark, int[][] map, Fish[] fishes, int current) throws IOException{
        fishMove(map, fishes, shark);
        List<Fish> fishList = new LinkedList<>();
        int currentSharkY = shark.positionY;
        int currentSharkX = shark.positionX;
        while(true) {
            int newY = currentSharkY + dy[shark.direction];
            int newX = currentSharkX + dx[shark.direction];

            if(newY < 0 || newX < 0 || newY >= 4 || newX >= 4) break;
            if(map[newY][newX] != 0) {
                fishList.add(fishes[map[newY][newX]]);
            }
            currentSharkY = newY;
            currentSharkX = newX;
        }

        if(fishList.isEmpty()) {
            max = current > max ? current : max;
            return;
        }

        for(Fish f : fishList) {
            int[][] newMap = new int[4][4];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            newMap[f.positionY][f.positionX] = 0;

            Fish[] newFishes = new Fish[17];
            for(int i = 0; i < 17; i++) {
                if(i == f.value) continue;
                if(fishes[i] != null) {
                    newFishes[i] = new Fish(fishes[i]);
                }
            }

            Shark newShark = new Shark(0, f.direction, f.positionY, f.positionX);
            simulation(newShark, newMap, newFishes, current + f.value);
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[4][4];
        Fish[] fishes = new Fish[17];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int value = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                fishes[value] = new Fish(value, direction - 1, i, j);
                map[i][j] = value;
            }
        }
        
        int firstFish = map[0][0];
        map[0][0] = 0;
        Shark shark = new Shark(0, fishes[firstFish].direction, 0, 0);
        fishes[firstFish] = null;

        simulation(shark, map, fishes, firstFish);
        // fishMove(map, fishes, shark);
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static class Fish {
        int value;
        int direction;
        int positionY;
        int positionX;

        public Fish(int value, int direction, int positionY, int positionX) {
            this.value = value;
            this.direction = direction;
            this.positionY = positionY;
            this.positionX = positionX;
        }

        public Fish(Fish fish) {
            this.value = fish.value;
            this.direction = fish.direction;
            this.positionY = fish.positionY;
            this.positionX = fish.positionX;
        }

        public void changePosition(Fish fish) {
            int tmpY = this.positionY;
            int tmpX = this.positionX;
            this.positionY = fish.positionY;
            this.positionX = fish.positionX;
            fish.positionY = tmpY;
            fish.positionX = tmpX;
        }
    }
    static class Shark extends Fish {
        public Shark(int value, int direction, int positionY, int positionX) {
            super(value, direction, positionY, positionX);
        }
    }
}
