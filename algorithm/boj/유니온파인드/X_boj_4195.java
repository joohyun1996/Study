package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// boj 4195
public class uf3 {
    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine().trim());
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int j = 0; j < m; j++) {
                String[] strs = br.readLine().split(" ");
                String a = strs[0];
                String b = strs[1];

                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    size.put(a, 1);
                }
                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    size.put(b, 1);
                }

                int networkSize = union(a, b);
                System.out.println(networkSize);
            }
        }
    }

    public static String findParent(String x) {
        if (!x.equals(parent.get(x))) {
            parent.put(x, findParent(parent.get(x)));
        }
        return parent.get(x);
    }

    public static int union(String x, String y) {
        String rootX = findParent(x);
        String rootY = findParent(y);

        if (!rootX.equals(rootY)) {
            // 항상 더 작은 네트워크를 큰 네트워크에 합침
            if (size.get(rootX) < size.get(rootY)) {
                parent.put(rootX, rootY);
                size.put(rootY, size.get(rootY) + size.get(rootX));
            } else {
                parent.put(rootY, rootX);
                size.put(rootX, size.get(rootX) + size.get(rootY));
            }
        }

        return Math.max(size.get(rootX), size.get(rootY));
    }
}
    /*static HashMap<String, Integer> friendsMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m;

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine().trim());
            friendsMap = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String[] strs = br.readLine().split(" ");

                if(!(friendsMap.containsKey(strs[0]) || friendsMap.containsKey(strs[1]))){
                    friendsMap.put(strs[0], j*2);
                    friendsMap.put(strs[1], j*2+1);
                }else if(friendsMap.containsKey(strs[0]) && friendsMap.containsKey(strs[1])){
                    continue;
                }else{
                    if(friendsMap.containsKey(strs[0])){
                        friendsMap.put(strs[1], j*2+1);
                    }else{
                        friendsMap.put(strs[0], j*2);
                    }
                }
                int first = union(strs[0], strs[1]);
                System.out.println(Collections.frequency(friendsMap.values(), first));
            }
        }
    }
    public static int union(String x, String y){
        int first = findParent(x);
        int second = findParent(y);

        if (first != second) {
            for (Map.Entry<String, Integer> entry : friendsMap.entrySet()) {
                if(entry.getValue() == second){
                    friendsMap.put(entry.getKey(), first);
                }
            }
        }

        return first;
    }

    public static int findParent(String x){
        int parent = friendsMap.get(x);

        if(parent == friendsMap.get(x)){
            return parent;
        }

        int root = findParent(friendsMap.get(parent).toString());
        friendsMap.put(x, root);

        return root;
    }*/
