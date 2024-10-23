import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int maxv = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dist = new int[N];
        Map<Integer, List<int[]>> relation = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            List<int[]> sr = relation.getOrDefault(s, new ArrayList<>());
            List<int[]> er = relation.getOrDefault(e, new ArrayList<>());
            sr.add(new int[]{e,w});
            er.add(new int[]{s,w});
            relation.put(s,sr);
            relation.put(e,er);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        dist[start] = maxv;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        pq.add(new int[]{start, maxv});
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int s = now[0];
            int w = now[1];
            if (s == end){
                System.out.println(w);
                return;
            }
            if (relation.get(s) == null) continue;
            for (int[] e : relation.get(s)) {
                int minW = Math.min(w, e[1]);
                if (dist[e[0]] < minW){
                    dist[e[0]] = minW;
                    pq.add(new int[]{e[0], minW});
                }
            }
        }
        System.out.println(-1);
    }
}
/*
3 3
1 2 2
3 1 3
2 3 2
1 3



3
 */