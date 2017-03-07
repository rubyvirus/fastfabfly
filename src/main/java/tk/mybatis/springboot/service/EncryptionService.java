package tk.mybatis.springboot.service;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-1-24.
 */

@Service
public class EncryptionService {
    private static final String HMAC_SHA1 = "HmacSHA1";

    //排序
    public String sort(List<String> entryList, Map<String, String> map) {
        Collections.sort(entryList);
        String str = concatParameters(entryList, map);
        return str;
    }

    //拼装字符串
    private String concatParameters(List<String> entryList, Map<String, String> map) {
        System.out.println(entryList);
        System.out.println(map);
        StringBuffer sb = new StringBuffer();
        String secret = "";
        for (String str : entryList) {
            /**
             * 1、如果list内容key，在map中不存在，可能是缺少字段场景
             * 2、secret不进行字符串拼装
             */

            if (map.containsKey(str)) {
                if ("secret".equals(str)) {
                    secret = map.get(str);

                } else {
                    sb.append(str + "=" + paramEncode(map.get(str)) + "&");
                }
            }
        }
        String parameters = sb.toString();
        System.out.println(parameters);
        //secret作为签名秘钥使用
        return getSignature(parameters, secret);
    }

    public String paramEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //生成签名数据
    private static String getSignature(String data, String key) {
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            byte[] dataBytes = data.getBytes("UTF-8");

            return generateSignature(dataBytes, keyBytes);
        } catch (Exception e) {
            return null;
        }
    }

    // 对 data 以key 进行hash算法【MAC-SHA1】
    private static String generateSignature(byte[] data, byte[] key) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data);
        return getBase64Signature(rawHmac);
    }

    // 将原始二进制数据数据，进行base64编码
    private static String getBase64Signature(byte[] srcSignature) {
        byte[] base64Text = Base64.getEncoder().encode(srcSignature);
        return new String(base64Text);
    }

}
