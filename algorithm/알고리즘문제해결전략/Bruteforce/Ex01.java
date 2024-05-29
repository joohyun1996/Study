package ex01;

import java.util.Timer;

public class Ex01 {
    public static long N_PARENT, TOTAL_PARENT;
    public static void main(String[] args) {
        long startTime, endTime;

        System.out.println("배열함수 시간 확인하기");
        startTime = System.nanoTime();
        System.out.println(sumArray(100000));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000 + " : milisec ");
        System.out.println();

        System.out.println("재귀함수 시간 확인하기");
        startTime = System.nanoTime();
        System.out.println(sumRecursive(100000));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000 + " : milisec ");
        System.out.println();

        System.out.println("꼬리 재귀함수 시간 확인하기");
        startTime = System.nanoTime();
        System.out.println(sumRecursiveTail(100000, 0));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000 + " : milisec ");

        // 가비지 콜렉터가 돌아가는 타이밍에 따라서 스택 오버플로우가 나는 경우, 안나는 경우가 있다.
        // vm options에서 -Xss200m 하면 돌아가는데, 이는 200mb의 스택크기를 사용하는 것
    }

    public static int sumArray(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += i;
        }
        return ret;
    }

    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    public static int sumRecursiveTail(int n, int total) {
        N_PARENT = n;
        TOTAL_PARENT = total;
        if (n == 0) return total;
        return sumRecursiveTail(n - 1, total + n);
    }
}


