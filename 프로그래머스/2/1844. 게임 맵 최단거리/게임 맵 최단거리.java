import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] v = new boolean[n][m];
        for(int i = 0; i < maps.length ; i++){
            for(int j = 0; j < maps[0].length ; j++){
                if(maps[i][j] == 0){
                    v[i][j] = true;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int c = now[2];
            
            if(v[x][y]) continue;
            
            v[x][y] = true;
            
            if(x == n-1 && y == m-1){
                return c;
            }
            
            for(int d = 0; d <4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(0 <= nx && nx < n && 0<= ny && ny < m && maps[nx][ny] != 0 && !v[nx][ny]){
                    q.add(new int[] {nx, ny, c+1});
                }
            }
            
        }
        
        return -1;
    }
}