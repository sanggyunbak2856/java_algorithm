package algorithm.Programmers.무인도여행;
import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int bfs(int y, int x, boolean[][] visited, int[][] map) {
        if(visited[y][x]) return -1;
        if(map[y][x] == -1) return -1;
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y, x});
        visited[y][x] = true;
        int sum = map[y][x];
        int height = map.length;
        int width = map[0].length;
        
        while(!q.isEmpty()) {
            Integer[] p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                
                if(newY < 0 || newX < 0 || newY >= height || newX >= width)
                    continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == -1) continue;
                q.add(new Integer[] {newY, newX});
                visited[newY][newX] = true;
                sum += map[newY][newX];
            }
        }
        return sum;
    }
    public int[] solution(String[] maps) {
        int[] answer = {};
        int height = maps.length;
        int width = maps[0].length();
        int[][] map = new int[height][width];
        boolean[][] visited = new boolean[height][width];
        
        for(int i = 0; i < height; i++) {
            String[] row = maps[i].split("");
            for(int j = 0; j < width; j++) {
                if(row[j].equals("X")) map[i][j] = -1;
                else map[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        List<Integer> counts = new ArrayList<Integer>();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int count = bfs(i, j, visited, map);
                if(count > 0) counts.add(count); 
            }
        }
        
        if(counts.size() == 0) answer = new int[] {-1};
        else answer = new int[counts.size()];
        for(int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
