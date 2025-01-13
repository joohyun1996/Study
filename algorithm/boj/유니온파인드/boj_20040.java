package unionFind;

// boj 20040

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 20040
/**
 * 기존의 union-find를 사용해서 사이클이 만들어지면 해당 위치를 return 하는 문제
 * 오히려 생각할 내용이 적었다. 그저 입력받은 두개의 변수가 기존에 입력되었는지만 확인하면 되기 때문이다.
 */
public class uf4 {
    static int[] arr;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];

        arr = new int[n];
        size = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(union(tmp[0], tmp[1])){
                System.out.println(j);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean union(int a, int b){
        int rootA = parent(a);
        int rootB = parent(b);

        if(rootA != rootB) {
            if (size[rootA] > size[rootB]) {
                arr[rootB] = rootA;
            } else if (size[rootB] > size[rootA]) {
                arr[rootA] = rootB;
            } else{
                arr[rootB] = rootA;
                size[rootA] += 1;
            }
        }else{
            return true;
        }

        return false;
    }

    public static int parent(int x){
        if(x != arr[x]){
            arr[x] = parent(arr[x]);
        }
        return arr[x];
    }
}

/* 최적화 전 코드
public class Main {
    static int[] arr;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];

        arr = new int[n];
        size = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            ans = union(tmp[0], tmp[1], j);
            if(ans != 0){
                System.out.println(ans);
                System.exit(0);
            }
        }
        System.out.println(ans);
    }

    public static int union(int a, int b, int start){
        int rootA = parent(a);
        int rootB = parent(b);

        if(rootA != rootB){
            if (size[rootA] >= size[rootB]) {
                if(size[rootA] == size[rootB]){
                    size[rootA] += 1;
                }
                arr[rootB] = rootA;
                parent(b);
            } else{
                arr[rootA] = rootB;
                parent(a);
            }
        }else{
            return start;
        }

        return 0;
    }

    public static int parent(int x){
        if(x != arr[x]){
            arr[x] = parent(arr[x]);
        }
        return arr[x];
    }
}

 */
