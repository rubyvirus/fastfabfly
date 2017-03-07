package tk.mybatis.springboot;

import org.junit.Test;
import tk.mybatis.springboot.util.MyTime;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-6.
 */
public class TestGetTime {

    @Test
    public void test(){
        System.out.println(MyTime.getTime());
    }
}
