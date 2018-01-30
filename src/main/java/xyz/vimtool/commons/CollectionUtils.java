package xyz.vimtool.commons;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * 容器操作帮助类
 *
 * @author    qinxiaoqing
 * @date      2017/02/08
 * @version   1.0
 */
public class CollectionUtils {

    /**
     * 判断一个容器是否是空的
     *
     * @param object 容器List、Set、Map、String[]等
     */
    public static boolean isEmpty(Object object) {
        if (object == null)
            return true;

        if (object instanceof Collection) {
            Collection lst = (Collection) (object);
            return lst.size() == 0;
        } else if (object instanceof Map) {
            Map map = (Map) object;
            return map.size() == 0;
        } else if (object instanceof Object[]) {
            Object[] array = (Object[]) object;
            return array.length == 0;
        } else {
            throw new InvalidParameterException("not support this type");
        }
    }

    /**
     * list转化为String
     *
     * @param list
     */
    public static String listToString(List list) {
        if (isEmpty(list)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (Object key : list) {
            builder.append(key);
        }
        return builder.toString();
    }

    /**
     * map转化为String
     *
     * @param map
     */
    public static String mapToString(Map map) {
        if (isEmpty(map)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        List keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Object key : keys) {
            builder.append(key + "=" + map.get(key) + "&");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
