package algorithm.Graph.G16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

public class Main {
	// bfs
		// 주변 국가와 인구 차이를 계산하여 국경을 열고 연합을 만든 (별도로 저장한다)
		// 연합의 각 국가 인구는 평균으로 
		// 인구 이동이 없을 때 까지 반복한
			// 주변 국가의 인구 차이를 계산했을 때 연합이 이루어지지 않는 경우까지
			// 1. map을 전체 순회하여 연합 있는지 확인
			// 2. 연합이 있다면 인구이동 후 day++, 이후 1번으로 가
			// 2-1. 연합이 없다면 day를 출력
			
	
	static int n;
	static int l;
	static int r;
	static int day = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;
	static boolean isMoved = false;
	static void bfs(int y, int x) {
		if(visited[y][x]) return;
		
		Queue<Integer[]> q = new LinkedList<>();
        HashSet<Integer[]> union = new HashSet<>();
		q.add(new Integer[] {y, x});
		union.add(new Integer[] {y, x});
        visited[y][x] = true;
		int unionSize = map[y][x];
		
		while(!q.isEmpty()) {
			Integer[] p = q.poll();
			visited[p[0]][p[1]] = true;
			
			for(int i = 0; i < 4; i++) {
				int newY = p[0] + dy[i];
				int newX = p[1] + dx[i];
				
				if(newY < 0 || newX < 0 || newY >= n || newX >= n) continue;
				if(visited[newY][newX]) continue;
				
				int diff = Math.abs(map[p[0]][p[1]] - map[newY][newX]);
                Integer[] newPosition = new Integer[] {newY, newX};

				if((l <= diff) && (diff <= r)) {
					q.add(newPosition);
					union.add(newPosition);
                    unionSize += map[newY][newX];
                    visited[newY][newX] = true;
				}
			}
		}
		
		if(union.size() > 1) {
            isMoved = true;
			for(Integer[] v : union) {
				map[v[0]][v[1]] = unionSize / union.size();
			}
		}
	}
	static void movePopulation() {
		while(true) {
			// 1일
			isMoved = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}
			if(!isMoved) break;
			else {
				day += 1;
				visited = new boolean[n][n];
			}
		}
	}

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		movePopulation();
		System.out.println(day);
		
		
		br.close();
    }
}
