package priorityQueue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// boj 11286

/**
 * 이전 문제들과 같은 우선순위 큐
 * 그러나 절대값등 조건이 추가된 경우 new Comparator() 를 직접 구현하여 절댓값이 같은경우 음수부터, 또한 절대값 기준으로 정렬되게 priority queue 를 구성해야 한다.
 */
public class pq3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                int result = (int)Math.abs(o1) - (int) Math.abs(o2);
                if(Math.abs(o1) == Math.abs(o2)){
                    result = (int)(o1 - o2);
                }
                return result;
            }
        });

        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine().trim());
            if (tmp == 0){
                if (priorityQueue.size() == 0){
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
}
