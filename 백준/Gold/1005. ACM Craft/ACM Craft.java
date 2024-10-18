import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        test: for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Building[] buildings = new Building[N + 1];
            int[] enterDegree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                int time = Integer.parseInt(st.nextToken());
                buildings[i] = new Building(i, time);
            }
            Map<Integer, List<Building>> relationMap = new HashMap<>();
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                List<Building> relation = relationMap.getOrDefault(s, new ArrayList<>());
                relation.add(buildings[e]);
                relationMap.put(s, relation);
                enterDegree[e]++;
            }

            st = new StringTokenizer(br.readLine());
            int destination = Integer.parseInt(st.nextToken());


            PriorityQueue<Building> pq = new PriorityQueue<>((a,b) -> a.totalTime - b.totalTime);
            for (int i = 1; i < enterDegree.length; i++) {
                if (enterDegree[i] == 0){
                    pq.add(buildings[i]);
                }
            }

            while (!pq.isEmpty()){
                Building now = pq.poll();
                if (now.num == destination){
                    sb.append(now.totalTime+"\n");
                    continue test;
                }
                enterDegree[now.num]--;
                if (!relationMap.containsKey(now.num)) continue;

                for (Building next : relationMap.get(now.num)) {
                    enterDegree[next.num]--;
                    if (enterDegree[next.num] == 0){
                        next.totalTime += now.totalTime;
                        pq.add(next);
                    }
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static class Building {
        int num, time, totalTime;

        public Building(int num, int time) {
            this.num = num;
            this.time = time;
            this.totalTime = time;
        }
    }
}
