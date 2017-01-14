package cap1;

import java.util.Scanner;

/**
 * Created by user on 2017/01/14.
 */
public class Median {

    private static int med3(int a, int b, int c) {
        if(a >= b) {
            if(b >= c) {
                return b;
            } else if(a <= c) {
                return a;
            } else {
                return c;
            }
        } else if(a > c) {
            return a;
        } else if(b > c) {
            return c;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("三つの整数の中央値を求めます。");
        System.out.println("aの値：");
        int a = stdIn.nextInt();
        System.out.println("bの値：");
        int b = stdIn.nextInt();
        System.out.println("cの値：");
        int c = stdIn.nextInt();

        System.out.println("中央値は" + med3(a,b,c) + "です。");

    }

}
