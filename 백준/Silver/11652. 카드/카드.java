import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<Long, Integer> map = new HashMap<>();
        long ans = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            map.put(a, map.getOrDefault(a, 0)+1);
            if (max == map.get(a)){
                ans = Math.min(ans, a);
            }else if (max < map.get(a)){
                ans = a;
                max = map.get(a);
            }
        }
        System.out.println(ans);
    }
}
