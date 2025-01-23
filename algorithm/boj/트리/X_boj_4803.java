package tree;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

// boj 4803

/**
 * union-find를 써서 트리가 구성될 때 사이클이 생성되는지 체크하는 문제
 * 사실 이거 그렇게 어려운 문제는 아닌데, 트리의 사이클을 구할때 |= 을 쓰는걸 처음 배웠다.
 * 굳이 저렇게 안풀어도 될 것 같긴한데...
 */
public class tree07 {
    static int[] treeArr;
    static boolean[] chkCycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;
        while(true){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = inputs[0];
            int m = inputs[1];

            if(n == 0 && m == 0){
                break;
            }

            treeArr = new int[n+1];
            chkCycle = new boolean[n+1];
            for (int i = 0; i < treeArr.length; i++) {
                treeArr[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                union(tmp[0], tmp[1]);
            }

            for (int i = 1; i < treeArr.length; i++) {
                find(i);
            }
            HashSet<Integer> ansSet = new HashSet<>();
            for (int i = 1; i < chkCycle.length; i++) {
                if(!chkCycle[treeArr[i]]){
                    ansSet.add(treeArr[i]);
                }
            }

            int ans = ansSet.size();
            if(ans == 1){
                bw.write("Case " + cnt + ": There is one tree." + "\n");
            }else if(ans == 0){
                bw.write("Case " + cnt + ": No trees." + "\n");
            }else{
                bw.write("Case " + cnt + ": A forest of " + ans + " trees." + "\n");
            }
            cnt++;
        }
        bw.flush();
        bw.close();
    }

    public static void union(int x, int y){
        int firstX = find(x);
        int firstY = find(y);

        if(firstX != firstY){
            treeArr[firstY] = firstX;
            chkCycle[firstX] |= chkCycle[firstY]; // 동작오류
        }else{
            chkCycle[firstX] = true;
        }
    }

    public static int find(int x){
        if(treeArr[x] != x){
            chkCycle[x] |= chkCycle[treeArr[x]];
            treeArr[x] = find(treeArr[x]);
        }
        return treeArr[x];
    }
}
