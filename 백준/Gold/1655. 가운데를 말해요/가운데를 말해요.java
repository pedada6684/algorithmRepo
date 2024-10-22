import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int mid = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder(mid+"\n");
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x > mid){
                right.add(x);
            }else{
                left.add(x);
            }
            if (left.size() > right.size()){
                right.add(mid);
                mid = left.poll();
            }else if (left.size()+1 < right.size()){
                left.add(mid);
                mid = right.poll();
            }
            sb.append(mid+"\n");

        }
        System.out.println(sb.toString().trim());
    }
}

