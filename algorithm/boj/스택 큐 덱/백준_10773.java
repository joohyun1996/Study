package StackDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// boj 10773
public class SDQ02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> stack = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            if(tmp != 0) {
                stack.add(tmp);
            } else{
                stack.remove(stack.size()-1);
            }
        }
        System.out.println(stack.stream().reduce((a,b) -> a+b).orElse(0));
    }
}
