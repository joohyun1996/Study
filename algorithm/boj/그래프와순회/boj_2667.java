package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 2667

/**
 * bfs를 구현함, (x,y) 값을 한번에 넘기기 위해 Pair 클래스 생성
 * 조건문 확실히 체크
 */
public class gt07 {
    static boolean[][] chk;
    static int depth = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> ansList = new ArrayList<>();

        int[][] graph = new int[n][n];
        chk = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && !chk[i][j]){
                    chk[i][j] = true;
                    depth++;
                    ansList.add(bfs(graph, new Pair(i,j), n));
                }
            }
        }
        System.out.println(depth);
        Collections.sort(ansList);
        for (Integer i : ansList) {
            System.out.println(i);
        }
    }
    public static int bfs(int[][] graph, Pair pair, int n){
        int ans = 0;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(pair);

        while(!queue.isEmpty()){
            Pair p = queue.pop();

            int x = p.getX();
            int y = p.getY();

            graph[x][y] = depth;

            for (int k = 0; k < 4; k++) {
                int tmpX = x+dx[k];
                int tmpY = y+dy[k];

                if((tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n) && graph[tmpX][tmpY] == 1 && !chk[tmpX][tmpY]){
                   chk[tmpX][tmpY] = true;
                   queue.add(new Pair(tmpX, tmpY));
                }
            }
            ans++;
        }
        return ans;
    }

    public static class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
