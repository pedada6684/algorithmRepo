import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static String ans;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        List<int[]> dotList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == '.') dotList.add(new int[] {i,j});
            }
        }
        ans = "";
        for (int[] xy : dotList) {
            int x = xy[0];
            int y = xy[1];
            boolean[] beside = new boolean[4];
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != '.'){
                    char pipe = map[nx][ny];
                    if (pipe == 'M' || pipe == 'Z' || pipe == '+'){
                        cnt++;
                        beside[d] = true;
                        continue;
                    }
                    switch (d){
                        case 0:
                            if (pipe == '|' || pipe == '1' || pipe == '4'){
                                cnt++;
                                beside[d] = true;
                            }
                            break;
                        case 1:
                            if (pipe == '-' || pipe == '3' || pipe == '4'){
                                cnt++;
                                beside[d] = true;
                            }
                            break;
                        case 2:
                            if (pipe == '|' || pipe == '2' || pipe == '3'){
                                cnt++;
                                beside[d] = true;
                            }
                            break;
                        case 3:
                            if (pipe == '-' || pipe == '1' || pipe == '2'){
                                cnt++;
                                beside[d] = true;
                            }
                            break;
                    }
                }
            }
            if (cnt >= 2){
                x++;
                y++;
                if (cnt == 2){
                    twoCheck(beside, x, y);
                } else if (cnt == 3) {
                    deleteExcept(beside, x-1,y-1);
                    twoCheck(beside, x, y);
                } else if (cnt == 4) {
                    deleteExcept(beside,x-1,y-1);
                    for (boolean b : beside) {
                        if (!b) cnt--;
                    }
                    if (cnt == 4){
                        ans += x+" "+y+" +";
                    }else{
                        twoCheck(beside, x, y);
                    }
                }
                break;
            }
        }
        System.out.println(ans);
    }

    private static void deleteExcept(boolean[] beside, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (map[nx][ny] == 'M' || map[nx][ny] == 'Z'){
                beside[d] = false;
            }
        }
    }

    private static void twoCheck(boolean[] beside, int x, int y) {
        if (beside[0] && beside[1]){
            ans += x+" "+y+" 2";
        }if (beside[0] && beside[2]){
            ans += x+" "+y+" |";
        }if (beside[0] && beside[3]){
            ans += x+" "+y+" 3";
        }if (beside[1] && beside[2]){
            ans += x+" "+y+" 1";
        }if (beside[1] && beside[3]){
            ans += x+" "+y+" -";
        }if (beside[2] && beside[3]){
            ans += x+" "+y+" 4";
        }
    }


}