package tk.mybatis.springboot.util;

import cn.cstonline.openapi.common3.utils.OpenStringUtils;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-6.
 */
public class MyOpenIdOpenCarId {

    public static String getMyOpenId(String userId, long devId) {
        return OpenStringUtils.generateOpenStr(userId, devId);
    }

    public static String getMyOpenCarId(String carId, long devId) {
        return OpenStringUtils.generateOpenStr(carId, devId);
    }
}
