/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deaf.tadashi.mynumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author deaf.tadashi
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {

        int digit = CheckDigit.calcCheckDigit("12345678901");
        log.info("{}のチェックディジットは{}です。", "12345678901", digit);

    }

}
