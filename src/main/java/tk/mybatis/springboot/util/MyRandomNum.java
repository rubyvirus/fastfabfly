package tk.mybatis.springboot.util;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class MyRandomNum {

    public static final String numberChar = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 随机生成字符串，利用set没有重复值
     *
     * @param min
     * @param max
     * @param n
     * @param set
     * @return
     */
    public static String getRandomNum(int min, int max, int n, HashSet<Integer> set) {
        if ((n > (max - min)) || max < min) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);
        }

        int setSize = set.size();
        return setSize < n ? getRandomNum(min, max, n - setSize, set) : set.toString();
    }

    /**
     * 随机生成字符串，双重循环
     *
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static String getRandomNum(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        StringBuilder tmpStr = new StringBuilder();
        for (int i : result) {
            tmpStr.append(i);
        }
        return tmpStr.toString();
    }

    /**
     * 随机产生一个32位的字符串
     *
     * @return
     */
    public static String getRandomAppId() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            stringBuilder.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        return stringBuilder.toString();
    }

    /**
     * 产生长度为length的随机字符串（包括字母和数字）
     *
     * @param length
     * @return
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }


}
