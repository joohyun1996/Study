package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2263

/**
 * 틀린문제. 솔직히 어려웠다. post-pre-in order traversal 을 알고는 있었지만 주어진 두 순회를 가지고 나머지 하나를 찾는건 생각해 본적이 없었다.
 * postOrder의 마지막 배열의 원소 -> preOrder의 맨 처음 원소. 따라서 루트노드를 기반으로 inorder를 찾아가면서 탐색을 이어가면 된다.
 * node기반으로 왼쪽/오른쪽 재귀 탐색
 */
public class tree05 {
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preOrder = new int[postOrder.length];

        getPreOrder(0, n-1, 0, n-1, 0);

        for (int i : preOrder) {
            System.out.printf(i + " ");
        }
    }
    public static void getPreOrder(int iOS, int iOE, int pOS, int pOE, int start){
        if(iOS <= iOE && pOS <= pOE){
            preOrder[start] = postOrder[pOE];

            int position = iOS;
            for (int i = iOS; i <= iOE; i++) {
                if (inOrder[i] == postOrder[pOE]){
                    position = i;
                    break;
                }
            }

            getPreOrder(iOS, position-1, pOS, pOS + position - iOS - 1, start + 1);
            getPreOrder(position + 1, iOE, pOS + position - iOS, pOE - 1, start + position - iOS + 1);
        }
    }
}
