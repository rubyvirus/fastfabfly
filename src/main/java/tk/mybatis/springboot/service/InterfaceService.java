package tk.mybatis.springboot.service;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-8.
 */
public interface InterfaceService {

    void publicAreaProvince(RecordService recordService);

    void publicAreaCity(RecordService recordService);

    void userProfileQuery(RecordService recordService);

    // 控制驾图盒子GPS加速上报
    void fastGPS(RecordService recordService);

    // 为指定用户添加应用
    void userAppAdd(RecordService recordService);

    // 添加车辆—个人车辆
    void carAddPersonal(RecordService recordService);

    // 修改车辆—个人车辆
    void carUpdatePersonal(RecordService recordService);

    // 添加车辆—非个人车辆
    void carAddNoPersonal(RecordService recordService);

    // 修改车辆—非个人车辆
    void carUpdateNoPersonal(RecordService recordService);

}
