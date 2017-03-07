package tk.mybatis.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
public class MyTime {

    // 返回时间戳年月日时分秒
    public static String getTimeStamp() {
        Date date = new Date();
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date.getTime());
    }

    // 返回年-月-日 时-分-秒
    public static String getTime() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
    }

    // 返回年月日
    public static String getYearMonthDay() {
        Date date = new Date();
        return new SimpleDateFormat("yyyyMMdd").format(date.getTime());
    }


}
