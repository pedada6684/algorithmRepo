import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Edge>> map = new HashMap<>();
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<Edge> list = map.getOrDefault(s, new ArrayList<>());

            edgeList.add(new Edge(s,e,c));
            list.add(new Edge(s,e,c));
            map.put(s,list);

        }

        int[] money = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        long NEG = Long.MIN_VALUE / 4;
        long[] result = new long[N];
        Arrays.fill(result, NEG);
        result[S] = money[S];

        for (int i = 0; i < N-1; i++) {
            boolean updated = false;
            for (Edge edge : edgeList) {
                if(result[edge.s] == NEG) continue;

                long next = result[edge.s] - edge.c + money[edge.e];
                if(result[edge.e] < next){
                    result[edge.e] = next;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        if(result[E] == NEG){
            System.out.println("gg");
            return;
        }

        boolean haveCycle = false;
        boolean[] cycleSpot = new boolean[N];
        for (Edge edge : edgeList) {
            if(result[edge.s] == NEG) continue;
            long next = result[edge.s] - edge.c + money[edge.e];
            if(result[edge.e] < next){
                cycleSpot[edge.e] = true;
                haveCycle = true;
            }
        }

        if(haveCycle){
            haveCycle = false;
            for (int i = 0; i < cycleSpot.length; i++) {
                if (cycleSpot[i]){
                    boolean[] visit = new boolean[N];
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);

                    while (!q.isEmpty()){
                        int now = q.poll();
                        if(now == E) {
                            haveCycle = true;
                            break;
                        }
                        if(visit[now]) continue;
                        visit[now] = true;

                        List<Edge> edges = map.get(now);
                        if(edges == null) continue;
                        for (Edge edge : edges) {
                            if(visit[edge.e]) continue;
                            q.add(edge.e);
                        }
                    }
                }
            }
        }

        if(haveCycle){
            System.out.println("Gee");
        }else{
            System.out.println(result[E]);
        }
    }

    static class Edge {
        int s;
        int e;
        int c;

        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

}
