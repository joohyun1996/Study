package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// boj 10814
// Pair 클래스 Comparable() 상속받아서, compareTo() 직접 작성하기
public class Sort10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Pair> pairList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] str = br.readLine().split(" ");
            pairList.add(new Pair(Integer.parseInt(str[0]), str[1]));
        }

        Collections.sort(pairList);

        for (Pair pair : pairList) {
            System.out.println(pair.toString());
        }
    }
    public static class Pair implements Comparable<Pair> {
        int age;
        String name;
        public Pair(){}
        public Pair(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.age, o.age);
        }

        @Override
        public String toString() {
            return Integer.toString(age) + " " + name;
        }
    }
}
