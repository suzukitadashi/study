package tada.suzu;

public class SelectGreeting2 {

    public void morning() {
        System.out.println("おはようございます");
    }

    public void afternoon() {
        System.out.println("こんにちは");
    }

    public void evening() {
        System.out.println("こんばんは");
    }

    public void other() {
        System.out.println("どうしたんですか、こんな時間に");
    }

    public static void main(String... args) {
        int myTime = Integer.parseInt("24");

        SelectGreeting2 sg = new SelectGreeting2();

        if(5 <= myTime && myTime <= 10) {
            sg.morning();
        } else if(11 <= myTime && myTime <= 16) {
            sg.afternoon();
        } else if(17 <= myTime && myTime <= 22) {
            sg.evening();
        } else {
            sg.other();
        }
    }

}

