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
        boolean[] v = new boolean[N+1];
        Map<Integer, List<int[]>> link = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            List<int[]> aLink = link.getOrDefault(a, new ArrayList<>());
            List<int[]> bLink = link.getOrDefault(b, new ArrayList<>());
            aLink.add(new int[] {b,cost});
            bLink.add(new int[] {a,cost});
            link.put(a, aLink);
            link.put(b, bLink);
        }
        int totalCost = 0;
        int count = 0;
        int townRoad = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[] {1,0});
        while (!pq.isEmpty()){
            int votex = pq.peek()[0];
            int cost = pq.poll()[1];

            if (count == N) break;
            if (v[votex]) continue;

            v[votex] = true;
            totalCost += cost;
            count++;
            townRoad = Math.max(townRoad, cost);

            List<int[]> edges = link.get(votex);
            for (int[] edge : edges) {
                if (v[edge[0]]) continue;
                pq.add(edge);
            }
        }
        System.out.println(totalCost-townRoad);
    }
}