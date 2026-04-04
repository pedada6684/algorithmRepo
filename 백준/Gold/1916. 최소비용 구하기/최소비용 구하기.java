import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Edge>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(s, e, d);
            List<Edge> link = map.getOrDefault(s, new ArrayList<>());
            link.add(edge);

            map.put(s,link);
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] {s, 0});

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == e){
                System.out.println(now[1]);
                return;
            }
            if(now[1] > distance[now[0]]){
                continue;
            }

            List<Edge> edgeList = map.get(now[0]);
            if(edgeList == null){
                continue;
            }

            for (Edge edge : edgeList) {
                int nd = distance[now[0]] + edge.d;
                if(nd < distance[edge.e]){
                    pq.add(new int[] {edge.e, edge.d+now[1]});
                    distance[edge.e] = nd;
                }
            }
        }
    }

    static class Edge {
        int s;
        int e;
        int d;

        public Edge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
