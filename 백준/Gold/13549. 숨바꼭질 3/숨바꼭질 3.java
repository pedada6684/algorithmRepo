import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            return;
        }
        int[] map = new int [100001];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[N] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        que: while (!q.isEmpty()){
            int now = q.poll();
            int nowTime = map[now];

            List<Integer> tell = new ArrayList<>();
            tell.add(now);
            if (3*K/2 >= now && now != 0){
                while (now <= 2*K && now <= 100000){
                    if (map[now] != Integer.MAX_VALUE){
                        now *= 2;
                        continue;
                    }
                    map[now] = nowTime;
                    tell.add(now);
                    now *= 2;
                }
            }

            for (Integer position: tell) {
                if (position == K){
                    break que;
                }
                if (position - 1 >= 0 && map[position-1] == Integer.MAX_VALUE){
                    map[position-1] = map[position]+1;
                    q.add(position-1);
                }
                if (position < K){
                    if (position + 1 >= 0 && map[position+1] == Integer.MAX_VALUE){
                        map[position+1] = map[position]+1;
                        q.add(position+1);
                    }
                }
            }
        }
        System.out.println(map[K]);
    }
}
