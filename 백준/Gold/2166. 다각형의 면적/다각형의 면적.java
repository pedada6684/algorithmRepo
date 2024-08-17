import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[][] pointArr = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointArr[i][0] = Long.parseLong(st.nextToken());
            pointArr[i][1] = Long.parseLong(st.nextToken());
        }
        Long cross = 0L;
        for (int i = 0; i+1 < N; i++) {
            cross += pointArr[i][0]*pointArr[i+1][1] - pointArr[i][1]*pointArr[i+1][0];
        }
        cross += pointArr[N-1][0]*pointArr[0][1] - pointArr[N-1][1]*pointArr[0][0];
        Double ans = Math.abs(cross)/2.0;
        System.out.println(String.format("%.1f",ans));
    }
}