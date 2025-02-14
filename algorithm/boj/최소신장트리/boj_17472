package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 17472

/**
 * 삼성 A형 기출문제
 * bfs, Union-Find를 같이 사용하는 문제. 따로생각하면 쉬운데 시험장에서 풀려햇으면 시간초과 났을거 같다.
 * 섬이 연결되지 않는 경우도 고려해야하는데, 그건 못했다. gpt로 물어봄
 * 그래서 Sout부분에서 MST가 연결된 부분만 ans 출력. 아니면 -1 출력
 */
public class mst06 {
    static int[][] map;
    static int[][] islandMap;
    static boolean[][] chk;
    static int[] parent;
    static int[] rank;
    static int cnt = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Island> islandList;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        islandList = new ArrayList<>();
        edgeList = new ArrayList<>();

        map = new int[n][m];
        islandMap = new int[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    if(!chk[i][j]){
                        cnt++;
                        bfs(new int[]{i,j}, n, m);
                    }
                }
            }
        }

        parent = new int[cnt+1];
        rank = new int[cnt+1];

        for (int i = 0; i <= cnt; i++) {
            parent[i] = i;
        }

        findNearIsland(n,m);
        Collections.sort(edgeList);

        int ans = 0;
        int ansCount = 0;
        for (Edge edge : edgeList) {
            int prev = edge.getPrevIsland();
            int next = edge.getNextIsland();

            if(find(prev) != find(next)){
                union(prev, next);
                ans += edge.getWeight();
                ansCount++;
            }

            if(ansCount == cnt-1){
                break;
            }
        }

        System.out.println((ansCount != cnt-1) ? -1 : ans);
    }

    public static void union(int prev, int next){
        int rootPrev = find(prev);
        int rootNext = find(next);

        if(rootPrev != rootNext) {
            if (rank[rootPrev] > rank[rootNext]) {
                parent[rootNext] = rootPrev;
            } else if (rank[rootPrev] < rank[rootNext]) {
                parent[rootPrev] = rootNext;
            } else {
                parent[rootNext] = rootPrev;
                rank[rootPrev]++;
            }
        }
    }
    public static int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void findNearIsland(int xSize, int ySize){
        for(Island island : islandList){
            int x = island.getX();
            int y = island.getY();
            int islandNumber = island.getIslandNumber();

            for(int i = 0; i < 4; i++){
                int distance = 0;
                int tmpX = x;
                int tmpY = y;

                while(true){
                    distance += 1;
                    tmpX += dx[i];
                    tmpY += dy[i];
                    if(tmpX >= 0 && tmpX < xSize && tmpY >= 0 && tmpY < ySize){
                        if(islandMap[tmpX][tmpY] == islandNumber){
                            break;
                        }else{
                            if(islandMap[tmpX][tmpY] == 0){
                                continue;
                            }
                            if(distance > 2 && !edgeList.contains(new Edge(islandNumber, islandMap[tmpX][tmpY], distance-1)) && !edgeList.contains(new Edge(islandMap[tmpX][tmpY], islandNumber, distance-1))){
                                edgeList.add(new Edge(islandNumber, islandMap[tmpX][tmpY], distance-1));
                                break;
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
        }
    }

    public static void bfs(int[] start, int xSize, int ySize){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1]});

        while(!queue.isEmpty()){
            int[] tmp = queue.pollFirst();
            int x = tmp[0];
            int y = tmp[1];

            islandMap[x][y] = cnt;
            if(!chk[x][y]){
                islandList.add(new Island(x, y, cnt));
            }
            chk[x][y] = true;

            for(int i = 0; i < 4; i++){
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if(tmpX >= 0 && tmpX < xSize && tmpY >= 0 && tmpY < ySize && !chk[tmpX][tmpY] && map[tmpX][tmpY] == 1){
                    queue.add(new int[]{tmpX, tmpY});
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge>{
        private int prevIsland;
        private int nextIsland;
        private int weight;

        public Edge(int prevIsland, int nextIsland, int weight) {
            this.prevIsland = prevIsland;
            this.nextIsland = nextIsland;
            this.weight = weight;
        }

        public int getPrevIsland() {
            return prevIsland;
        }

        public int getNextIsland() {
            return nextIsland;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return prevIsland == edge.prevIsland && nextIsland == edge.nextIsland && weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(prevIsland, nextIsland, weight);
        }
    }

    public static class Island{
        private int x;
        private int y;
        private int islandNumber;

        public Island(int x, int y, int islandNumber) {
            this.x = x;
            this.y = y;
            this.islandNumber = islandNumber;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getIslandNumber() {
            return islandNumber;
        }
    }
}
