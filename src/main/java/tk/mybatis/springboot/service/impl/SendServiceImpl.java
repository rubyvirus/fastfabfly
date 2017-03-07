package tk.mybatis.springboot.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.service.SendService;
import tk.mybatis.springboot.util.MyHttp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */

@Service
public class SendServiceImpl implements SendService {
    @Override
    public String httpPost(String requestHost, String requestPath, Map<String, String> params) {
        Map<String, String> resultMap = new HashMap<String, String>();
        CloseableHttpClient closeableHttpsClient = MyHttp.createableHttpClient();
        // 拼接请求链接与参数
        URIBuilder uriBuilder = new URIBuilder();

        CloseableHttpResponse httpResponse = null;

        HttpPost httpPost = new HttpPost(requestHost + requestPath);


        return null;
    }

    /**
     * 发送Get请求
     *
     * @param requestHost
     * @param requestPath
     * @param params
     * @return 返回请求结果与URI map类型
     */
    @Override
    public Map<String, String> httpGet(String requestHost, String requestPath, Map<String, String> params) {

        Map<String, String> resultMap = new HashMap<String, String>();
        CloseableHttpClient closeableHttpsClient = MyHttp.createableHttpClient();
        // 拼接请求链接与参数
        URIBuilder uriBuilder = new URIBuilder();

        CloseableHttpResponse httpResponse = null;

        try {
            uriBuilder.setPath(requestHost + requestPath);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (!entry.getKey().equals("secret")) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpResponse = closeableHttpsClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            if (httpEntity != null) {
                resultMap.put("result", EntityUtils.toString(httpEntity, "UTF-8"));
                resultMap.put("requestURI", String.valueOf(httpGet.getURI()));
            } else {
                resultMap.put("result", "");
                resultMap.put("requestURI", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (closeableHttpsClient != null) {
                try {
                    closeableHttpsClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }
}
