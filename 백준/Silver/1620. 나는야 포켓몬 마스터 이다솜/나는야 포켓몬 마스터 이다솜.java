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
        int M = Integer.parseInt(st.nextToken());
        String[] sarr = new String[N+1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sarr[i+1] = st.nextToken();
            map.put(sarr[i+1], i+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            char firstChar = q.charAt(0);
            if (firstChar-'0' >= 0 && firstChar-'0' <= 9){
                sb.append(sarr[Integer.parseInt(q)]+"\n");
            }else{
                sb.append(map.get(q)+"\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
