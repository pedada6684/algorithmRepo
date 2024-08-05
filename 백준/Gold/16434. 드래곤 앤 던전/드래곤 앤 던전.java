import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> lst;
	static long mid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long a = (long)Integer.parseInt(st.nextToken());
		
		lst = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lst.add(new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())}
			);
		}
		
		long max = Long.MAX_VALUE-1;
		long min = 1;
		while (min+1 < max) {
			mid = (max+min)/2;
			if (go(a, mid)) {
				max = mid;
			}else {
				min = mid;
			}
		}
		mid = min;
		System.out.println( go(a,min) ? min : max);
	}

	private static boolean go(long a, long hp) {
		for (int[] info : lst) {
			if (info[0] == 1) { // 몬스터
				long ea = (long)info[1];	//몬스터 공격력
				long eh = (long)info[2];	//몬스터 체력
				if (eh%a == 0) {
					hp -= (eh/a -1)*ea;
				}else {
					hp -= eh/a*ea;					
				}
			}else {				// 물약
				a += (long)info[1];
				hp = Math.min(hp + (long)info[2], mid);
			}
			if (hp < 1) 
				return false;
		}
		return true;
	}
}