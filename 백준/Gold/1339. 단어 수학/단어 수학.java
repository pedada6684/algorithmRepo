import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] score = new int[26];
        String[] command = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            command[i] = s;
            for (int j = s.length()-1; j >= 0 ; j--) {
                int idx = s.charAt(j) - 'A';
                score[idx] += Math.pow(10, s.length()-j);
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int point = score[i];
            if (point != 0){
                list.add(new int[]{i, point});
            }
        }
        Collections.sort(list, Comparator.comparingInt((int[] a) -> a[1]).reversed());
        int num = 9;
        for (int[] ints : list) {
            score[ints[0]] = num--;
        }
        int ans = 0;
        for (String s : command) {
            int res = 0;
            for (int j = s.length()-1; j >= 0 ; j--) {
                int idx = s.charAt(j) - 'A';
                res += score[idx]*Math.pow(10, s.length()-j-1);
            }
            ans += res;
        }
        System.out.println(ans);

    }
}
