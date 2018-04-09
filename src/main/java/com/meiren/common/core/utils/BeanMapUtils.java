package com.meiren.common.core.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapUtil
 * @Description TODO
 * @Author XingGang
 * @Date 08/04/2017 22:15
 */

/**
 * @see: http://4805119.blog.51cto.com/4795119/1614320
 */

public class BeanMapUtils {

    //map to bean

    public static <T> T convertMap(Map<String, Object> map, Class<T> beanClass) {

        try {
            T t = beanClass.newInstance();
            Iterator it = map.entrySet().iterator();
            Method[] methods = beanClass.getDeclaredMethods();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String methodName = formatName(entry.getKey().toString());
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        Object value = entry.getValue();
                        method.invoke(t, value);
                        break;

                    }
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    bean to map
    public static Map<String, Object> convertBean(Object object) {
        try {
            Class cla = object.getClass();
            Method[] methods = cla.getDeclaredMethods();
            Map map = new HashMap();
            for (Method method : methods) {
                if (method.getName().startsWith("get") && !"getClass".equals(method.getName())) {//TODO 这里要统一不能用is
                    String key = formatName(method.getName());
                    Object value = method.invoke(object);
                    if (null != value) {
                        map.put(key, value);
                    }

                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String formatName(String source) {
        String target;
        if (source.startsWith("get")) {//switch to bean property name
            target = source.substring(3, 4).toLowerCase() + source.substring(4);
        } else {//switch to method name
            target = "set" + source.substring(0, 1).toUpperCase() + source.substring(1);
        }
        return target;
    }
}