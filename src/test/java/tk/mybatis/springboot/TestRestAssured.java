package tk.mybatis.springboot;

import io.restassured.RestAssured;
import org.junit.Test;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-8.
 */
public class TestRestAssured {

    @Test
    public void Test() {
        RestAssured.get();
    }
}
