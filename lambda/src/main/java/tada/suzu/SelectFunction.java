package tada.suzu;

public class SelectFunction {

    @FunctionalInterface
    interface MyShape {
        public void draw(int n1, int n2);
    }

    @FunctionalInterface
    interface MyBird {
        public boolean doesItSing(String voice);
    }

    public static void main(String... args) {
        Runnable r0 = () -> System.out.println("有効な関数名を指定して下さい");
        Runnable r1 = () -> System.out.println("関数r1です");
        Runnable r2 = () -> {
            String name = "ゲスト";
            if(args.length >= 2) {
                name = args[1];
            }
            System.out.println("関数r2へようこそ、" + name + "さん");
        };

        if (args.length <= 0) {
            r0.run();
        } else {
            switch (args[0]) {
                case "r1":
                    r1.run();
                    break;
                case "r2":
                    r2.run();
                    break;
                default:
                    r0.run();
                    break;

            }
        }

        MyShape myShape = (w, h) -> System.out.println("幅は" + w + "cmで、高さは" + h + "cmの長方形です");
        myShape.draw(5, 10);

        MyShape mytri = (w, h) -> System.out.println("幅は" + w + "cmで、高さは" + h + "cmの二等辺三角形です");
        mytri.draw(5, 10);

        MyBird chickin = (voice) -> voice.equals("コケコッコー");
        System.out.println(chickin.doesItSing("ホーホケキョ"));

    }
}
