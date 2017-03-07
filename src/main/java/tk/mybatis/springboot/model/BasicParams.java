package tk.mybatis.springboot.model;

import java.io.Serializable;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-6.
 */
public class BasicParams implements Serializable {

    private String appId;

    private String secret;

    private String userId;

    private String carId;

    public BasicParams() {

    }


    public BasicParams(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    public BasicParams(String appId, String secret, String carId, String userId) {
        this.appId = appId;
        this.secret = secret;
        this.carId = carId;
        this.userId = userId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
