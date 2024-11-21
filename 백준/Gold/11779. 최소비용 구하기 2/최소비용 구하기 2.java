import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAXV = 100000*1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            List<int[]> r = map.getOrDefault(s, new ArrayList<>());
            r.add(new int[] {e,c});
            map.put(s,r);
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())-1;
        int E = Integer.parseInt(st.nextToken())-1;

        int[] dist = new int[N];
        int[] from = new int[N];
        Arrays.fill(dist, MAXV);
        Arrays.fill(from, -1);
        dist[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((a) -> a[2]));
        pq.add(new int[] {-1,S,0});
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int s = now[0];
            int e = now[1];
            int c = now[2];
            if (dist[e] < c) continue;
            dist[e] = c;
            from[e] = s;
            if (e == E) break;
            List<int[]> rel = map.get(e);
            if (rel == null) continue;
            for (int[] next : rel) {
                int ne = next[0];
                int nc = next[1];
                if (dist[ne] > dist[e]+nc){
                    pq.add(new int[] {e, ne, dist[e]+nc});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int root = E;
        Stack<Integer> path = new Stack<>();
        while (root != -1){
            path.push(root);
            root = from[root];
        }
        sb.append(dist[E]+"\n");
        sb.append(path.size()+"\n");
        while (!path.isEmpty()){
            sb.append((path.pop()+1)+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
