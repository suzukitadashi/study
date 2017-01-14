package cap1;

/**
 * Created by user on 2017/01/14.
 */
public class Min4m {

    private static int min4(int a, int b, int c, int d) {
        int min = a;
        if(b < min) {
            min = b;
        }
        if(c < min) {
            min = c;
        }
        if(d < min) {
            min = d;
        }
        return min;
    }
    public static void main(String... args) {
        System.out.println("min4(3,2,1,0) = " + min4(3,2,1,0));
        System.out.println("min4(3,2,2,1) = " + min4(3,2,2,1));
        System.out.println("min4(3,1,2,5) = " + min4(3,1,2,5));
    }

}
