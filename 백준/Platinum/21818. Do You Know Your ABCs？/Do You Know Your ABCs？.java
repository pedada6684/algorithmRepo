import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/*
 * 주어진 값의 차 집합에는 항상 abc가 포함된다. 
 * 이를 활용해 abc후보군을 만들고 이중 3개를 뽑아 유효성을 검증한다.
 * */
public class Main {
	static int N, ans;
	static Set<Integer> s;
	static int[] sel, input;
	static ArrayList<Integer> abcs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringJoiner sj = new StringJoiner("\n");
		for (int tc = 0; tc < T; tc++) {
			//입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(input);

			// 두 수의 차를 보관할 set
			s = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				s.add(input[i]);
				for (int j = i+1; j < N; j++) {
					s.add(input[j] - input[i]);	
				}
			}
			abcs = new ArrayList<Integer>(s);
			
			sel = new int[3];
			ans = 0;
			
			//중복조합으로 뽑고 유효성 검증
			combNoper(0,0);
			
			sj.add(Integer.toString(ans));
		}
		System.out.println(sj);
	}
	
	private static void combNoper(int idx, int put) {
		if (put == 3) {
			//a,b,c,a+b..등을 보관하는 list
			ArrayList<Integer> sumgener = new ArrayList<Integer>();
			for (int i = 0; i < 3; i++) {
				sumgener.add(sel[i]);
				for (int j = i+1; j < 3; j++) {
					sumgener.add(sel[i]+sel[j]);
				}
			}
			sumgener.add(sel[0]+sel[1]+sel[2]);
			
			//유효성 검증 
			for (int x : input) {
				if (!sumgener.contains(x)) return;
			}
			ans++;
			return;
		}
		//comb
		for (int i = idx; i < abcs.size(); i++) {
			sel[put] = abcs.get(i);
			combNoper(i, put+1);
		}
	}
}

