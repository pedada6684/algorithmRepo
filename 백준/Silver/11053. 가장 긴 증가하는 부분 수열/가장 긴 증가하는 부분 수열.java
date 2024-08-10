import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dp = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int maxx = Integer.MIN_VALUE;
        input: for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (dp.isEmpty()){
                dp.add(input);
                maxx = input;
            }else{
                if (maxx < input){
                    maxx = input;
                    dp.add(input);
                    continue input;
                }
                int start = 0;
                int end = dp.size();
                while (start != end){
                    int mid = (start + end)/2;
                    if (dp.get(mid) == input){
                        continue input;
                    }else if (dp.get(mid) < input){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                dp.remove(end);
                dp.add(end, input);
                if (end == dp.size()-1){
                    maxx = input;
                }
            }
        }
//        for (int i = 0; i < dp.size(); i++) {
//            System.out.print(dp.get(i)+" ");
//        }
//        System.out.println();
        System.out.println(dp.size());
    }
}
