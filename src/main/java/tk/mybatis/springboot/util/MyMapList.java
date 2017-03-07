package tk.mybatis.springboot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-12.
 */
public class MyMapList {

    /**
     * 复制map值，防止传递应用
     *
     * @param map
     * @return
     */
    public static Map<String, String> copyMap(Map<String, String> map) {
        Map<String, String> tmpCopyMap = new TreeMap<String, String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tmpCopyMap.put(entry.getKey(), entry.getValue());
        }
        return tmpCopyMap;
    }

    /**
     * 复制list值
     *
     * @param list
     * @return
     */
    public static List<String> copyList(List<String> list) {
        List<String> tmpCopyList = new ArrayList<>();
        for (String str : list) {
            tmpCopyList.add(str);
        }
        return tmpCopyList;
    }
}
