import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        trees = new long[N];
        long max = Long.MIN_VALUE;
        long min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long height = Long.parseLong(st.nextToken());
            trees[i] = height;
            max = max < height ? height : max;
        }
        while (!(max == min || max == min +1)){
            long mid = (max+min)/2;
            long remain = cut(mid);
            //System.out.println("max mid min res: "+ max + " " + mid +" "+min +" "+remain);
            if (remain <= M){
                max = mid;
            }else{
                min = mid;
            }
        }
        if (M == cut(max)){
            System.out.println(max);
        }else {
            System.out.println(min);
        }
    }

    private static long cut(long mid) {
        long res = 0;
        for (long t : trees) {
            res += t - mid > 0 ? t - mid : 0;
        }
        return res;
    }
}
