package tk.mybatis.springboot.service;

import tk.mybatis.springboot.model.CommonParams;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */
public interface DataService {


    // 都不需要
    void initializationThreeNoesData(CommonParams commonParams);

    // 仅需要授权
    void initializationNeedAuthorizeData(CommonParams commonParams);

    // 仅需要关联机构

    void initializationNeedOrganizationData(Object object);

    // 仅需要申请

    void initializationNeedApplicationData(Object object);

    // 需要关联机构与申请

    void initializationNeedOrganizationApplicationData(Object object);

    // 需要授权与申请

    void initializationNeedAuthorizeApplicationData(Object object);

    // 需要授权与机构
    void initializationNeedAuthorizeOrganizationData(Object object);


}
