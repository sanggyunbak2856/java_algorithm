package week2.sangGyun.S11652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
            else {
                map.put(x, 1L);
            }
        }

        long max_value = 0;
        long max_key = 0;
        for(Long key : map.keySet()) {
            if(map.get(key) > max_value) {
                max_value = map.get(key);
                max_key = key;
            }
            if(map.get(key) == max_value) {
                if(key > max_key) continue;
                else {
                    max_key = key;
                    max_value = map.get(key);
                }
            }
        }

        bw.write(max_key + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
