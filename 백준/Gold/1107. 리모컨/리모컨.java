import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] remote;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        remote = new boolean[10];
        Arrays.fill(remote, true);
        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                remote[Integer.parseInt(st.nextToken())] = false;
            }
        }

        int cnt = 0;

        if (M != 10) {
            int up = N;
            int down = N;
            while (!checkAns(up) && !checkAns(down)) {
                cnt++;
                up++;
                if (down > 0) {
                    down--;
                }
            }
            cnt += checkAns(down) ? (down+"").length() : (up+"").length();
        }else{
            cnt = Math.abs(N-100);
        }

        //위 아래로 내려가면서 금지수가 있는지 카운트
        //위
        //아래
        //아래에서는 0이하로는 안내려가 가게 체크

        //100과 비교
        cnt = Math.min(Math.abs(N-100), cnt);
        System.out.println(cnt);
    }

    private static boolean checkAns(int now){
        String nowS = now +"";
        for (char c : nowS.toCharArray()) {
            int n = c-'0';
            if(!remote[n]){
                return false;
            }
        }
        return true;
    }
}
