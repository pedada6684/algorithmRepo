import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> Double.parseDouble(a)-Double.parseDouble(b) < 0? 1 : -1);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (pq.size() < 7){
                pq.add(s);
            }else if (Double.parseDouble(pq.peek())>Double.parseDouble(s)){
                pq.poll();
                pq.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[7];
        for (int i = 0; i < 7; i++) {
            ans[7-i-1] = pq.poll();
        }
        for (String an : ans) {
            sb.append(an+"\n");
        }
        System.out.println(sb.toString().trim());
    }
}
