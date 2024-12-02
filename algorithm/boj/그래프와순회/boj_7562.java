package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 7562

/**
 * bfs를 써서 최소거리로 답을 구하는 문제
 * 필요한 클래스를 구현해서 사용하면 크게 어렵지는 않다.
 * 나는 절대값 최소거리가 줄어드는 경우만 탐색하려 했는데, 그렇게 하면 오답.
 * 모든 경우를 다 찾아야 한다.
 */
public class gt09 {
    static boolean[][] visited;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(br.readLine().trim());
            int[] arrStart = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arrEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            visited = new boolean[length][length];

            Pair start = new Pair(arrStart[0], arrStart[1]);
            Pair end = new Pair(arrEnd[0], arrEnd[1]);

            System.out.println(bfs(start, end, length));
        }
    }
    public static int bfs(Pair start, Pair end, int length){
        Deque<Chess> queue = new ArrayDeque<>();
        queue.add(new Chess(start, 0));

        while(!queue.isEmpty()){
            Chess chess = queue.pop();

            int x = chess.getPair().getX();
            int y = chess.getPair().getY();
            int count = chess.getCount();

            if(x == end.getX() && y == end.getY()){
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if(tmpX >= 0 && tmpX < length && tmpY >= 0 && tmpY < length && !visited[tmpX][tmpY]){
                    visited[tmpX][tmpY] = true;
                    queue.add(new Chess(new Pair(tmpX,tmpY), count+1));
                }
            }
        }
        return -1;
    }
    public static class Chess{
        private Pair pair;
        private int count;

        public Chess(Pair pair, int count) {
            this.pair = pair;
            this.count = count;
        }

        public Pair getPair() {
            return pair;
        }

        public int getCount() {
            return count;
        }
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
    }
}
