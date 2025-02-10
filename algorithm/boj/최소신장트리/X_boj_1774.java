package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// boj 1774

/**
 * 애매하게 크루스칼, 유니온 파인드 쓰려다가 못썻다.
 * 모든 간선을 저장하는걸 map이 아니라 list에 해서 빠르게 처리(정렬도 되니까)
 * 그거만 알면 될것 같다.
 */
public class mst04 {
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 유니온 파인드 초기화
        parent = new int[v + 1];
        rank = new int[v + 1];
        for (int i = 1; i <= v; i++) parent[i] = i;

        // 좌표 입력받기
        double[][] coords = new double[v + 1][2];
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            coords[i][0] = Double.parseDouble(st.nextToken());
            coords[i][1] = Double.parseDouble(st.nextToken());
        }

        // 간선 리스트
        ArrayList<Edge> edges = new ArrayList<>();

        // 이미 연결된 간선 처리
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b); // 미리 유니온 처리
        }

        // 모든 정점 쌍에 대해 거리 계산하여 간선 리스트에 추가
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                double weight = Math.sqrt(Math.pow(coords[i][0] - coords[j][0], 2) +
                        Math.pow(coords[i][1] - coords[j][1], 2));
                edges.add(new Edge(i, j, weight));
            }
        }

        // 간선 가중치 기준 정렬 (크루스칼 알고리즘을 위한 정렬)
        Collections.sort(edges);

        // 크루스칼 알고리즘 실행
        double ans = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                ans += edge.weight;
                count++;
                if (count == v - 1) break; // MST 간선 개수 = V-1 이므로 종료
            }
        }

        // 결과 출력 (소수점 둘째 자리까지)
        System.out.printf("%.2f\n", ans);
    }

    // 유니온 파인드
    public static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // 간선 클래스 (Comparable 인터페이스 구현)
    static class Edge implements Comparable<Edge> {
        int a, b;
        double weight;

        public Edge(int a, int b, double weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight); // 가중치 오름차순 정렬
        }
    }
    /*static double[][] map;
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int v = inputs[0];
        int e = inputs[1];

        parent = new int[v+1];
        rank = new int[v+1];

        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        ArrayList<int[]> coordList = new ArrayList<>();
        ArrayList<Star> starList = new ArrayList<>();
        coordList.add(new int[]{});

        map = new double[v+1][v+1];
        for(int i = 0; i <= v; i++){
            for(int j = 0; j <= v; j++){
                map[i][j] = 1234567890;
            }
        }

        for (int i = 0; i < v; i++) {
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coordList.add(new int[]{coord[0], coord[1]});
        }

        for (int i = 0; i < e; i++) {
            int[] vortexes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] first = coordList.get(vortexes[0]);
            int[] second = coordList.get(vortexes[1]);

            union(vortexes[0], vortexes[1]);

            map[vortexes[0]][vortexes[1]] = 0;
            map[vortexes[1]][vortexes[0]] = 0;
        }

        for(int i = 1; i <= v; i++){
            int x = 1;
            for(int j = 1; j <= v; j++){
                if(i==j){
                    continue;
                }
                if(map[i][j] != 0){
                    map[i][j] = findWeight(coordList.get(i), coordList.get(j));
                }
                if(map[i][x] > map[i][j]){
                    x = j;
                }
            }
            starList.add(new Star(i,x,map[i][x]));
        }

        Collections.sort(starList);

        double ans = 0;

        for(Star star : starList){
            int prev = star.getPrev();
            int next = star.getNext();
            double weight = star.getWeight();

            if(parent[prev] != parent[next]){
                union(prev, next);
                ans += weight;
            }
        }

        System.out.println(ans);

    }
    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootY] > rank[rootX]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static double findWeight(int[] first, int[] second){
        double weight = Math.sqrt(Math.pow(first[0]-second[0],2) + Math.pow(first[1]-second[1],2));
        return Math.round(weight * 1000)/1000.00;
    }

    public static class Star implements Comparable<Star> {
        private int prev;
        private int next;
        private double weight;

        public Star(int prev, int next, double weight) {
            this.prev = prev;
            this.next = next;
            this.weight = weight;
        }

        public void setPrev(int prev) {
            this.prev = prev;
        }

        public void setNext(int next) {
            this.next = next;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getPrev() {
            return prev;
        }

        public int getNext() {
            return next;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Star o) {
            if (this.weight >= o.getWeight()) {
                return 1;
            } else {
                return -1;
            }
        }
    }*/
}
