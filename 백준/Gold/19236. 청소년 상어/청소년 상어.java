import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Fish[][] mapO = new Fish[4][4];
        int[][] fishPosition = new int[17][2];
        for (int i = 0; i < mapO.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapO.length; j++) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                mapO[i][j] = new Fish(i,j,d,n);
                fishPosition[n] = new int[]{i,j};
            }
        }
        //생존 여부
        boolean[] live = new boolean[17];
        Arrays.fill(live, true);
        //상어 출발
        Fish firstFish = mapO[0][0];
        Fish shark = new Fish(0, 0, firstFish.d, 17);
        mapO[0][0] = shark;
        shark.point = firstFish.num;
        live[firstFish.num] = false;

        dfs(shark, clone(mapO), clone(fishPosition), live);
        System.out.println(ans);
    }

    private static int[][] clone(int[][] fishPosition) {
        int[][] tmp = new int[fishPosition.length][fishPosition[0].length];
        for (int i = 0; i < fishPosition.length; i++) {
            tmp[i] = fishPosition[i].clone();
        }
        return tmp;
    }

    private static void dfs(Fish shark, Fish[][] map, int[][] fishPosition, boolean[] live) {
        ans = Math.max(ans, shark.point);
        //물고기 이동 시작
        for (int i = 1; i < fishPosition.length; i++) {
            if (!live[i]) continue;
            int x = fishPosition[i][0];
            int y = fishPosition[i][1];
            Fish moveFish = map[x][y];
            int nx = x + dx[moveFish.d];
            int ny = y + dy[moveFish.d];
            while (!( 0<= nx && nx < map.length && 0<= ny && ny < map.length && map[nx][ny].num != 17)){
                moveFish.d++;
                moveFish.d %= 8;
                nx = x + dx[moveFish.d];
                ny = y + dy[moveFish.d];
            }
            Fish swapFish = map[nx][ny];
            //swap
            map[nx][ny] = moveFish;
            map[x][y] = swapFish;
            swapFish.x = x;
            swapFish.y = y;
            moveFish.x = nx;
            moveFish.y = ny;
            fishPosition[i] = new int[]{nx, ny};
            fishPosition[swapFish.num] = new int[]{x, y};
        }

        //상어 이동 시작
        int x = shark.x;
        int y = shark.y;
        int d = shark.d;
        int nx = x + dx[d];
        int ny = y + dy[d];
        while (0<= nx && nx < map.length && 0<= ny && ny < map.length){
            if (map[nx][ny].num == 0) {
                nx += dx[d];
                ny += dy[d];
                continue;
            }
            Fish killedFish = map[nx][ny];
            shark.x = nx;
            shark.y = ny;
            shark.d = killedFish.d;
            shark.point += killedFish.num;

            map[nx][ny] = shark;
            map[x][y] = Fish.deadFish(x,y);
            live[killedFish.num] = false;

            dfs(shark, clone(map), clone(fishPosition), live.clone());

            live[killedFish.num] = true;
            map[nx][ny] = killedFish;
            map[x][y] = shark;

            shark.point -= killedFish.num;
            shark.d = d;
            shark.x = x;
            shark.y = y;

            nx += dx[d];
            ny += dy[d];
        }
    }

    private static Fish[][] clone(Fish[][] mapO) {
        Fish[][] newMap = new Fish[mapO.length][mapO.length];
        for (int i = 0; i < mapO.length; i++) {
            for (int j = 0; j < mapO.length; j++) {
                newMap[i][j] = Fish.clone(mapO[i][j]);
            }
        }
        return newMap;
    }

    private static class Fish {
        int x;
        int y;
        int d;
        int num;
        int point;

        public Fish(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }
        static public Fish deadFish(int x, int y) {
            return new Fish(x, y, 0, 0);
        }

        static public Fish clone(Fish f){
            return new Fish(f.x, f.y, f.d, f.num);
        }
    }
}
/*
상어 포식
    상어 포인트 갱신
    물고기 이동
        원형 큐 활용
        큐를 새로 만들어서 넘겨준다

        큐에서 물고기 이동 (!q empty)
            map 위치에 num == 0이면 cont
            while(갈곳이 상어고 범위외) 방향 전환
            이동할 공간 (빈공간과 물고기 공간은 동일하다)
            swap
            nQ에 등록

    상어 포식은 나의 방향에서 물고기가 존재하는 곳으로 이동 ()
    포식(while)
        상어의 자리 이동
        상어의 이전 자리에는 아무것도 남기지 않는다. (더미 물고기를 만든다) num = 0; 위치; (num == 0) 을 죽음으로 생각한다
        상어 포인트 증가
        상어 방향 교체
        dfs 진행

        -복구
        상어 위치 복구
        상어가 먹은 물고기 복구
        상어 포인트 복구
        상어 방향 복구
 */
