package tk.mybatis.springboot.model;

import org.springframework.stereotype.Component;
import tk.mybatis.springboot.util.MyBusinessParams;
import tk.mybatis.springboot.util.MyTime;

import java.io.Serializable;

/**
 * 所有业务字段
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */

@Component
public class BusinessParams implements Serializable {


    // 一级省份编码
    private String provinceCode;

    // 二级市区编码
    private String cityCode;

    // 年月日
    private String yearMonthDay;

    // 车牌
    private String plateNumber;

    // 驾图车型库车款Id
    private String modelId;

    // 行驶证车辆品牌型号
    private String carType;

    // 	1 是临时车牌 0正式车牌
    private String tplate;

    // 请传数字：89,92,95,98,0.分别代表：89号（原90汽油），92号（原93）汽油，95号（原97）汽油，98号汽油，0号柴油。
    private String gasno;

    // 车架码(车辆识别代号)
    private String vin;

    // 发动机号码
    private String ein;

    public String getProvinceCode() {
        return "110000";
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return "110100";
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getYearMonthDay() {
        return MyTime.getYearMonthDay();
    }

    public void setYearMonthDay(String yearMonthDay) {
        this.yearMonthDay = yearMonthDay;
    }

    public String getPlateNumber() {
        return MyBusinessParams.getPlateNumber();
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModelId() {
        return "1001315";
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getCarType() {
        return "120";
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getTplate() {
        return "0";
    }

    public void setTplate(String tplate) {
        this.tplate = tplate;
    }

    public String getGasno() {
        return MyBusinessParams.getGasno();
    }

    public void setGasno(String gasno) {
        this.gasno = gasno;
    }

    public String getVin() {
        return "LFV2A2150E3015723";
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEin() {
        return "LAF132220482";
    }

    public void setEin(String ein) {
        this.ein = ein;
    }
}
