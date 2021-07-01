package se.zust.badgateway.util;

import com.mysql.cj.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author 王怀瑾
 */
public class ObjectIsNull {
    public static boolean checkObjAllFieldIsNull(Object object){
        if (object == null){
            return true;
        }
        try{
            for (Field f:object.getClass().getDeclaredFields()){
                f.setAccessible(true);
                if (f.get(object) !=null&& StringUtils.isNullOrEmpty(f.get(object).toString())){
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
