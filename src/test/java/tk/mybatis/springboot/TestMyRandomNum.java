package tk.mybatis.springboot;

import org.junit.Test;
import tk.mybatis.springboot.util.MyBusinessParams;
import tk.mybatis.springboot.util.MyConvert;
import tk.mybatis.springboot.util.MyRandomNum;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class TestMyRandomNum {
    @Test
    public void Test() {
        System.out.println(MyRandomNum.getRandomNum(0, 10, 6));
    }

    @Test
    public void TestSubString() {
        System.out.println("abcdefg".substring(5));
    }

    @Test
    public void TestReplace() {
        System.out.println(MyConvert.getRequestURLToUnderLine("/res/pulic/area/province"));
    }

    @Test
    public void TestPlateNumber() {
        System.out.println(MyBusinessParams.getPlateNumber());
    }
}
