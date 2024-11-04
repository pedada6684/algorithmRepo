import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        for (String s : arr) {
            map.put(s,0);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                String s = st.nextToken();
                map.put(s, map.get(s)+1);
            }
        }
        List<String[]> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new String[]{key, map.get(key)+""});
        }
        Collections.sort(list, Comparator.comparingInt((String[] a)->Integer.parseInt(a[1])).reversed()
                .thenComparing(a->a[0]));
        StringBuilder sb = new StringBuilder();
        for (String[] row : list) {
            sb.append(row[0] + " "+row[1]+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
