package tada.suzu.functiontest;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String... args) {
        Integer intg = Integer.valueOf(3);

        if (args.length > 0) {
            //TODO
            switch (args[0]) {
                case "f1":
                default:

                    intg = 5;
                    Function<Integer, Integer> twicelambda = (a) -> (a * 2);

                    System.out.println(intg + "の2倍をラムダ式で書いても" + twicelambda.apply(intg));
                    break;
                case "f2":
                    intg = 7;
                    Function<Integer, String> triple = new Function<Integer, String>() {
                        @Override
                        public String apply(Integer integer) {
                            return (integer + "の3倍は" + integer * 3);
                        }
                    };

                    System.out.println(triple.apply(intg));
                    break;
                case "bf1":
                    intg = 2;
                    BiFunction<Integer, Integer, Integer> add = (a, b) -> (a + b);
                    System.out.println(intg + "と5の和は" + add.apply(intg, 5));
                    break;
                case "bf2":
                    intg = 3;
                    BiFunction<Integer, String, String> sevenfold = (a, dscr) -> (a + dscr + a * 7);
                    System.out.println(sevenfold.apply(intg, "の7倍は"));
                    break;
                case "bn":
                    intg = 6;
                    BinaryOperator<Integer> simpleadd = (a, b) -> a + b;
                    System.out.println("2項演算子を使っても" + intg + "+7は" + simpleadd.apply(intg, 7));
                    break;
                case "csm":
                    Consumer<String> door = (name) -> System.out.println("おはいりなさい" + name + "さん");
                    door.accept("アリス");
                    break;
            }

        } else {
            Function<Integer, Integer> twice = new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer * 2;
                }
            };

            System.out.println(intg + "の2倍は" + twice.apply(intg));
        }


    }
}
