import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String man = st.nextToken();
            String com = st.nextToken();
            if (com.equals("enter")){
                map.put(man, true);
            }else {
                map.remove(man);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
