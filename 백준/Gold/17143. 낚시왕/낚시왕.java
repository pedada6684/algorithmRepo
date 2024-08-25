import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};//상하우좌
	static int[] dy = {0, 0, 1, -1};
	static class Shark{
		int x, y, size, speed, dir;
		boolean alive;
		public Shark(int x, int y, int size, int speed, int dir, boolean alive) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.speed = speed;
			this.dir = dir;
			//위 아래 오른 왼
			this.alive = alive;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());//상어 개체수 
		Shark[] shlst = new Shark[N];//상어 리스트
		Shark[][] map = new Shark[R][C];//상어 맵
		
		int ans = 0;
		
		for (int i = 0; i < shlst.length; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken())-1;
			int size = Integer.parseInt(st.nextToken());
			
			//스피드 조절
			if (dir < 2) speed %= (R-1)*2;
			else speed %= (C-1)*2;
			
			shlst[i] = new Shark(x, y, size, speed, dir, true);
			map[x][y] = shlst[i];
		}
		
		for (int j = 0; j < map[0].length; j++) {//사람 이동
			
			for (int i = 0; i < map.length; i++) {//잡기
				try {
					if (map[i][j].alive) {						
						ans += map[i][j].size;
						map[i][j].alive = false;
						break;
					}
				} catch (NullPointerException e) {}//빈공간인 경우
			}
			
			//상어 이동
			map = new Shark[R][C];//맵초기화
			for (int i = 0; i < shlst.length; i++) {//상어 순회
				Shark nowS = shlst[i];
				if (!nowS.alive) continue;
				int x = nowS.x;
				int y = nowS.y;
				int d = nowS.dir;
				int cnt = nowS.speed;
				//이동후 자리 확인 하고 다시 저장
				if (d < 2) {// 상하이동
					while (cnt != 0) {
						x += dx[d];
						if (x < 0 || x == R) {//넘어가면 방향전환
							x -= dx[d];
							d = (d + 1) % 2;
							x += dx[d];
						}
						cnt--;
					}
				}else {//우좌이동
					while (cnt != 0) {
						y += dy[d];
						if (y < 0 || y == C) {
							y -= dy[d];
							d = (d + 1) % 2 + 2;
							y += dy[d];
						}
						cnt--;
					}
				}
				
				//이동 완료 후 자리 확인
				try {
					if (map[x][y].size < nowS.size) {
						map[x][y].alive = false;
						nowS.x = x;
						nowS.y = y;
						nowS.dir = d;
						map[x][y] = nowS;
					}else {
						nowS.alive = false;
					}
				} catch (NullPointerException e) {//빈자리인 경우
					nowS.x = x;
					nowS.y = y;
					nowS.dir = d;
					map[x][y] = nowS;
				}
			}
		}
		System.out.println(ans);
	}
}

