package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// boj 1167

/**
 * 트리를 사용하기 위해 dfs로 탐색하는 문제
 * 트리의 지름을 구하기 위해서는 dfs를 두번 돌려야 한다
 * 1) 1 부터 가장 멀리 있는 노드 찾기
 * 2) 가장 먼 노드에서 dfs 반복하기
 *
 * 그러면 노드의 지름을 구할 수 있다.
 * 그런데 어이없는점 10번가까이 틀렸는데 그 이유는 입력이 순차적으로 들어온다고 착각했기 때문...그런말은 어디도 없었다.
 * 그거 고치니 모든 에러 정답
 */
public class tree02 {
    static boolean[] chk;
    static ArrayList<ArrayList<Node>> nodeList;
    static int maxWeight = 0;
    static int maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        chk = new boolean[n+1];
        nodeList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < inputs.length-1; j+=2) {
                nodeList.get(inputs[0]).add(new Node(inputs[j], inputs[j+1]));
            }
        }

        dfs(1,0);

        Arrays.fill(chk, false);

        maxWeight = 0;
        dfs(maxDistance, 0);

        System.out.println(maxWeight);
    }
    public static void dfs(int start, int weight){
        chk[start] = true;
        ArrayList<Node> tmpList = nodeList.get(start);

        if(weight > maxWeight){
            maxWeight = weight;
            maxDistance = start;
        }

        for (Node node : tmpList) {
            if(!chk[node.getVortex()]){
                dfs(node.getVortex(), weight + node.getWeight());
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
