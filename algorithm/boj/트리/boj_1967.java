package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// boj 1967

/**
 * 트리의 지름을 구하는 문제로 이전문제랑 뭐가 다른지 잘 모르겠다.
 * 거의 비슷한 문제인 것 같다.
 */
public class tree03 {
    static boolean chk[];
    static ArrayList<ArrayList<Node>> nodeList;
    static int maxWeight = 0;
    static int maxDist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        chk = new boolean[n+1];
        nodeList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            nodeList.get(inputs[0]).add(new Node(inputs[1], inputs[2]));
            nodeList.get(inputs[1]).add(new Node(inputs[0], inputs[2]));
        }

        dfs(1, 0);

        Arrays.fill(chk,false);

        dfs(maxDist, 0);
        System.out.println(maxWeight);
    }

    public static void dfs(int start, int weight){
        chk[start] = true;

        if(weight > maxWeight){
            maxWeight = weight;
            maxDist = start;
        }

        ArrayList<Node> tmpList = nodeList.get(start);
        for (Node node : tmpList) {
            int tmpVortex = node.getVortex();
            int tmpWeight = node.getWeight();

            if(!chk[tmpVortex]){
                chk[tmpVortex] = true;
                dfs(tmpVortex, weight + tmpWeight);
            }
        }
    }

    public static class Node{
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
    }
}
