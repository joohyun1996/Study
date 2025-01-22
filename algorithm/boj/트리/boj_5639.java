package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// boj 5639

/**
 * 전위탐색이 주어질때 후위탐색을 구할 수 있는지 물어보는 문제
 * 결국 노드를 찾고, 노드를 기준으로 큰건 오른쪽, 작은건 왼쪽이 반복된다
 * 따라서 해당 조건으로 재귀문을 걸면 쉬움
 */
public class tree06 {
    static ArrayList<Integer> treeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        treeList = new ArrayList<>();

        while((s = br.readLine()) != null && !s.isEmpty()){
            int n = Integer.parseInt(s);

            treeList.add(n);
        }

        getPostOrder(0, treeList.size()-1);
    }

    public static void getPostOrder(int start, int end){
        if(start<= end){
            int root = treeList.get(start);

            int rightRoot = start + 1; // 우측 노드 찾기위해 설정
            while(rightRoot <= end && treeList.get(rightRoot) <= root){
                rightRoot++; // 현재 노드보다 큰 값 찾기
            }

            // leftNode
            getPostOrder(start + 1, rightRoot -1);
            // rightNode
            getPostOrder(rightRoot, end);

            System.out.println(root);
        }
    }
}
