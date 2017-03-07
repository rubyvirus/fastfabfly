package tk.mybatis.springboot.mapper;


import org.apache.ibatis.annotations.Param;
import tk.mybatis.springboot.model.BasicParams;
import tk.mybatis.springboot.util.MyMapper;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */

public interface BasicParamsMapper extends MyMapper<BasicParams> {

    public BasicParams selelctThreeNoesBasicParamsByDevId(String dev_id);

    public BasicParams selectNeedAuthorizeBasicParamsByDevId(@Param("dev_id") String dev_id, @Param("expire_time") String expire_time);

    public BasicParams selectNeedOrganizationBasicParamsByDevId(String dev_id);

    public BasicParams selectNeedApplicationBasicParamsByDevId(String dev_id);

    public BasicParams selectNeedOrganizationApplicationBasicParamsByDevId(String dev_id);

    public BasicParams selectNeedAuthorizeApplicationBasicParamsByDevId(@Param("dev_id") String dev_id, @Param("expire_time") String expire_time);

    public BasicParams selectNeedAuthorizeOrganizationBasicParamsByDevId(@Param("dev_id") String dev_id, @Param("expire_time") String expire_time);

}
