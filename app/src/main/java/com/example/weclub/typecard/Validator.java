package com.example.weclub.typecard;

import android.util.Log;

public class Validator {
    public static final byte VISA = 0;
    public static final byte MASTERCARD = 1;
    public static final byte AMEX = 2;
    public static final byte DINERS_CLUB = 3;
    public static final byte DISCOVER = 4;

    static int prefix;
    static int prefix2;
    static boolean do1 ;
    static boolean do2 ;

    public static int validate0(final String credCardNumber) {
        if (credCardNumber.length() >= 2) {
            try {
                prefix = Integer.parseInt(credCardNumber.substring(0, 2));
                do1 =true;
            } catch (Exception e){
                do1 =false;
                return 10;
            }
        }
        if (credCardNumber.length() >= 3) {
            try {
                prefix2 = Integer.parseInt(credCardNumber.substring(0, 3));
                do2 =true;
            } catch (Exception e){
                do2 =false;
                return 10;
            }
        }
        String creditCard = credCardNumber.trim();

        if ((creditCard.startsWith("4")) && creditCard.length() <= 19) {
            return VISA;
        }
        else if ( credCardNumber.length() == 0) {
            do2 =false;
            do1 =false;
            return 10;
        }
        else if (do1&&(prefix >= 51 && prefix <= 55) && creditCard.length() <= 19) {
            return MASTERCARD;
        }
        //
        else if ((creditCard.startsWith("34") || creditCard
                .startsWith("37")) && creditCard.length() <= 17) {
            return AMEX;
        } else if (((prefix2 >= 300 && prefix2 <= 305) && do2
                || creditCard.startsWith("36")
                || creditCard.startsWith("38")) && creditCard.length() <= 16 ) {
            return DINERS_CLUB;
        }
        //
        else if (creditCard.length() <= 19 && creditCard.startsWith("6011")) {
            return DISCOVER;
        }
        else {
            return 10;
        }
    }
}
