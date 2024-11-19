package priorityQueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

// boj 11279

/**
 * TreeMap을 사용해서 문제를 풀었다. 왜냐하면 HashMap과 같은 조건인데, 정렬을 할 수 있기 때문
 * 하지만 PriorityQueue라는 자료구조가 자바에 있음을 몰랐다. 따라서 해당 자료구조로 다시 풀어보았다.
 * 실제로 메모리와 시간 모두 priorityQueue가 TreeMap보다 적게 사용하는것을 알 수 있었다.
 *
 * priority queue : 완전 이진 트리 (heap) - 추가/삭제 lgn
 * Tree Map : red-black tree - 노드별로 부모, 왼쪽, 오른쪽 포인터를 가짐 - 추가삭제 lgn
 */
public class pq1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            if(tmp == 0){
                if(priorityQueue.size() == 0) {
                    bw.write(0 + "\n");
                }else{
                    bw.write(priorityQueue.poll() + "\n");
                }
            }else{
                priorityQueue.add(tmp);
            }
        }

        bw.flush();
        bw.close();
    }

    /*TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            if(tmp == 0){
                if(treeMap.isEmpty()) {
                    bw.write(0 + "\n");
                }
                else {
                    int out = treeMap.lastEntry().getKey();
                    bw.write(out + "\n");
                    if(treeMap.lastEntry().getValue() > 1){
                        treeMap.put(out, treeMap.lastEntry().getValue() -1);
                    }else{
                        treeMap.remove(out);
                    }
                }
            }else{
                if(treeMap.containsKey(tmp)){
                    treeMap.put(tmp, treeMap.get(tmp)+1);
                }else{
                    treeMap.put(tmp, 1);
                }
            }
        }*/
}
