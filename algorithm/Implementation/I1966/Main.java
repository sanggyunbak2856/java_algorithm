package algorithm.Implementation.I1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int findMax(Map<Integer, Integer> map) {
        int max = 0;
        for(int key : map.keySet()) {
            if(map.get(key) == 0) continue;
            else max = max > key ? max : key;
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer[]> q = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 10; j++) {
                map.put(j, 0);
            }

            int max = 0;
            for(int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                q.add(new Integer[] {j, p});
                max = p > max ? p : max;
                map.put(p, map.get(p) + 1);
            }

            int count = 1;
            while(true) {
                Integer[] p = q.poll();
                if(p[0] == m) {
                    if(p[1] < max) {
                        q.add(p);
                        continue;
                    }
                    break;
                }
                if(p[1] == max) {
                    map.put(p[1], map.get(p[1]) - 1);
                    count += 1;
                    if(map.get(p[1]) == 0) {
                        max = findMax(map);
                        continue;
                    }
                }
                else {
                    q.add(p);
                }
            }
            System.out.println(count);
        }

        br.close();
    }
}
