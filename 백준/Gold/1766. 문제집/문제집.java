import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(e);
            map.put(s,list);
            degree[e]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Integer now = pq.poll();
            sb.append(now+" ");
            List<Integer> next = map.get(now);
            if (next == null) continue;
            for (Integer n : next) {
                degree[n]--;
                if (degree[n] == 0) pq.add(n);
            }
        }
        System.out.println(sb.toString().trim());
    }
}
