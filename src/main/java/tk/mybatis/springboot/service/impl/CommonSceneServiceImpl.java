package tk.mybatis.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.model.CommonParams;
import tk.mybatis.springboot.service.CommonSceneService;
import tk.mybatis.springboot.service.DataService;
import tk.mybatis.springboot.service.EncryptionService;
import tk.mybatis.springboot.util.MyMapList;
import tk.mybatis.springboot.util.MyRandomNum;
import tk.mybatis.springboot.util.OpenApiVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-9.
 */
@Service
public class CommonSceneServiceImpl implements CommonSceneService {

    @Autowired
    private DataService dataService;

    @Autowired
    private EncryptionService encryptionService;

    @Override
    public Map<String, String> normalAccess(String interfaceName, Map<String, String> repeatSignatureMap) {
        Map<String, String> tmpNormalAccess = MyMapList.copyMap(repeatSignatureMap);
        tmpNormalAccess.put("expectresult", OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "DEFAULTRESULT").getValue());
        tmpNormalAccess.put("notes", "正常访问场景");
        return tmpNormalAccess;
    }

    @Override
    public CommonParams commonNormalScene(String isAuthOrganizationApplication) {
        CommonParams commonParams = getCommonParams(isAuthOrganizationApplication);
        return commonParams;
    }

    /**
     * 缺少appId异常场景
     *
     * @param missingFieldMap
     * @return
     */
    @Override
    public Map<String, String> missingAppIdFieldScene(Map<String, String> missingFieldMap) {
        Map<String, String> tmpMissingAppIdFieldSceneMap = MyMapList.copyMap(missingFieldMap);
        tmpMissingAppIdFieldSceneMap.remove("appId");
        tmpMissingAppIdFieldSceneMap.put("expectresult", "");
        tmpMissingAppIdFieldSceneMap.put("notes", "缺少appId异常场景");
        return tmpMissingAppIdFieldSceneMap;
    }


    /**
     * 错误的appId异常场景
     *
     * @param errorFieldMap
     * @return
     */
    @Override
    public Map<String, String> errorAppIdContentScene(Map<String, String> errorFieldMap) {
        Map<String, String> tmpErrorAppIdContentSceneMap = MyMapList.copyMap(errorFieldMap);
        tmpErrorAppIdContentSceneMap.put("appId", MyRandomNum.getRandomAppId());
        tmpErrorAppIdContentSceneMap.put("expectresult", "");
        tmpErrorAppIdContentSceneMap.put("notes", "错误appId异常场景");
        return tmpErrorAppIdContentSceneMap;
    }

    /**
     * 缺少必填字段异常场景
     *
     * @param noRequiredFieldsMap
     * @param fieldsRelation
     * @return
     */
    @Override
    public List<Map<String, String>> noRequiredFields(Map<String, String> noRequiredFieldsMap, List<String> fieldsRelation) {
        List tmpNoRequiredFieldsList = new ArrayList();
        List<String> tmpFieldsRelation = MyMapList.copyList(fieldsRelation);
        tmpFieldsRelation.remove("secret");
        tmpFieldsRelation.remove("signature");
        Map<String, String> tmpNoRequiredFieldsMap = MyMapList.copyMap(noRequiredFieldsMap);
        for (String field : tmpFieldsRelation) {
            tmpNoRequiredFieldsMap.remove(field);
            tmpNoRequiredFieldsMap.put("notes", "缺少必填字段 【" + field + "】 异常场景");
            tmpNoRequiredFieldsList.add(tmpNoRequiredFieldsMap);
            tmpNoRequiredFieldsMap = MyMapList.copyMap(noRequiredFieldsMap);
        }
        return tmpNoRequiredFieldsList;
    }

    /**
     * 必填字段为空异常场景
     *
     * @param requiredFieldEmptyMap
     * @param fieldsRelation
     * @return
     */
    @Override
    public List<Map<String, String>> requiredFieldsEmpty(Map<String, String> requiredFieldEmptyMap, List<String> fieldsRelation) {
        List tmpRequiredFieldsEmptyList = new ArrayList();
        List<String> tmpFieldsRelation = MyMapList.copyList(fieldsRelation);
        tmpFieldsRelation.remove("signature");
        Map<String, String> tmpRequiredFieldsEmptyMap = MyMapList.copyMap(requiredFieldEmptyMap);
        tmpRequiredFieldsEmptyMap.put("expectresult", "");
        for (String field : tmpFieldsRelation) {
            tmpRequiredFieldsEmptyMap.put(field, "");
            tmpRequiredFieldsEmptyMap.put("notes", "必填字段 【" + field + "】 为空异常场景");
            tmpRequiredFieldsEmptyList.add(tmpRequiredFieldsEmptyMap);
            tmpRequiredFieldsEmptyMap = MyMapList.copyMap(requiredFieldEmptyMap);
        }
        return tmpRequiredFieldsEmptyList;
    }

    /**
     * 必填字段为空格异常场景
     *
     * @param requiredFieldsSpaceMap
     * @param fieldsRelation
     * @return
     */
    @Override
    public List<Map<String, String>> requiredFieldsSpace(Map<String, String> requiredFieldsSpaceMap, List<String> fieldsRelation) {
        List tmpRequiredFieldsSpaceList = new ArrayList();
        List<String> tmpFieldsRelation = MyMapList.copyList(fieldsRelation);
        tmpFieldsRelation.remove("signature");
        Map<String, String> tmpRequiredFieldsSpaceMap = MyMapList.copyMap(requiredFieldsSpaceMap);
        tmpRequiredFieldsSpaceMap.put("expectresult", "");
        for (String field : tmpFieldsRelation) {
            tmpRequiredFieldsSpaceMap.put(field, " ");
            tmpRequiredFieldsSpaceMap.put("notes", "必填字段 【" + field + "】 为空格异常场景");
            tmpRequiredFieldsSpaceList.add(tmpRequiredFieldsSpaceMap);
            tmpRequiredFieldsSpaceMap = MyMapList.copyMap(requiredFieldsSpaceMap);
        }
        return tmpRequiredFieldsSpaceList;
    }

    /**
     * 必填字段错误异常场景
     *
     * @param requiredFieldsErrorMap
     * @param fieldsRelation
     * @return
     */
    @Override
    public List<Map<String, String>> requiredFieldsError(Map<String, String> requiredFieldsErrorMap, List<String> fieldsRelation) {
        List tmpRequiredFieldsErrorList = new ArrayList();
        List<String> tmpFieldsRelation = MyMapList.copyList(fieldsRelation);
        tmpFieldsRelation.remove("signature");
        Map<String, String> tmpRequiredFieldsErrorMap = MyMapList.copyMap(requiredFieldsErrorMap);
        tmpRequiredFieldsErrorMap.put("expectresult", "");
        for (String field : tmpFieldsRelation) {
            tmpRequiredFieldsErrorMap.put(field, MyRandomNum.generateString(8));
            tmpRequiredFieldsErrorMap.put("notes", "必填字段 【" + field + "】 错误异常场景");
            tmpRequiredFieldsErrorList.add(tmpRequiredFieldsErrorMap);
            tmpRequiredFieldsErrorMap = MyMapList.copyMap(requiredFieldsErrorMap);
            ;
        }
        return tmpRequiredFieldsErrorList;
    }

    /**
     * 错误签名异常场景
     *
     * @param errorSignatureMap
     * @return
     */
    @Override
    public Map<String, String> errorSignature(Map<String, String> errorSignatureMap) {
        Map<String, String> tmpErrorSignatureMap = new TreeMap<String, String>();
        for (Map.Entry<String, String> entry : errorSignatureMap.entrySet()) {
            tmpErrorSignatureMap.put(entry.getKey(), entry.getValue());
            tmpErrorSignatureMap.put("notes", "签名错误异常场景");
        }
        tmpErrorSignatureMap.put("expectresult", "");
        tmpErrorSignatureMap.put("signature", "%2FLMIknZZlE1UIueoxax%2FLbVULCw%3D");
        return tmpErrorSignatureMap;
    }


    /**
     * 签名重复异常场景
     *
     * @param repeatSignatureMap
     * @return
     */
    @Override
    public Map<String, String> repeatSignature(Map<String, String> repeatSignatureMap) {
        Map<String, String> tmpRepeatSignature = new TreeMap<String, String>();
        for (Map.Entry<String, String> entry : repeatSignatureMap.entrySet()) {
            tmpRepeatSignature.put(entry.getKey(), entry.getValue());
            tmpRepeatSignature.put("notes", "签名重复异常场景");
        }
        tmpRepeatSignature.put("expectresult", "");
        return tmpRepeatSignature;
    }

    /**
     * 根据接口调用条件（是否授权，是否关联机构，是否需要申请），获取公共参数appId, secret/token, openId, openCarId
     *
     * @param isAuthOrganizationApplication
     * @return 返回公共对象
     */
    private CommonParams getCommonParams(String isAuthOrganizationApplication) {
        // 实例化对象
        CommonParams commonParams = new CommonParams();
        switch (isAuthOrganizationApplication) {
            case "000":
                dataService.initializationThreeNoesData(commonParams);
                break;
            case "100":
                dataService.initializationNeedAuthorizeData(commonParams);
                break;
            case "010":
                dataService.initializationNeedOrganizationData(commonParams);
                break;
            case "001":
                dataService.initializationNeedApplicationData(commonParams);
                break;
            case "011":
                dataService.initializationNeedOrganizationApplicationData(commonParams);
                break;
            case "101":
                dataService.initializationNeedAuthorizeApplicationData(commonParams);
                break;
            case "110":
                dataService.initializationNeedAuthorizeOrganizationData(commonParams);
                break;
        }
        // 添加signature参数

        return commonParams;
    }

    /**
     * 所有公共异常场景
     *
     * @param interfaceName
     * @param normalParams
     * @return
     */

    @Override
    public List<Map<String, String>> commonScene(String interfaceName, Map<String, String> normalParams) {

        List<Map<String, String>> allCommonSceneParams = new ArrayList<>();
        String[] requiredFields = OpenApiVariables.openApiAllVariables.valueOf(interfaceName + "FIELDS").getValue().split(",");

        Map<String, List<String>> fieldsRelation = OpenApiVariables.getFields(requiredFields);

        // 正常访问
        allCommonSceneParams.add(this.normalAccess(interfaceName, normalParams));

        // 缺少AppId
        allCommonSceneParams.add(this.missingAppIdFieldScene(normalParams));

        // appId错误
        allCommonSceneParams.add(this.errorAppIdContentScene(normalParams));

        // 有必填项缺少，校验失败
        for (Map<String, String> tmpNoRequiredFieldsMap : this.noRequiredFields(normalParams, fieldsRelation.get("requiredFields"))) {
            allCommonSceneParams.add(tmpNoRequiredFieldsMap);
        }

        // 必填项为空格
        for (Map<String, String> tmpRequiredFieldsSpaceMap : this.requiredFieldsSpace(normalParams, fieldsRelation.get("requiredFields"))) {
            allCommonSceneParams.add(tmpRequiredFieldsSpaceMap);
        }

        // 必填项传入key不传value
        for (Map<String, String> tmpRequiredFieldsEmptyMap : this.requiredFieldsEmpty(normalParams, fieldsRelation.get("requiredFields"))) {
            allCommonSceneParams.add(tmpRequiredFieldsEmptyMap);
        }

        // 有必填项输入错误，校验失败
        for (Map<String, String> tmpRequiredFieldsError : this.requiredFieldsError(normalParams, fieldsRelation.get("requiredFields"))) {
            allCommonSceneParams.add(tmpRequiredFieldsError);
        }
        // 签名重复
        allCommonSceneParams.add(this.repeatSignature(normalParams));
        // 签名参数错误
        allCommonSceneParams.add(this.errorSignature(normalParams));

        return allCommonSceneParams;

    }

    /**
     * 复制map
     *
     * @param list
     * @param map
     * @return
     */

    private Map<String, String> copyMap(String expectResult, List<String> list, Map<String, String> map) {
        Map<String, String> tmpCopyMap = new TreeMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tmpCopyMap.put(entry.getKey(), entry.getValue());
        }
        tmpCopyMap.put("expectresult", expectResult);
        tmpCopyMap.put("signature", encryptionService.sort(list, map));
        return tmpCopyMap;
    }

}
