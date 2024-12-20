import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> xset = new HashSet<>();
        Set<Integer> yset = new HashSet<>();
        List<int[]> xlist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'X'){
                    xset.add(i);
                    yset.add(j);
                }
            }
        }
        int xneed = N-xset.size();
        int yneed = M-yset.size();
        System.out.println(Math.max(xneed, yneed));
    }
}
