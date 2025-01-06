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
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String v = st.nextToken();
            String k = st.nextToken();
            map.put(k.charAt(0),v);
        }
        String cs = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length(); i++) {
            char c = cs.charAt(i);
            sb.append(map.get(c));
        }
        String res = sb.toString();
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken())-1;
        int e = Integer.parseInt(st.nextToken());
        String substring = res.substring(s, e);
        System.out.println(substring);
    }
}
