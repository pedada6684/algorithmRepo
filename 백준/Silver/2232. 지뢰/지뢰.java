import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];
        boolean[] boom = new boolean[N+2];
        boom[0] = true;
        boom[N+1] = true;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i+1] = num;
            list.add(new int[] {num, i+1});
        }
        Collections.sort(list, Comparator.comparing(a -> a[0], Collections.reverseOrder()));
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int idx = 0;
        Queue<Integer> q = new LinkedList();
        while (cnt < N && idx < list.size()){
            int pos = list.get(idx)[1];
            if (boom[pos]){
                idx++;
                continue;
            }
            ans.add(pos);
            cnt++;
            boom[pos] = true;
            if (!boom[pos-1]){
                if (arr[pos-1] < arr[pos]) {
                    q.add(pos-1);
                    boom[pos-1] = true;
                    cnt++;
                }
            }
            if (!boom[pos+1]){
                if (arr[pos+1] < arr[pos]) {
                    q.add(pos+1);
                    boom[pos+1] = true;
                    cnt++;
                }
            }
            while (!q.isEmpty()){
                Integer npos = q.poll();
                if (!boom[npos-1]){
                    if (arr[npos-1] < arr[npos]) {
                        q.add(npos-1);
                        boom[npos-1] = true;
                        cnt++;
                    }
                }
                if (!boom[npos+1]){
                    if (arr[npos+1] < arr[npos]) {
                        q.add(npos+1);
                        boom[npos+1] = true;
                        cnt++;
                    }
                }
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer a : ans) {
            sb.append(a+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
