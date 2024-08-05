import java.util.*;
import java.io.*;

public class Main {
    static int[] sel;
    static int[] nums;
    static boolean[] v;
    static Set<String> set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();

        /*
        입력
        첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
        둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        v = new boolean[n];
        sel = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        Arrays.sort(nums);
        comb(0);

        /*
        출력
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.
         */
    }

    private static void comb(int sidx) {
        if (sidx == sel.length){
            String result = "";
            for (int i = 0; i < sel.length; i++) {
                result += sel[i]+" ";
            }
            result = result.trim();
            if (!set.contains(result)){
                System.out.println(result);
                set.add(result);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!v[i]){
                sel[sidx] = nums[i];
                v[i] = true;
                comb(sidx+1);
                v[i] = false;
            }
        }
    }
}
