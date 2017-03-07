package tk.mybatis.springboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.BasicParamsMapper;
import tk.mybatis.springboot.model.BasicParams;
import tk.mybatis.springboot.model.CommonParams;
import tk.mybatis.springboot.model.OpenApiProps;
import tk.mybatis.springboot.service.DataService;
import tk.mybatis.springboot.util.MyOpenIdOpenCarId;
import tk.mybatis.springboot.util.MyTime;

/**
 * 需要openId，
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private BasicParamsMapper basicParamsMapper;

    @Autowired
    private OpenApiProps openApiProps;

    /**
     * 初始化不需要授权，不需要关联机构，不需要申请接口基础数据
     *
     * @param commonParams
     * @return 返回公共对象
     */
    @Override
    public void initializationThreeNoesData(CommonParams commonParams) {
        BasicParams basicParams = null;
        try {
            basicParams = basicParamsMapper.selelctThreeNoesBasicParamsByDevId(openApiProps.getDevId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.commonParams(commonParams, basicParams);
    }

    /**
     * 仅需要授权接口基础数据
     *
     * @param commonParams
     * @return 返回公共对象
     */
    @Override
    public void initializationNeedAuthorizeData(CommonParams commonParams) {
        BasicParams basicParams = basicParamsMapper.selectNeedAuthorizeBasicParamsByDevId(openApiProps.getDevId(), MyTime.getTime());
        this.AuthcommonParams(commonParams, basicParams);
    }

    /**
     * 仅需要关联机构接口
     *
     * @param object
     * @return 返回公共数据
     */
    @Override
    public void initializationNeedOrganizationData(Object object) {
        CommonParams commonParams = (CommonParams) object;
        BasicParams basicParams = basicParamsMapper.selectNeedOrganizationBasicParamsByDevId(openApiProps.getDevId());
        this.commonParams(commonParams, basicParams);
    }

    /**
     * 仅需要申请接口
     *
     * @param object
     * @return 返回公共数据
     */
    @Override
    public void initializationNeedApplicationData(Object object) {
        CommonParams commonParams = (CommonParams) object;
        BasicParams basicParams = basicParamsMapper.selectNeedApplicationBasicParamsByDevId(openApiProps.getDevId());
        this.commonParams(commonParams, basicParams);
    }

    /**
     * 需要关联机构与申请的接口
     *
     * @param object
     * @return 返回公共数据
     */
    @Override
    public void initializationNeedOrganizationApplicationData(Object object) {
        CommonParams commonParams = (CommonParams) object;
        BasicParams basicParams = basicParamsMapper.selectNeedOrganizationApplicationBasicParamsByDevId(openApiProps.getDevId());
        this.commonParams(commonParams, basicParams);
    }

    /**
     * 需要授权与申请的接口
     *
     * @param object
     * @return 返回公共数据
     */
    @Override
    public void initializationNeedAuthorizeApplicationData(Object object) {
        CommonParams commonParams = (CommonParams) object;
        BasicParams basicParams = basicParamsMapper.selectNeedAuthorizeApplicationBasicParamsByDevId(openApiProps.getDevId(), MyTime.getTime());
        this.AuthcommonParams(commonParams, basicParams);
    }

    /**
     * 需要授权与关联机构的接口
     *
     * @param object
     * @return 返回公共数据
     */
    @Override
    public void initializationNeedAuthorizeOrganizationData(Object object) {
        CommonParams commonParams = (CommonParams) object;
        BasicParams basicParams = basicParamsMapper.selectNeedAuthorizeOrganizationBasicParamsByDevId(openApiProps.getDevId(), MyTime.getTime());
        this.AuthcommonParams(commonParams, basicParams);
    }

    /**
     * 公共操作
     *
     * @param commonParams
     * @param basicParams
     * @return
     */
    private void commonParams(CommonParams commonParams, BasicParams basicParams) {

        // 添加字段数据
        commonParams.getCommonParamsMap().put("appId", basicParams.getAppId());
        commonParams.getCommonParamsMap().put("secret", basicParams.getSecret());
        commonParams.getCommonParamsMap().put("nonce", openApiProps.getNonce());
        commonParams.getCommonParamsMap().put("timestamp", MyTime.getTimeStamp());
    }

    /**
     * 需要授权的公共操作
     *
     * @param commonParams
     * @param basicParams
     * @return
     */
    private void AuthcommonParams(CommonParams commonParams, BasicParams basicParams) {

        // 计算openId, openCarId
        String openId = MyOpenIdOpenCarId.getMyOpenId(basicParams.getUserId(), Long.valueOf(openApiProps.getDevId()));
        String openCarId = MyOpenIdOpenCarId.getMyOpenCarId(basicParams.getCarId(), Long.valueOf(openApiProps.getDevId()));

        // 添加字段数据
        commonParams.getCommonParamsMap().put("appId", basicParams.getAppId());
        commonParams.getCommonParamsMap().put("secret", basicParams.getSecret());
        commonParams.getCommonParamsMap().put("nonce", openApiProps.getNonce());
        commonParams.getCommonParamsMap().put("timestamp", MyTime.getTimeStamp());
        commonParams.getCommonParamsMap().put("openId", openId);
        commonParams.getCommonParamsMap().put("openCarId", openCarId);
    }
}
