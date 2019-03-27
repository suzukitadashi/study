package tada.suzu;

public class SelectGreeting3 {

    public static void main(String... args) {

        Runnable morning = new Runnable() {
            @Override
            public void run() {
                System.out.println("おはようございます");
            }
        };
        Runnable afternoon = new Runnable() {
            @Override
            public void run() {
                System.out.println("こんにちは");
            }
        };
        Runnable evening = new Runnable() {
            @Override
            public void run() {
                System.out.println("こんばんは");
            }
        };
        Runnable other = new Runnable() {
            @Override
            public void run() {
                System.out.println("どうしたんですか、こんな時間に");
            }
        };


        int myTime = Integer.parseInt("24");

        SelectGreeting3 sg = new SelectGreeting3();

        if(5 <= myTime && myTime <= 10) {
            morning.run();
        } else if(11 <= myTime && myTime <= 16) {
            afternoon.run();
        } else if(17 <= myTime && myTime <= 22) {
            evening.run();
        } else {
            other.run();
        }
    }

}

