import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static boolean[][] memoO;
    static boolean[][] memoE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        memoE = new boolean[N][N/2+1];
        memoO = new boolean[N][N/2+1];
        for (int mid = 0; mid < memoE.length; mid++) {
            for (int d = 0; d < memoE[0].length; d++) {
                if (mid-d < 0 || mid+d >= N) break;
                if (nums[mid+d] == nums[mid-d]){
                    memoE[mid][d] = true;
                }else{
                    break ;
                }
            }
        }

        for (int low = 0; low < memoO.length-1; low++) {
            int high = low+1;
            for (int d = 0; d < memoO[0].length; d++) {
                if (low-d < 0 || high+d >= N) break;
                if (nums[high+d] == nums[low-d]){
                    memoO[low][d] = true;
                }else{
                    break ;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken())-1;
            int E = Integer.parseInt(st.nextToken())-1;
            sb.append(isPalin(S,E) + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static int isPalin(int s, int e) {
        int mid = (s+e)/2;
        int distance = (e-s)/2;
        if ((e-s)%2 == 0){ // 123
            return memoE[mid][distance]? 1:0;
        }else {
            return memoO[mid][distance]? 1:0;
        }
    }
}