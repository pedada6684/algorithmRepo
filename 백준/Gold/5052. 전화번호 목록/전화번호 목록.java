import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        test: for (int tc = 0; tc < T; tc++) {
            Set<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(st.nextToken());
            }
            Collections.sort(list);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).startsWith(list.get(i-1))){
                    sb.append("NO\n");
                    continue test;
                }
            }
            sb.append("YES\n");
        }
        System.out.println(sb.toString().trim());
    }
}