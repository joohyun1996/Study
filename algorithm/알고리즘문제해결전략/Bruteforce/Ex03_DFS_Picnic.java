package bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        // 전체 입력되는 경우의 수 받기
        int testCase = Integer.parseInt(str);

        for (int i = 0; i < testCase; i++) {
            str = br.readLine().trim();

            // 학생 수, 생성 가능한 짝의 수 받기
            int number = Integer.parseInt(str.split(" ")[0]);

            // 사실 쓰이지 않는다
            int pair = Integer.parseInt(str.split(" ")[1]);

            // List<Map<Integer, Integer>> 로 풀어보려 했으나 실패
            // 최대 학생수는 10명이므로 관계를 저장하는 이차원 배열을 사용하는것이 더 낫다
            boolean[][] areFriends = new boolean[10][10];

            // 모든 학생이 짝을 찾았는지 확인하는 배열
            boolean[] taken = new boolean[number];

            String[] strs = br.readLine().trim().split(" ");

            // 관계 테이블 초기화
            for (int j = 1; j < strs.length; j += 2) {
                int n = Integer.parseInt(strs[j - 1]);
                int m = Integer.parseInt(strs[j]);

                areFriends[n][m] = true;
                areFriends[m][n] = true;
            }

            int answer = countParings(taken, areFriends, number);

            System.out.println(answer);
        }
    }

    public static int countParings(boolean[] taken, boolean[][] areFriends, int num) {
        // 짝이 있는지 검사하기 위한 변수
        int firstStudent = -1;

        // 가장 먼저 짝이 없는 학생이 누구인지 확인
        for (int i = 0; i < num; i++) {
            if (!taken[i]) {
                firstStudent = i;
                break;
            }
        }

        // 전부 짝이 있다면? return 1
        if (firstStudent == -1) {
            return 1;
        }

        int ret = 0;

        // 짝이 없는 학생부터 마지막 학생까지 검사
        for (int i = firstStudent + 1; i < num; i++) {
            // 짝이 없는 학생에게 짝이 있는 경우
            // 학생과 짝에게 true 저장
            if (!taken[i] && areFriends[firstStudent][i]) {
                taken[firstStudent] = true;
                taken[i] = true;
                ret += countParings(taken, areFriends, num);
                taken[firstStudent] = false;
                taken[i] = false;
            }
        }
        return ret;
    }
}
