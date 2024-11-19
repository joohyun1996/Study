package divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// boj 11444

/**
 * 피보나치 수열을 행렬로 어떻게 계산할 것인지 물어보는 문제.
 * 우선 피보나치 수열을 행렬로 표현하면 [[1,1],[1,0]] 의 n제곱의 형태를 가짐. 그걸 홀수이면 result의 값을 변경해서 효율적으로 거듭제곱의 곱셈을 구할 수 있게 한다.
 */
public class dc7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine().trim());
        BigInteger ans = divideConquer(n);

        System.out.println(ans);
    }

    public static BigInteger divideConquer(long n){
        if(n == 0) return BigInteger.ZERO;
        if(n == 1) return BigInteger.ONE;

        BigInteger[][] matrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] resultMatrix = matrixPow(matrix, n-1);

        return resultMatrix[0][0];
    }

    public static BigInteger[][] matrixPow(BigInteger[][] matrix, long k){
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        while(k > 0){
            if(k % 2 != 0){
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            k /= 2;
        }
        return result;
    }

    public static BigInteger[][] matrixMultiply(BigInteger[][] a, BigInteger[][] b){
        BigInteger[][] result = new BigInteger[2][2];

        result[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])).mod(BigInteger.valueOf(1000000007));
        result[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1])).mod(BigInteger.valueOf(1000000007));
        result[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])).mod(BigInteger.valueOf(1000000007));
        result[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1])).mod(BigInteger.valueOf(1000000007));

        return result;
    }
}
