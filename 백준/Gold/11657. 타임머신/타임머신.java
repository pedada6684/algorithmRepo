import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long MAXV = 6000L*1000*500;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        long[] distance = new long[N+1];
        Arrays.fill(distance, MAXV);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s,e,d));
        }
        distance[1] = 0L;
        for (int i = 0; i < N; i++) {
            for (Edge edge : edges) {
                if (distance[edge.s] == MAXV) continue;
                if (distance[edge.e] > distance[edge.s] + edge.d){
                    if (i == N-1) {
                        System.out.println(-1);
                        return;
                    }
                    distance[edge.e] = distance[edge.s] + edge.d;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            if (distance[i] == MAXV) distance[i] = -1;
            sb.append(distance[i]+"\n");
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
