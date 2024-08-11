import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minValue = Integer.MAX_VALUE;
        int[] minIdx = new int[2];

        int start = 0;
        int end = N-1;
        while (start != end){
            int value = arr[start] + arr[end];
            if (Math.abs(value) <= minValue){
                minValue = Math.abs(value);
                minIdx[0] = start;
                minIdx[1] = end;
                if (value == 0) break;
            }
            if (value > 0){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(arr[minIdx[0]] +" "+arr[minIdx[1]]);
    }
}
