package tk.mybatis.springboot.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * 公共参数实体
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */
public class CommonParams extends BasicParams implements Serializable {

    private String nonce;

    private String timestamp;

    private String signature;

    private String expectValue;

    private String requestPath;

    private String requestType;

    // 初始化两个对象，list存放参数，map存放参数与值
    private Map<String, String> commonParamsMap = new TreeMap<String, String>();

    public Map<String, String> getCommonParamsMap() {
        return commonParamsMap;
    }

    public void setCommonParamsMap(Map<String, String> commonParamsMap) {
        this.commonParamsMap = commonParamsMap;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getExpectValue() {
        return expectValue;
    }

    public void setExpectValue(String expectValue) {
        this.expectValue = expectValue;
    }


}
