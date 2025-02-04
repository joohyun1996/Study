package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// boj 1197.java

/**
 * Union-Find 써야 할 것 같긴 했는데, 안쓰고 풀려다가 포기하고 걍 씀
 * Rank를 사용해야 하는 Union-Find
 */
public class mst02 {
    static int[] rank;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;

        rank = new int[inputs[0] + 1];
        parent = new int[inputs[0] + 1];

        for (int i = 0; i < inputs[0]+1; i++) {
            parent[i] = i;
        }

        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < inputs[1]; i++) {
            int[] tmps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            nodeList.add(new Node(tmps[0], tmps[1], tmps[2]));
        }

        Collections.sort(nodeList);

        for (Node node : nodeList) {
            if(find(node.getPrev()) != find(node.getNext())){
                union(node.getPrev(), node.getNext());
                ans += node.getWeight();
            }
        }

        System.out.println(ans);
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
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

    public static class Node implements Comparable<Node> {
        private int prev;
        private int next;
        private int weight;

        public Node(int prev, int next, int weight) {
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

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
