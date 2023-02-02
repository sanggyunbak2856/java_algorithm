package algorithm.Softeer.회의실예약;

import java.io.*;
import java.util.*;

public class Main {
    static boolean isRoomAvailable(boolean[] schedule) {
        for(int i = 0; i < 10; i++) {
            if(!schedule[i]) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<String> roomNames = new LinkedList<>();
        // 입력
        Map<String, boolean[]> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String roomName = br.readLine();
            map.put(roomName, new boolean[10]);
            roomNames.add(roomName);
        }

        // 회의 시간 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] time = map.get(roomName);
            for(int j = start; j <= end; j++) {
                time[j - 9] = true; // true이면 해당 시간에 사용중
            }
        }

        Collections.sort(roomNames);
        // 출력
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for(String roomName : roomNames) {
            boolean[] roomSchedule = map.get(roomName);
            if(isRoomAvailable(roomSchedule)) {
                boolean prev = roomSchedule[0];
                int count = prev? 0 : 1;
                StringBuilder temp = new StringBuilder();
                answer.append("Room ").append(roomName).append(":\n");
                if(!prev) {
                    temp.append("09-");
                }
                for(int i = 1; i <= 9; i++) {
                    if(prev == false && !roomSchedule[i]) continue;
                    else if(prev == false && roomSchedule[i]) {
                        prev = true;
                        temp.append(i + 9).append("\n");
                    }
                    else if(prev == true && roomSchedule[i]) continue;
                    else if(prev == true && !roomSchedule[i]) {
                        count += 1;
                        prev = false;
                        temp.append(i + 8).append("-");
                    }
                }
                if(!roomSchedule[9]) temp.append("18\n");
                answer.append(count).append(" available:\n");
                answer.append(temp);
                if(idx != n - 1) answer.append("-----\n");
                idx++;
            }
            else {
                answer.append("Room ").append(roomName).append(":\n");
                answer.append("Not available\n");
                if(idx != n - 1) answer.append("-----\n");
                idx++;
            }
        }

        bw.write(answer.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
