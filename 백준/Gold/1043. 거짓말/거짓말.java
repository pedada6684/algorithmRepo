import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static List<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] man = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        for (int k = 0; k < know; k++) {
            man[Integer.parseInt(st.nextToken())] = 1;
        }

        party = new List[P];
        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());
            party[p] = new ArrayList<>();

            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                party[p].add(Integer.parseInt(st.nextToken()));
            }
        }
        ans = 0;
        dfs(0, 0, man.clone());
        System.out.println(ans);
    }

    private static void dfs(int pidx, int fakeCnt, int[] man) {
        if (pidx == party.length) {
            ans = Math.max(ans, fakeCnt);
            return;
        }
        List<Integer> thisParty = party[pidx];
        String option = check(thisParty, man);
        switch (option){
            case "free":
                //거짓
                dfs(pidx+1, fakeCnt+1, tell(man, thisParty, 2));
                //진실
                dfs(pidx+1, fakeCnt, tell(man, thisParty, 1));
                break;
            case "true":
                dfs(pidx+1, fakeCnt, tell(man, thisParty, 1));
                break;
            case "fake":
                dfs(pidx+1, fakeCnt+1, tell(man, thisParty, 2));
                break;
            case "fail":
                return;
        }
    }

    private static int[] tell(int[] man, List<Integer> thisParty, int res) {
        int[] tmp = man.clone();
        for (Integer p : thisParty) {
            tmp[p] = res;
        }
        return tmp;
    }

    private static String check(List<Integer> thisParty, int[] man) {
        int t = 0;
        int f = 0;
        for (Integer p : thisParty) {
            if (man[p] == 1){
                t++;
            } else if (man[p] == 2){
                f++;
            }
        }
        if (t == 0 && f == 0) return "free";
        if (t > 0 && f == 0) return "true";
        if (t == 0 && f > 0) return "fake";
        return "fail";
    }
}