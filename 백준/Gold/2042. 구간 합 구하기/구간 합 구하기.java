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
        int K = Integer.parseInt(st.nextToken());
        long[] nums = new long[N+1];
        long[] sums = new long[N+1];
        sums[0] = 0;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Long.parseLong(st.nextToken());
            sums[i] = sums[i-1]+nums[i];
        }
        List<Integer> change = new ArrayList<>();
        Map<Integer, Long> ochar = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1){
                int idx = Collections.binarySearch(change, b);
                if (idx < 0){
                    idx++;
                    idx *= -1;
                    change.add(idx, b);
                }
                ochar.put(b, c-nums[b]);
            }else{
                long totalo = 0;
                int idx = Collections.binarySearch(change, b);
                if (idx < 0){
                    idx++;
                    idx *= -1;
                }
                while (idx<change.size() && change.get(idx) <= c){
                    totalo += ochar.get(change.get(idx++));
                }
//                System.out.println("=========");
//                System.out.println(sums[(int)c]);
//                System.out.println(sums[b]);
//                System.out.println(totalo);
                sb.append(sums[(int)c] - sums[b-1] + totalo+"\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
