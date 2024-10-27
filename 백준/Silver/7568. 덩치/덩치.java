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
        int[][] man = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            man[i] = new int[]{a,b};
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < man.length; i++) {
            int count = 1;
            for (int j = 0; j < man.length; j++) {
                if (i == j) continue;
                if (man[i][0] < man[j][0] && man[i][1] < man[j][1]){
                    count++;
                }
            }
            sb.append(count+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
