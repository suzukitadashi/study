package deaf.tadashi.memo;

public class 演算子確認 {
    public static void main(String[] args) throws Exception {
        // Here your code !
        boolean a = true;
        boolean b = true;
        
        System.out.println("");
        System.out.println(a &= b);
        
        a = false;
        b = true;
        System.out.println("");
        System.out.println(a &= b);
        
        a = true;
        b = false;
        System.out.println("");
        System.out.println(a &= b);
        
        a = false;
        b = false;
        System.out.println("");
        System.out.println(a &= b);
    }
}
