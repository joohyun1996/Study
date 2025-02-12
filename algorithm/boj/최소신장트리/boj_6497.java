package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// boj 6497

/**
 * 크루스칼 쓰는 문제, 쉽다 union-find, 정렬 사용해 n-1 까지 딸깍
 * 그런데 문제는 0 0 처리 후 printf("\n"); 안한것
 */
public class mst05 {
    static int[] parent;
    static int[] rank;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(v == 0 && e == 0){
                break;
            }

            parent = new int[v+1];
            rank = new int[v+1];
            for (int i = 0; i <= v; i++){
                parent[i] = i;
            }

            ArrayList<City> cityList = new ArrayList<>();

            double total = 0;

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());

                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                cityList.add(new City(prev, next, weight));

                total += weight;
            }

            Collections.sort(cityList);

            double ans = 0;
            int count = 0;
            for(City city : cityList){
                int prev = city.getPrev();
                int next = city.getNext();
                int weight = city.getWeight();

                if (find(prev) != find(next)) {
                    union(prev, next);
                    ans += weight;
                    count++;
                }
                if(count == v-1){
                    break;
                }
            }

            ans = Math.max(0, total - ans);

            System.out.printf("%.0f\n", ans);
        }
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

    public static class City implements Comparable<City>{
        private int prev;
        private int next;
        private int weight;

        public City(int prev, int next, int weight) {
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
        public int compareTo(City o) {
            return Integer.compare(this.getWeight(), o.getWeight());
        }
    }
}
