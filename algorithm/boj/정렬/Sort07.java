package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// boj 11650

/**
 * 자바는 c++ 혹은 python과 다르게 pair 혹은 tuple이 없다
 * 있는데, Pair<> 쓰려면 import 해야한다.
 * 따라서 Pair static 클래스 만들고 main에서 처리.
 * 다만 toString()과 Comparable<Pair>을 상속받아 compareTo()를 작성해주어야 sort()가 가능해진다.
 * Collections.sort(객체) 로 정렬!
 */
public class Sort07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Pair> pairList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] str = br.readLine().split(" ");
            pairList.add(new Pair(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        Collections.sort(pairList);

        for (Pair pair : pairList) {
            System.out.println(pair.toString());
        }
    }

    public static class Pair implements Comparable<Pair> {
        int x;
        int y;
        public Pair(){}
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x) return Integer.compare(this.y, o.y);
            else return Integer.compare(this.x, o.x);
        }

        @Override
        public String toString() {
            return Integer.toString(x) + " " + Integer.toString(y);
        }
    }
}
