package se.zust.badgateway.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

/**
 * @author zhu
 */
public final class BeanUtils {
    public static <T> T Request2Bean(HttpServletRequest req, Class<T> clazz) {

        try {

            T bean = clazz.getDeclaredConstructor().newInstance();

            Enumeration<String> enumeration = req.getParameterNames();

            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                String value = req.getParameter(name);

                name = name.substring(0, 1).toUpperCase() + name.substring(1);

                Method[] methods = clazz.getMethods();

                for (Method method : methods) {
                    if (method.getName().equals("set" + name)) {
                        String type = method.getGenericParameterTypes()[0].toString();
                        switch (type) {
                            case "class java.lang.Integer":
                                method.invoke(bean, Integer.parseInt(value));
                                break;
                            case "class java.lang.Double":
                                method.invoke(bean, Double.parseDouble(value));
                                break;
                            case "class java.lang.String":
                                method.invoke(bean, value);
                                break;
                            case "class java.lang.Float":
                                method.invoke(bean, Float.parseFloat(value));
                                break;
                            case "class java.util.Date":
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                method.invoke(bean, sdf.parse(value));
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + type);
                        }

                        break;
                    }
                }
            }

            return bean;
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
