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
        int[] lec = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lec[i] = Integer.parseInt(st.nextToken());
        }
        int[] first = new int[M];
        List<Integer>[] ans = new ArrayList[N];
        List<Integer>[] rem = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ans[i] = new ArrayList<>();
            rem[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int propose = Integer.parseInt(st.nextToken());
            while (propose != -1){
                rem[i].add(propose-1);
                first[propose-1]++;
                propose = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] isFull = new boolean[M];
        for (int i = 0; i < M; i++) {
            if (lec[i] >= first[i]){
                lec[i] -= first[i];
            }else{
                isFull[i] = true;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            List<Integer> prop = rem[i];
            for (Integer p : prop) {
                if (!isFull[p]){
                    ans[i].add(p+1);
                }
            }
        }

        rem = new ArrayList[N];
        int[] second = new int[M];
        for (int i = 0; i < N; i++) {
            rem[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int propose = Integer.parseInt(st.nextToken());
            while (propose != -1){
                rem[i].add(propose-1);
                second[propose-1]++;
                propose = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            if (lec[i] >= second[i]){
                lec[i] -= second[i];
            }else{
                isFull[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            List<Integer> prop = rem[i];
            for (Integer p : prop) {
                if (!isFull[p]){
                    ans[i].add(p+1);
                }
            }
            Collections.sort(ans[i]);
            if (ans[i].isEmpty()){
                sb.append("망했어요\n");
            }else{
                for (Integer p : ans[i]) {
                    sb.append(p+" ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
