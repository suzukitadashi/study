package cap1;

/**
 * Created by user on 2017/01/14.
 */
public class Max4m {

    private static int max4(int a, int b, int c, int d) {
        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        if(d > max) {
            max = d;
        }
        return max;
    }
    public static void main(String... args) {
        System.out.println("max4(3,2,1,0) = " + max4(3,2,1,0));
        System.out.println("max4(3,2,2,1) = " + max4(3,2,2,1));
        System.out.println("max4(3,1,2,5) = " + max4(3,1,2,5));
    }

}
