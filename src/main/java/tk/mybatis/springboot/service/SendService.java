package tk.mybatis.springboot.service;

import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
public interface SendService {
    String httpPost(String requestHost, String requestPath, Map<String, String> params);

    Map<String,String> httpGet(String requestHost, String requestPath, Map<String, String> params);

}
