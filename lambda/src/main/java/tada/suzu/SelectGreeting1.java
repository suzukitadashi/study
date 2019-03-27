package tada.suzu;

public class SelectGreeting1 {

    public static void main(String... args) {
        int myTime = Integer.parseInt("5");

        if(5 <= myTime && myTime <= 10) {
            System.out.println("おはようございます");
        } else if(11 <= myTime && myTime <= 16) {
            System.out.println("こんにちは");
        } else if(17 <= myTime && myTime <= 22) {
            System.out.println("こんばんは");
        } else {
            System.out.println("どうしたんですかこんな時間に");
        }
    }

}
