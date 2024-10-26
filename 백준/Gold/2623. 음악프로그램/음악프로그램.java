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
        int[] enterD = new int[N+1];
        enterD[0] = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> relation = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            for (int j = 1; j < K; j++) {
                int b = Integer.parseInt(st.nextToken());
                List<Integer> r = relation.getOrDefault(f, new ArrayList<>());
                r.add(b);
                relation.put(f,r);
                enterD[b]++;
                f = b;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < enterD.length; i++) {
            if (enterD[i] == 0) q.add(i);
        }
        int count = N;
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()){
            Integer s = q.poll();
            count--;
            sb.append(s+"\n");
            if (relation.get(s) == null) continue;
            for (Integer e : relation.get(s)) {
                if (enterD[e] == 0) continue;
                if (--enterD[e] == 0) q.add(e);
            }
        }
        if (count != 0){
            System.out.println(0);
        }else{
            System.out.println(sb.toString().trim());
        }
    }
}
