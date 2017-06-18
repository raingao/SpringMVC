package cn.itcast.util;

import cn.itcast.annotation.FruitName;

import java.lang.reflect.Field;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName = "水果名称：";
        String strFruitColor = "水果颜色：";
        String strFruitProvicer = "供应商信息：";
        // 获取声明的类成员
        Field[] fields = clazz.getDeclaredFields();
        // 遍历类成员变量
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {

            }
        }

    }

}
