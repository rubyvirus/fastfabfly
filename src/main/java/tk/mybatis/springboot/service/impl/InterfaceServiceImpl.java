package tk.mybatis.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.model.BusinessParams;
import tk.mybatis.springboot.model.CommonParams;
import tk.mybatis.springboot.model.OpenApiProps;
import tk.mybatis.springboot.service.*;
import tk.mybatis.springboot.util.MyConvert;
import tk.mybatis.springboot.util.OpenApiVariables;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 实现所有接口去调用不同场景
 * Created by rubyvirusqq@gmail.com on 2017-2-9.
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private CommonSceneService commonSceneService;

    @Autowired
    private SendService sendService;

    @Autowired
    private OpenApiProps openApiProps;

    @Autowired
    private AssertService assertService;

    @Autowired
    private BusinessParams businessParams;

    @Autowired
    private EncryptionService encryptionService;


    /**
     * @param recordService
     */
    @Override
    public void publicAreaProvince(RecordService recordService) {

        String interfaceName = "PUBLICAREAPROVINCE";

        // 获取appid,secret
        CommonParams commonParams = commonSceneService.commonNormalScene("000");

        /**
         * 处理所有公共异常场景如下：
         * 1、缺少AppId，appId错误
         * 2、有必填项缺少，校验失败
         * 3、必填项为空格
         * 4、必填项传入key不传value
         * 5、有必填项输入错误，校验失败
         * 6、签名参数错误）
         * 7、正常访问
         * 8、签名重复
         * 最后添加异常结果到excel中
         */
        this.getAbnormalRuquestValidationResult(interfaceName, OpenApiVariables.getAllFields(OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "FIELDS").getValue()), commonParams.getCommonParamsMap(), recordService);
    }

    /**
     * @param recordService
     */
    @Override
    public void publicAreaCity(RecordService recordService) {
        String interfaceName = "PUBLICAREACITY";

        // 获取appid,secret
        CommonParams commonParams = commonSceneService.commonNormalScene("000");

        // 添加业务参数
        commonParams.getCommonParamsMap().put("provinceCode", businessParams.getCityCode());

        /**
         * 处理所有公共异常场景如下：
         * 1、缺少AppId，appId错误
         * 2、有必填项缺少，校验失败
         * 3、必填项为空格
         * 4、必填项传入key不传value
         * 5、有必填项输入错误，校验失败
         * 6、签名参数错误）
         * 7、正常访问
         * 8、签名重复
         * 最后添加异常结果到excel中
         */
        this.getAbnormalRuquestValidationResult(interfaceName, OpenApiVariables.getAllFields(OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "FIELDS").getValue()), commonParams.getCommonParamsMap(), recordService);
    }

    @Override
    public void userProfileQuery(RecordService recordService) {

    }

    /**
     * 控制驾图盒子GPS加速
     *
     * @param recordService
     */
    @Override
    public void fastGPS(RecordService recordService) {

    }

    /**
     * 为指定用户添加应用
     * 需要申请，不需要授权与关联机构
     *
     * @param recordService
     */
    @Override
    public void userAppAdd(RecordService recordService) {

    }

    /**
     * 添加个人车辆
     * 需要关联机构，不需要授权与申请
     * 但是需要openId，通过授权接口初始化参数
     *
     * @param recordService
     */
    @Override
    public void carAddPersonal(RecordService recordService) {

        String interfaceName = "CARADDPERSONAL";


    }

    /**
     * 更新个人车辆
     * 需要关联机构，不需要授权与申请
     *
     * @param recordService
     */
    @Override
    public void carUpdatePersonal(RecordService recordService) {

    }

    /**
     * 添加非个人车辆
     * 需要关联机构，不需要授权与申请
     *
     * @param recordService
     */
    @Override
    public void carAddNoPersonal(RecordService recordService) {

    }

    /**
     * 更新非个人车辆
     * 需要关联机构，不需要授权与申请
     *
     * @param recordService
     */
    @Override
    public void carUpdateNoPersonal(RecordService recordService) {

    }


    /**
     * 此方法为封装抽象方法
     * 公共异常调用
     * 处理所有公共异常场景如下：
     * 1、缺少AppId，appId错误
     * 2、有必填项缺少，校验失败
     * 3、必填项为空格
     * 4、必填项传入key不传value
     * 5、有必填项输入错误，校验失败
     * 6、签名参数错误
     * 7、正常访问
     * 8、签名重复
     *
     * @param interfaceName
     * @param paramsList
     * @param paramsMap
     * @return
     */
    private void getAbnormalRuquestValidationResult(String interfaceName, List<String> paramsList, Map<String, String> paramsMap, RecordService recordService) {

        for (Map<String, String> tmpCommonScene : commonSceneService.commonScene(interfaceName, paramsMap)) {
            // 添加签名参数信息
            tmpCommonScene.put("signature", encryptionService.sort(paramsList, tmpCommonScene));
            Map<String, String> tmpTmpCommonScene = new TreeMap<>();
            for (Map.Entry<String, String> entry : tmpCommonScene.entrySet()) {
                if (paramsList.contains(entry.getKey())) {
                    tmpTmpCommonScene.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, String> httpResponse = sendService.httpGet(openApiProps.getBasicUrl(), OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "PATH").getValue(), tmpTmpCommonScene);
            // 添加实际结果
            tmpCommonScene.put("actualresult", httpResponse.get("result"));
            // 添加结果判断
            tmpCommonScene.put("verificationresult", "");
            // 请求uri
            tmpCommonScene.put("requestrui", httpResponse.get("requestURI"));
            // 添加请求path，转换为下划线名称，作为sheetname
            tmpCommonScene.put("sheetName", MyConvert.getRequestURLToUnderLine(OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "PATH").getValue()));
            recordService.doContent(tmpCommonScene);
        }

    }

}
