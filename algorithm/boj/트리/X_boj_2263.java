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
    public static void getPreOrder(int iOS, int iOE, int pOS, int pOE, int start){ // inOrder(start, end), postOrder(start, end), start(preOrder index)
        if(iOS <= iOE && pOS <= pOE){
            preOrder[start] = postOrder[pOE]; // 루트노드 찾아서 preOrder의 맨 처음으로 넣기

            int position = iOS;
            for (int i = iOS; i <= iOE; i++) {
                if (inOrder[i] == postOrder[pOE]){ // 이 과정을 통해 inOrderTraversal에서 루트노드 위치를 찾고, 해당 위치로 재귀탐색
                    position = i;
                    break;
                }
            }

            /**
             * 왼쪽 서브트리 탐색 ( Inorder(시작위치 그대로, 노드 -1), PostOrder(시작위치, 시작위치 + (노드위치 - Inorder 시작위치) -1), start + 1)
             * postOrder의 끝나는 위치는 왼쪽 서브트리의 크기만큼 같아야 한다
             */
            getPreOrder(iOS, position-1, pOS, pOS + position - iOS - 1, start + 1);
            /**
             * 오른쪽 서브트리 탐색 (Inorder(노드+1, 마지막 인덱스) , PostOrder(시작위치 + (노드위치 - IOS 시작위치), 마지막 인덱스 -1 (마지막 위치는 루트노드니까), start + (노드 - 시작) + 1))
             */
            getPreOrder(position + 1, iOE, pOS + (position - iOS), pOE - 1, start + position - iOS + 1);

            /* 예시
            	inOrder    = [4, 2, 5, 1, 6, 3, 7]
            	postOrder  = [4, 5, 2, 6, 7, 3, 1]

            	postOrder[6] = 1 → 루트 노드 = 1
	        inOrder에서 1의 위치 = 3
	    	왼쪽 서브트리: inOrder[0:2], postOrder[0:2]
	    	오른쪽 서브트리: inOrder[4:6], postOrder[3:5]
             */
        }
    }
}
