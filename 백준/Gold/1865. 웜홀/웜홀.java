import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long MAXV = 500L*2700*10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        testcase: for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            long[] distance = new long[N+1];
            Arrays.fill(distance, MAXV);

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s,e,d));
                edges.add(new Edge(e,s,d));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s,e,-1*d));
            }
            distance[1] = 0;
            for (int i = 0; i < N; i++) {
                for (Edge edge : edges) {
//                    if (distance[edge.s] == MAXV) continue;
                    if (distance[edge.e] > distance[edge.s] + edge.d){
                        if (i == N-1) {
                            sb.append("YES\n");
                            continue testcase;
                        }
                        distance[edge.e] = distance[edge.s] + edge.d;
                    }
                }
            }
            sb.append("NO\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static class Edge {
        int s,e,d;

        public Edge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
