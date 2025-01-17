package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// boj 1991

/**
 * 사실 노드 클래스 만들고 푸는게 편하다. 생성자 3개 써서 만들면 된다.
 * 그런데 그냥 안쓰고 풀어보고 싶었음, 쓰는게 더 편했을지도?
 */
public class tree04 {
    static ArrayList<ArrayList<Integer>> treeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        treeList = new ArrayList<>();
        for (int i = 0; i <= 26; i++) {
            treeList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");

            int first = (int) inputs[0].charAt(0) - 64;
            int second = (int) inputs[1].charAt(0) - 64;
            int third = (int) inputs[2].charAt(0) - 64;

            treeList.get(first).add(second);
            treeList.get(first).add(third);

        }

        preOrderTraversal(1);
        System.out.println();
        inOrderTraversal(1);
        System.out.println();
        postOrderTraversal(1);
    }

    public static void postOrderTraversal(int start) {
        ArrayList<Integer> tmpList = treeList.get(start);

        int first = tmpList.get(0);
        int second = tmpList.get(1);

        if(first != -18) {
            postOrderTraversal(first);
        }
        if(second != -18){
            postOrderTraversal(second);
        }
        System.out.printf((char) (start + 64) + "");
    }

    public static void preOrderTraversal(int start) {
        ArrayList<Integer> tmpList = treeList.get(start);

        int first = tmpList.get(0);
        int second = tmpList.get(1);

        System.out.printf((char) (start + 64) + "");
        if(first != -18) {
            preOrderTraversal(first);
        }
        if(second != -18){
            preOrderTraversal(second);
        }
    }

    public static void inOrderTraversal(int start) {
        ArrayList<Integer> tmpList = treeList.get(start);

        int first = tmpList.get(0);
        int second = tmpList.get(1);

        if(first != -18) {
            inOrderTraversal(first);
        }
        System.out.printf((char) (start + 64) + "");
        if(second != -18){
            inOrderTraversal(second);
        }
    }
}
