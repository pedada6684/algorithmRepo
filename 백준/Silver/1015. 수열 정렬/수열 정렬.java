import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }
        List<int[]> listc = new ArrayList<>(list);
        listc.sort(Comparator
                .comparing((int[] a) -> a[0])
                .thenComparing(a -> a[1]));
        for (int i = 0; i < N; i++) {
            int idx = listc.get(i)[1];
            list.get(idx)[1] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int[] ints : list) {
            sb.append(ints[1]+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
