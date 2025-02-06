package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// boj 4386

/**
 * union-find를 사용하여 MST 풀기.
 * 특이사항은 union의 조건을 void 가 아니라 boolean으로 계산해야 한다는것
 */
public class mst03 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<Star> starList = new ArrayList<>();
        ArrayList<Node> nodeList = new ArrayList<>();

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            double[] inputs = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            starList.add(new Star(inputs[0], inputs[1]));
        }

        for (int i = 0; i < starList.size(); i++) {
            for (int j = i+1; j < starList.size(); j++) {
                if(i != j){
                    Star prev = starList.get(i);
                    Star next = starList.get(j);
                    double weight = Math.sqrt(Math.pow(next.getX() - prev.getX(), 2) + Math.pow(next.getY() - prev.getY(), 2));
                    nodeList.add(new Node(i, j, Math.round(weight * 1000) / 1000.0));
                }
            }
        }

        Collections.sort(nodeList);

        double ans = 0;
        int cnt = 0;

        for (Node node : nodeList) {
            if(union(node.getPrev(), node.getNext())){
                ans += node.getWeight();
                cnt++;
                if(cnt == n-1){
                    break;
                }
            }
        }

        System.out.printf("%.2f\n", ans);
    }

    public static int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }

    public static class Node implements Comparable<Node> {
        private int prev;
        private int next;
        private double weight;

        public Node(int prev, int next, double weight) {
            this.prev = prev;
            this.next = next;
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
        public int compareTo(Node n) {
            return Double.compare(this.weight, n.weight);
        }
    }

    public static class Star{
        private double x;
        private double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
