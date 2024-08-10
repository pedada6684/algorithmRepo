import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();

        for (int input : A) {
            if (dp.isEmpty() || dp.get(dp.size() - 1) < input) {
                dp.add(input);
            } else {
                int start = 0;
                int end = dp.size();
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (dp.get(mid) < input) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                dp.set(end, input);
            }
        }

        System.out.println(dp.size());
    }
}