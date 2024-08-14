import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] nums = new long[N];
        List<Long> ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);

        long minn = Long.MAX_VALUE;
        search: for (long c : nums) {
            int start = 0;
            int end = nums.length-1;

            while (start < end){
                if (nums[start] == c) start++;
                else if (nums[end] == c) end--;
                if (!(start < end)) break;

                long res = nums[start] + nums[end] + c;

                if (Math.abs(res) < minn){
                    minn = Math.abs(res);
                    ans.clear();
                    ans.add(nums[start]);
                    ans.add(nums[end]);
                    ans.add(c);
                    if (minn == 0) break search;
                }
                if (res > 0){
                    end--;
                }else if (res < 0){
                    start++;
                }
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Long an : ans) {
            sb.append(an+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
