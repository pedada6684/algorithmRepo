import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
입력
입력값 배열로 변환
작업
문자열 dfs 시작
for 문을 활용한 교환 후 재귀
dfs는 교환횟수를 모두 사용하면 변경값을 숫자로 변환해 저장하고 이중 최대값을 저장함

출력
최대값 출력

 */

public class Solution {
public static int answer;
    public static int maxnum;
    public static boolean flag;

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        test: for (int tc = 1; tc <= T; tc++) {
            flag = false;
            answer = -1;
            st = new StringTokenizer(br.readLine());
            char[] charArrayO = st.nextToken().toCharArray();

            ArrayList<Character> characters = new ArrayList<>();
            for (char c: charArrayO) {
                characters.add(c);
            }
            characters.sort((a,b)-> {return b-a;});
            String maxx="";
            for (char i: characters) {
                maxx += i;
            }
            maxnum = Integer.parseInt(maxx);
            int count = Integer.parseInt(st.nextToken());
            count = count >= charArrayO.length ? charArrayO.length : count;
            dfs(count, charArrayO);
            System.out.println("#"+tc+" "+answer);
        }
    }

    private static void dfs(int count, char[] nums) {
        if (flag) return;

        StringBuilder sb = new StringBuilder();
        sb.append(nums);
        int result = Integer.parseInt(sb.toString());

        if (result == maxnum && count%2 == 0) {
            flag = true;
            count = 0;
        }
    
        if (count == 0){
            answer = Math.max(result, answer);
            return;
        }
        char[] nownums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                char tmp = nownums[i];
                nownums[i] = nownums[j];
                nownums[j] = tmp;
                dfs(count-1, nownums);
                if (flag) return;
                nownums = nums.clone();
            }
        }
    }
}