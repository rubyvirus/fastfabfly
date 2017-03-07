package tk.mybatis.springboot.service.impl;


import com.alibaba.fastjson.JSON;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.service.AssertService;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
@Service
public class AssertServiceImpl implements AssertService {
    @Override
    public boolean compareAllContains(String json, String expect) {
        boolean result = true;
        try {
            JSONAssert.assertEquals(expect, json, true);

        } catch (JSONException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean compareOneLevelcontains(JSON json, String match, String expect) {
        return false;
    }

    @Override
    public Boolean compareTwoLevelContains(JSON json, String match, String expect) {
        return null;
    }
}
