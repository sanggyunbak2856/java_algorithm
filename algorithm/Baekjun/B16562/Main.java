package algorithm.Baekjun.B16562;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, k;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static boolean isFound = false;
    static int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if(xRoot < yRoot) parent[yRoot] = xRoot;
        else parent[xRoot] = yRoot;
    }
    static boolean findUnion(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }
    static boolean isAllFriend(int[] parent) {
        boolean isAllFriend = true;
        for(int i = 1; i < parent.length; i++) {
            if(!findUnion(parent, 1, i)) {
                isAllFriend = false;
                break;
            }
        }
        return isAllFriend;
    }
    static void findMin(int[] parent, int[][] cost, ArrayList<Integer> friends, int currentCost) {
        if(isFound) return;
        if(currentCost > k) return;
        if(!friends.isEmpty()) {
            int lastFriend = friends.get(friends.size() - 1);
            int firstFriend = friends.get(0);
            union(parent, lastFriend, firstFriend);
            if(isAllFriend(parent)) {
                min = currentCost < min ? currentCost : min;
                isFound = true;
                return;
            }
        }
        
        for(int i = 1; i < cost.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            boolean isAlreadyFriend = false;
            for(int friend : friends) {
                if(findUnion(parent, friend, i)) {
                    isAlreadyFriend = true;
                    break;
                }
            }
            if(isAlreadyFriend) continue;

            int newCost = currentCost + cost[i][1];
            friends.add(i);
            int[] newParent = new int[n + 1];
            for(int j = 0; j < n + 1; j++) {
                newParent[j] = parent[j];
            }
            findMin(newParent, cost, friends, newCost);
            visited[i] = false;
            friends.remove(Integer.valueOf(i));
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n + 1][2];
        int[] parent = new int[n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            cost[i][0] = i;
            cost[i][1] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(parent, x, y);
        }
        findMin(parent, cost, new ArrayList<>(), 0);
        if(min != Integer.MAX_VALUE) bw.write(min + "\n");
        else bw.write("Oh no\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
