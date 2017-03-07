package tk.mybatis.springboot.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-9.
 */
public class OpenApiVariables {

    public enum openApiAllVariables {
        // 全国一级查询接口
        PUBLICAREAPROVINCEPATH("/res/public/area/province"),
        PUBLICAREAPROVINCEFIELDS("appId:true,secret:true,nonce:true,timestamp:true,signature:true"),
        PUBLICAREAPROVINCEDEFAULTRESULT("{\"code\":\"0\",\"message\":\"操作成功\",\"data\":{\"content\":[{\"provinceCode\":110000,\"provinceName\":\"北京\"},{\"provinceCode\":120000,\"provinceName\":\"天津\"},{\"provinceCode\":130000,\"provinceName\":\"河北省\"},{\"provinceCode\":140000,\"provinceName\":\"山西省\"},{\"provinceCode\":150000,\"provinceName\":\"内蒙古自治区\"},{\"provinceCode\":210000,\"provinceName\":\"辽宁省\"},{\"provinceCode\":220000,\"provinceName\":\"吉林省\"},{\"provinceCode\":230000,\"provinceName\":\"黑龙江省\"},{\"provinceCode\":310000,\"provinceName\":\"上海\"},{\"provinceCode\":320000,\"provinceName\":\"江苏省\"},{\"provinceCode\":330000,\"provinceName\":\"浙江省\"},{\"provinceCode\":340000,\"provinceName\":\"安徽省\"},{\"provinceCode\":350000,\"provinceName\":\"福建省\"},{\"provinceCode\":360000,\"provinceName\":\"江西省\"},{\"provinceCode\":370000,\"provinceName\":\"山东省\"},{\"provinceCode\":410000,\"provinceName\":\"河南省\"},{\"provinceCode\":420000,\"provinceName\":\"湖北省\"},{\"provinceCode\":430000,\"provinceName\":\"湖南省\"},{\"provinceCode\":440000,\"provinceName\":\"广东省\"},{\"provinceCode\":450000,\"provinceName\":\"广西壮族自治区\"},{\"provinceCode\":460000,\"provinceName\":\"海南省\"},{\"provinceCode\":500000,\"provinceName\":\"重庆\"},{\"provinceCode\":510000,\"provinceName\":\"四川省\"},{\"provinceCode\":520000,\"provinceName\":\"贵州省\"},{\"provinceCode\":530000,\"provinceName\":\"云南省\"},{\"provinceCode\":540000,\"provinceName\":\"西藏自治区\"},{\"provinceCode\":610000,\"provinceName\":\"陕西省\"},{\"provinceCode\":620000,\"provinceName\":\"甘肃省\"},{\"provinceCode\":630000,\"provinceName\":\"青海省\"},{\"provinceCode\":640000,\"provinceName\":\"宁夏回族自治区\"},{\"provinceCode\":650000,\"provinceName\":\"新疆维吾尔自治区\"}],\"amount\":31}}"),

        // 添加个人车辆接口
        CARADDPERSONALPATH("/res/car/add/personal"),
        CARADDPERSONALFIELDS("appId:true,secretxx:true,nonce:true,timestamp:true,signature:true,openId:true,plateNumber:true,modelId:false,carType:false,tplate:false,gasno:false,vin:false,ein:false"),
        CARADDPERSONALDEFAULTRESULT("{\"code\": \"0\",\"message\": \"操作成功\",\"data\": {\"openCarId\": \"00000791dc8864814b93a7c4fa2d233f084bd44b\"}}"),

        // 全国二级查询接口
        PUBLICAREACITYPATH("/res/public/area/city"),
        PUBLICAREACITYFIELDS("appId:true,secret:true,nonce:true,timestamp:true,signature:true,provinceCode:true"),
        PUBLICAREACITYDEFAULTRESULT("{\"code\": \"0\",\"message\": \"操作成功\",\"data\": {\"openCarId\": \"00000791dc8864814b93a7c4fa2d233f084bd44b\"}}");

        String value;

        openApiAllVariables(String s) {
            this.value = s;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    public static Map<String, List<String>> getFields(String[] fields) {

        Map<String, List<String>> tmpGetFieldsMap = new HashedMap();

        List<String> requiredFields = new ArrayList<String>();

        List<String> nonRequiredFields = new ArrayList<String>();

        for (String string : fields) {
            String[] tmp = string.split(":");
            if (tmp[1].equals("true")) {
                requiredFields.add(tmp[0]);
            } else {
                nonRequiredFields.add(tmp[0]);
            }
        }
        tmpGetFieldsMap.put("requiredFields", requiredFields);
        tmpGetFieldsMap.put("nonRequiredFields", nonRequiredFields);


        return tmpGetFieldsMap;
    }

    public static List<String> getAllFields(String fieldsStr) {
        List<String> allFields = new ArrayList<>();
        String[] fields = fieldsStr.split(",");
        for (String string : fields) {
            allFields.add(string.split(":")[0]);
        }
        return allFields;
    }
}
