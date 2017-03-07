package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.springboot.model.OpenApiProps;
import tk.mybatis.springboot.service.InterfaceService;
import tk.mybatis.springboot.service.RecordService;
import tk.mybatis.springboot.service.impl.RecordServiceImpl;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-4.
 */

@RestController
@RequestMapping(value = "/fastFabFly")
public class FastFabFlyController {

    private RecordService recordService;

    @Autowired
    private InterfaceService interfaceService;

    @Autowired
    private OpenApiProps openApiProps;

    @RequestMapping
    public void result() {
        // 初始化写入excel方法
        recordService = new RecordServiceImpl(openApiProps.getExcelPath());
        interfaceService.publicAreaProvince(recordService);
        interfaceService.publicAreaCity(recordService);
//        allInterfaceService.userProfileQuery(recordService);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recordService.destory();
    }
}
