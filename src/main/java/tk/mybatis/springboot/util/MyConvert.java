package tk.mybatis.springboot.util;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-8.
 */
public class MyConvert {

    public static String getRequestURLToUnderLine(String requestURL) {
        return requestURL.substring(1).replace("/", "_");
    }

}
