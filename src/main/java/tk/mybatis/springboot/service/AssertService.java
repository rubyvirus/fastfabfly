package tk.mybatis.springboot.service;

import com.alibaba.fastjson.JSON;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
public interface AssertService {

    // 全匹配
    public boolean compareAllContains(String json, String expect);

    // 获取一级内容
    public boolean compareOneLevelcontains(JSON json, String match, String expect);

    // 获取二级内容
    public Boolean compareTwoLevelContains(JSON json, String match, String expect);
}
