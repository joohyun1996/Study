package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1976

/**
 * DFS 와 FIND 만을 사용해서 풀어보려다가 틀린 문제.
 * DFS를 사용해서 연결된 도시를 찾아 연결될 때 마다 find를 해주려 했다. 그런데 해당 경우에 단방향 검색만 하여 모든 연결을 처리하지 못할 수 있다.
 * 예를들어 연결이 되지않은 도시가 plans에 나오던가, 같은 도시를 다른 경로로 방문하는 경우 등
 * 따라서 Union을 사용하는게 최적화에 좋다.
 * map을 입력받을 때 마다, 두개의 도시의 parents가 다르면 강제로 두 도시를 병합한다. 해당 과정을 모든 map에 적용
 * 그리고 find연산을 통해 plan하는 도시의 부모가 첫번째 도시의 부모와 같은지, 아닌지를 비교해 출력
 */
public class uf2 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= n ; j++) {
                if(inputs[j-1] == 1){
                    union(i,j);
                }
            }
        }

        int[] plans = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean travel = true;
        int first = findParent(plans[0]);

        for (int i : plans) {
            if(findParent(i) != first){
                travel = false;
            }
        }

        System.out.println(travel ? "YES" : "NO");
    }

    public static int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y){
        int first = findParent(x);
        int second = findParent(y);

        if(first != second){
            parent[second] = first;
        }
    }

    /* 25퍼센트에서 틀린 코드.
    BFS 탐색이 틀리고 Union-Find에서 Find만 사용함

    static int[] cities;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        int[][] map = new int[n][n];
        cities = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cities[i] = i;
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    list.get(i + 1).add(j + 1);
                }
            }
        }
        dfs(1, m + 1, list);

        if (cities[find[0]] == cities[find[1]] && cities[find[1]] == cities[find[2]]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int findParent(int x) {
        if (cities[x] != x) {
            cities[x] = findParent(cities[x]);
        }
        return cities[x];
    }

    public static void dfs(int start, int end, ArrayList<ArrayList<Integer>> list) {
        if (start == end) {
            return;
        }

        ArrayList<Integer> arr = list.get(start);
        for (Integer i : arr) {
            if (!visited[i]) {
                visited[i] = true;
                cities[i] = findParent(start);
                dfs(i, end, list);
            }
        }
    }*/
}
