package tk.mybatis.springboot;

import org.junit.Test;
import tk.mybatis.springboot.service.RecordService;
import tk.mybatis.springboot.service.impl.RecordServiceImpl;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class TestRecordService {

    @Test
    public void Test() {
        RecordService recordService = new RecordServiceImpl("C:/test");
        Map<String, String> stringStringMap1 = new TreeMap<>();
        stringStringMap1.put("sheetName", "res_pulic");
        stringStringMap1.put("appId", "1");
        stringStringMap1.put("appId2", "12");
        stringStringMap1.put("appId3", "123");
        stringStringMap1.put("appId4", "1234");
        Map<String, String> stringStringMap3 = new TreeMap<>();
        stringStringMap3.put("sheetName", "res_pulic");
        stringStringMap3.put("appId", "6");
        stringStringMap3.put("appId2", "56");
        stringStringMap3.put("appId3", "456");
        stringStringMap3.put("appId4", "3456");
        Map<String, String> stringStringMap2 = new TreeMap<>();
        stringStringMap2.put("sheetName", "res_pulic_area");
        stringStringMap2.put("appId", "1234567");
        stringStringMap2.put("appId2", "1234567");
        stringStringMap2.put("appId3", "1234567");
        stringStringMap2.put("appId4", "1234567");


        recordService.doContent(stringStringMap3);
        recordService.doContent(stringStringMap1);
        recordService.doContent(stringStringMap2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recordService.destory();
    }
}
