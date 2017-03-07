package tk.mybatis.springboot.util;

import java.util.Random;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-10.
 */
public class MyBusinessParams {

    private final static String gasnoChars = "89,92,95,98,0";

    private final static String firstChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final static String secondChars = "0123456789";

    private static Random math = new Random();

    public static String getPlateNumber() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(secondChars.charAt(math.nextInt(secondChars.length())));
        }
        return "渝" + firstChars.charAt(math.nextInt(firstChars.length())) + stringBuilder.toString();
    }


    public static String getGasno() {
        return gasnoChars.charAt(math.nextInt(gasnoChars.length())) + "";
    }
}
