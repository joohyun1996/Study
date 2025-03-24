package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// boj 1753
/**
 * 다익스트라 푸는 문제인줄은 알았는데, 방법이 틀렸다.
 * 1) 2차원 배열로 풀기 -> 메모리 초과
 * 2) 2차원 list로 풀기 -> 시간 초과
 * 따라서 인터넷 보고 우선순위 큐를 사용해서 풀어야 하는걸 배움
 * 이미 방문한 노드와 아닌 노드를 구별해서 각 노드별 최솟값을 구하기
 */
public class SP1 {
    static ArrayList<ArrayList<Node>> list;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine()) - 1;

        dp = new int[v+1];
        visited = new boolean[v+1];
        list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int third = Integer.parseInt(st.nextToken());

            list.get(first).add(new Node(second, third));
        }

        dp[n] = 0;
        dijkstra(n);

        for (int i = 0; i < dp.length-1; i++) {
            System.out.println((dp[i] != Integer.MAX_VALUE) ? dp[i] : "INF");
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.getVortex();

            // 이미 처리된 노드라면 무시
            if (visited[curVertex]) continue;
            visited[curVertex] = true;

            // 인접 노드 확인
            for (Node neighbor : list.get(curVertex)) {
                int nextVertex = neighbor.vortex;
                int nextWeight = neighbor.weight;

                // 더 짧은 경로 발견 시 갱신
                if (dp[nextVertex] > dp[curVertex] + nextWeight) {
                    dp[nextVertex] = dp[curVertex] + nextWeight;
                    pq.offer(new Node(nextVertex, dp[nextVertex]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        private int vortex;
        private int weight;

        public Node(int vortex, int weight) {
            this.vortex = vortex;
            this.weight = weight;
        }

        public int getVortex() {
            return vortex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getWeight(), o.getWeight());
        }
    }
}

