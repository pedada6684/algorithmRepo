import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        List<Integer> alist = new ArrayList<>();
        Map<Integer, Integer> amap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i+1] = arr[i]+Integer.parseInt(st.nextToken());
            for (int j = 0; j <= i; j++) {
                int res = arr[i + 1] - arr[j];
                Integer cnt = amap.getOrDefault(res, 0);
                if (cnt == 0) alist.add(res);
                amap.put(res, cnt+1);
            }
        }
        Collections.sort(alist);

        List<Integer> blist = new ArrayList<>();
        Map<Integer, Integer> bmap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] brr = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            brr[i+1] = brr[i]+Integer.parseInt(st.nextToken());
            for (int j = 0; j <= i; j++) {
                int res = brr[i + 1] - brr[j];
                Integer cnt = bmap.getOrDefault(res, 0);
                if (cnt == 0) blist.add(res);
                bmap.put(res, cnt+1);
            }
        }
        Collections.sort(blist);

        int ai = alist.size()-1;
        int bi = 0;
        long ans = 0;
        int now = alist.get(ai)+blist.get(bi);
        while (true){
            if (now == T){
                ans += (long)amap.get(alist.get(ai))*bmap.get(blist.get(bi));
                ai--;
            } else if (now > T) {
                ai--;
            }else {
                bi++;
            }
            if (ai < 0 || bi == blist.size()) break;
            now = alist.get(ai)+blist.get(bi);
        }
        System.out.println(ans);
    }
}