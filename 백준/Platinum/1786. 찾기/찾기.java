import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Main {
	static int[] pi;
	static char[] t,p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		t = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		pi = new int[p.length];
		getpi();
		int j = 0;
		for (int i = 0; i < t.length; i++) {
			while (j > 0 && t[i] != p[j]) {
				j = pi[j-1];
			}
			if (t[i] == p[j]) {
				if (j == p.length-1) {
					list.add(i-p.length+2);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		StringJoiner sb = new StringJoiner("\n");
		sb.add(Integer.toString(list.size()));
		for (Integer i : list) {
			sb.add(Integer.toString(i));
		}
		System.out.println(sb.toString());
	}
	
	private static void getpi() {
		int j = 0;
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
	}
}

