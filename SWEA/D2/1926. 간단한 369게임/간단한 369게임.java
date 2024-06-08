import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String[] answer = new String[T+1];
		for (int i = 0; i <= T; i++) {
			String stri = Integer.toString(i);
			if (stri.charAt(0) == '3' || stri.charAt(0) == '6' || stri.charAt(0) == '9') {
				
				if (i < 10) {
					answer[i] = "-";
				}else {
					String prians = answer[Integer.parseInt(stri.substring(1))];
					if (prians.contains("-")) {
						answer[i] = prians+"-";
					}else {
						answer[i] = "-";						
					}
				}
				
			}else {
				if (i < 10) {					
					answer[i] = Integer.toString(i);
				}else {
					String prians = answer[Integer.parseInt(stri.substring(1))];
					if (prians.contains("-")) {
						answer[i] = prians;
					}else {
						answer[i] = Integer.toString(i);						
					}
				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < answer.length; i++) {			
			sb.append(answer[i]+" ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
		return;
	}
}
