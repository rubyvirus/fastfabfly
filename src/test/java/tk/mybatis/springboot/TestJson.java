package tk.mybatis.springboot;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class TestJson {

    @Test
    public void Test() {
        String result = "{id:1,name:\"Juergen\"}";
        JSONAssert.assertEquals("{id:1}", result, false); // Pass
    }
}
