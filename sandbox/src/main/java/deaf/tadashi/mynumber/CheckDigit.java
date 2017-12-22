package deaf.tadashi.mynumber;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * マイナンバーのチェックディジットを求める。
 *
 * @author deaf.tadashi
 */
public class CheckDigit {

    public static int calcCheckDigit(String mynumber) {

        // オードソックスな引数チェック
        if (mynumber == null) {
            throw new IllegalArgumentException("引数にnullは指定不可");
        }

        if (mynumber.length() != 11) {
            throw new IllegalArgumentException("引数は11桁必須");
        }

        if (!NumberUtils.isNumber(mynumber)) {
            throw new IllegalArgumentException("引数は数値必須");
        }

        char[] mynumberArgs = mynumber.toCharArray();
        int[] calcResultArgs = new int[11];
        for (int i = 0; i < mynumberArgs.length; i++) {
            calcResultArgs[i] = calc(mynumberArgs[(11 - 1) - i], (i + 1));
        }

        // n=1からn=11までのPn，Qn，Pn×Qnを計算
        int calcTotal = 0;
        for (int val : calcResultArgs) {
            calcTotal += val;
        }

        // 求めた和を11で割ったあまりを求める。
        int amari = calcTotal % 11;

        // 11-(11で割ったあまり)がチェックディジット
        int digit = 11 - amari;

        return digit;

    }

    //計算する。
    private static int calc(char c, int n) {

        int i = Character.getNumericValue(c);

        if (n >= 1 && n < 7) {
            return i * (n + 1);
        } else {
            return i * (n - 5);
        }

    }

}
