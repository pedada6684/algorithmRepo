import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
//        Map<Integer, Boolean> map = new HashMap<>();
        for (int k = N-1; k >= 0; k--) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    if (arr[i] + arr[j] > arr[k]) break;
                    if (Arrays.binarySearch(arr, arr[k] - arr[i] - arr[j]) >=0){
                        System.out.println(arr[k]);
                        return;
                    }
                }
            }
        }
    }
}
