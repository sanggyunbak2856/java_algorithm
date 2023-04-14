package algorithm.Baekjun.B13913;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> copyArrayList(ArrayList<Integer> a, int first, int time) {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(first);
        newList.add(time);
        for(int i = 2; i < a.size(); i++) {
            newList.add(a.get(i));
        }
        return newList;
    }
    static ArrayList<Integer> findSister(int n, int k, boolean[] visited) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(n);
        first.add(0); // time
        first.add(n);
        q.add(first);
        visited[n] = true;

        ArrayList<Integer> foundList = new ArrayList<>();
        while(!q.isEmpty()) {
            ArrayList<Integer> p = q.poll();
            int position = p.get(0);

            if(position == k) {
                foundList = p;
                break;
            }

            if(position > 0) {
                int newPosition = position - 1;
                if(!visited[newPosition]) {
                    visited[newPosition] = true;
                    ArrayList<Integer> newList = copyArrayList(p, newPosition, p.get(1) + 1);
                    newList.add(newPosition);
                    q.add(newList);
                }
            }

            if(position < 100000) {
                int newPosition = position + 1;
                if(!visited[newPosition]) {
                    visited[newPosition] = true;
                    ArrayList<Integer> newList = copyArrayList(p, newPosition, p.get(1) + 1);
                    newList.add(newPosition);
                    q.add(newList);
                }
            }

            if(position != 0 && (position * 2) < 100001) {
                int newPosition = position * 2;
                if(!visited[newPosition]) {
                    visited[newPosition] = true;
                    ArrayList<Integer> newList = copyArrayList(p, newPosition, p.get(1) + 1);
                    newList.add(newPosition);
                    q.add(newList);
                }
            }
        }
        return foundList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] visited = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        if(n > k) {
            answer.append(n - k + "\n");
            for(int i = n; i >= k; i--) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
        }
        else {
            ArrayList<Integer> foundList = findSister(n, k, visited);
            answer.append(foundList.get(1)).append("\n");
            for(int i = 2; i < foundList.size(); i++) {
                answer.append(foundList.get(i)).append(" ");
            }
            answer.append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
