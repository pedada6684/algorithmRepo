import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);
        int s = 1;
        int e = house[N-1] - house[0];
        while (s <= e){
            int m = (s+e)/2;
            if (check(house, C, m)){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        System.out.println(e);
    }

    private static boolean check(int[] house, int C, int d) {
        int loc = house[0];
        int cnt = 1;
        for (int i = 1; i < house.length; i++) {
            if (d <= house[i]-loc){
                cnt++;
                loc = house[i];
            }
            if (cnt >= C) return true;
        }
        return false;
    }
}
