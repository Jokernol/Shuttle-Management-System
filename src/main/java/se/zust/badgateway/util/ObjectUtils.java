package se.zust.badgateway.util;

import com.mysql.cj.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author 王怀瑾
 */
public class ObjectUtils {
    public static boolean isAnyFiledNull(Object object) {
        Boolean flag = false;

        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(object) == null || StringUtils.isNullOrEmpty(field.get(object).toString())) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
