package tk.mybatis.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
@Component
@ConfigurationProperties(prefix = "openapiProps")
public class OpenApiProps implements Serializable {

    private String devId;

    private String basicUrl;

    private String nonce;

    private String excelPath;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getBasicUrl() {
        return basicUrl;
    }

    public void setBasicUrl(String basicUrl) {
        this.basicUrl = basicUrl;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }
}
