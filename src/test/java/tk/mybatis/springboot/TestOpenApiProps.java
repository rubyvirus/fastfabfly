package tk.mybatis.springboot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.springboot.model.OpenApiProps;
import tk.mybatis.springboot.util.OpenApiVariables;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class TestOpenApiProps {

    @Autowired
    private OpenApiProps openApiProps;

    @Test
    public void Test() {
        System.out.println(openApiProps.getExcelPath());
    }

    @Test
    public void TestVariables(){
        System.out.println(OpenApiVariables.openApiAllVariables.valueOf("PUBLICAREAPROVINCEPATH").getValue());
    }
}
