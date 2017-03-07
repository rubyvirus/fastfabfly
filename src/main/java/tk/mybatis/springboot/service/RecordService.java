package tk.mybatis.springboot.service;

import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public interface RecordService {

    void doContent(Map<String, String> content);

    void destory();

}
