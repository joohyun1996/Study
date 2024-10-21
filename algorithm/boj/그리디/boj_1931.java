package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// boj 1931

/**
 * 그리디 알고리즘의 가장 유명한 문제중 하나인 회의실 문제.
 * 끝나는 시간을 기준으로 정렬한 후, 시작하는 시간으로 다시 정렬해준다.
 * 그러면 가장 빨리 끝나는 시간을 기준으로 가장 빠르게 시작하는 시간들을 고를 수 있게 된다.
 */
public class gd2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] strs;
        List<Pair> pairList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            pairList.add(new Pair(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
        }

        Collections.sort(pairList);

        int min = pairList.get(0).getY();
        int ans = 1;

        for (int i = 1; i < pairList.size(); i++) {
            if(pairList.get(i).getX() >= min){
                min = pairList.get(i).getY();
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair>{
    private int x;
    private int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.y == o.getY()){
            return Integer.compare(this.x, o.getX());
        }
        return Integer.compare(this.y, o.getY());
    }
}
