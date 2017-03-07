package tk.mybatis.springboot.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.springboot.service.RecordService;
import tk.mybatis.springboot.util.MyTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 请求连接的时候，新增一个线程向Excel写内容，接口服务端调用本服务方法，向队列中添加内容就可以。如果队列数据满了就阻塞
 * Created by rubyvirusqq@gmail.com on 2017-2-7.
 */
public class RecordServiceImpl implements RecordService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private FileOutputStream fileOutputStream;

    private LinkedBlockingDeque<Map<String, String>> linkedBlockingDeque;

    private Thread insertExcelThread;

    private SXSSFWorkbook workbook = null;

    private AtomicBoolean isRun = new AtomicBoolean(true);

    public RecordServiceImpl(String excelPath) {
        workbook = new SXSSFWorkbook();
        linkedBlockingDeque = new LinkedBlockingDeque<Map<String, String>>(1000);
        String fileName = "openapi" + MyTime.getTimeStamp() + ".xlsx";
        try {
            fileOutputStream = new FileOutputStream(new File(excelPath + "/" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        insertExcelThread = new Thread(new InsertExcelThread());
        insertExcelThread.setName("fastfabfly-write-thread");
        insertExcelThread.start();
    }

    @Override
    public void doContent(Map<String, String> content) {
        // 添加元素到队列，如果队列满了，就阻塞
        try {
            linkedBlockingDeque.put(content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destory() {
        // 写入文件
        try {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        isRun.set(false);
    }

    class InsertExcelThread implements Runnable {
        private List<String> firstParamsList = null;

        @Override
        public void run() {
            while (isRun.get()) {
                try {
                    Map<String, String> paramsMap = linkedBlockingDeque.take();

                    String sheetName = paramsMap.get("sheetName");

                    paramsMap.remove("sheetName");

                    // 接口所有字段与数据
                    if (workbook != null) {
                        Sheet sheet = null;
                        // 如果sheet存在就不创建，通过sheetName获取sheet，否则创建sheet，并添加标题
                        if (workbook.getSheetIndex(sheetName) == -1) {
                            List<String> paramsList = new ArrayList<String>();
                            for (Map.Entry entryName : paramsMap.entrySet()) {
                                paramsList.add(entryName.getKey().toString());
                            }
                            firstParamsList = paramsList;
                            sheet = workbook.createSheet(sheetName);
                            Row topRow = sheet.createRow(0);
                            for (int i = 0; i < paramsList.size(); i++) {
                                topRow.createCell(i).setCellValue(paramsList.get(i));
                            }
                        } else {
                            sheet = workbook.getSheet(sheetName);
                        }
                        // 获取最后一行行号，再新增一行添加内容
                        int lastRowNum = sheet.getLastRowNum();
                        Row lastRow = sheet.createRow(lastRowNum + 1);

                        int cell = 0;

                        for (String firstParamsStr : firstParamsList) {
                            if (paramsMap.containsKey(firstParamsStr) && paramsMap.get(firstParamsStr) != null) {
                                lastRow.createCell(cell).setCellValue(paramsMap.get(firstParamsStr).toString());
                            } else {
                                lastRow.createCell(cell).setCellValue("");
                            }
                            cell++;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
