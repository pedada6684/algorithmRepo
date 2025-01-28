import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Integer c = map.getOrDefault(s, 0);
            map.put(s,c+1);
        }
        List<String[]> list = new ArrayList<>();
        for (String s : map.keySet()) {
            Integer c = map.get(s);
            list.add(new String[] {s,c.toString()});
        }
        list.sort(Comparator
                        .comparing((String[] arr)-> Integer.parseInt(arr[1]), Comparator.reverseOrder())
                        .thenComparing(arr -> arr[0])
        );
        System.out.println(list.get(0)[0]);
    }
}
