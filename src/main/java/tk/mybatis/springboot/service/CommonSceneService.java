package tk.mybatis.springboot.service;

import tk.mybatis.springboot.model.CommonParams;

import java.util.List;
import java.util.Map;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-9.
 */
public interface CommonSceneService {


    Map<String, String> normalAccess(String interfaceName, Map<String, String> repeatSignatureMap);

    CommonParams commonNormalScene(String isAuthOrganizationApplication);

    Map<String, String> missingAppIdFieldScene(Map<String, String> missingFieldMap);

    Map<String, String> errorAppIdContentScene(Map<String, String> errorFieldMap);

    List<Map<String, String>> noRequiredFields(Map<String, String> noRequiredFieldsMap, List<String> fieldsRelation);

    List<Map<String, String>> requiredFieldsEmpty(Map<String, String> requiredFieldEmptyMap, List<String> fieldsRelation);

    List<Map<String, String>> requiredFieldsSpace(Map<String, String> requiredFieldsSpaceMap, List<String> fieldsRelation);

    List<Map<String, String>> requiredFieldsError(Map<String, String> requiredFieldsErrorMap, List<String> fieldsRelation);

    Map<String, String> errorSignature(Map<String, String> errorSignatureMap);

    Map<String, String> repeatSignature(Map<String, String> repeatSignatureMap);

    List<Map<String, String>> commonScene(String interfaceName, Map<String, String> normalParamsMap);

}
