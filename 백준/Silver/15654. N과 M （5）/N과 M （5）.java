import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static int[] sel;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        sel = new int[M];
        comb(0,0);
        System.out.println(sb.toString().trim());
    }

    private static void comb(int sidx, int pidx) {
        if (sidx == sel.length){
            for (int i : sel) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!v[i]){
                sel[sidx] = list.get(i);
                v[i] = true;
                comb(sidx+1, i);
                v[i] = false;
            }
        }
    }
}
