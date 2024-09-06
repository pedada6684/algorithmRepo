import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int count = 1;
        Queue<Long> q = new LinkedList<>();
        q.add(a);
        while (!q.isEmpty()){
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Long n = q.poll();
                if (n > b || n < a) continue;
                if (2*n == b || 10*n + 1 == b){
                    System.out.println(count);
                    return;
                }
                q.add(2*n);
                q.add(10*n + 1);

            }
        }
        System.out.println(-1);
    }
}