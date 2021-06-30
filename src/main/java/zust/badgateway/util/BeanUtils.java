package zust.badgateway.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhu
 */
public final class BeanUtils {
    private static final Pattern PATTERN = Pattern.compile("[A-Z]");

    public static <T> T Request2Bean(HttpServletRequest req, Class<T> clazz) {

        try {
            T bean = clazz.newInstance();

            Enumeration<String> enumeration = req.getParameterNames();

            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                String value = req.getParameter(name);

                name = SmallCamel2Camel(name);

                Method[] methods = clazz.getMethods();

                for (Method method : methods) {
                    if (method.getName().equals("set" + name)) {
                        String type = method.getGenericParameterTypes()[0].toString();

                        switch (type) {
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
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ParseException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static <T> List<T> ResultSet2BeanList(ResultSet res, Class<T> clazz) {
        List<T> beans = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();

        while (true) {
            try {
                if (!res.next()) {
                    break;
                }

                T bean = clazz.newInstance();

                for (Field field : fields) {
                    String name = field.getName();
                    String dbname = SmallCamel2Line(name);
                    String methodname = SmallCamel2Camel(name);
                    String type = field.getType().toString();

                    Method method;
                    switch (type) {
                        case "class java.lang.String":
                            method = clazz.getMethod("set" + methodname, String.class);
                            method.invoke(bean, res.getString(dbname));
                            break;
                        case "class java.lang.Integer":
                            method = clazz.getMethod("set" + methodname, Integer.class);
                            method.invoke(bean, res.getInt(dbname));
                            break;
                        case "class java.lang.Float":
                            method = clazz.getMethod("set" + methodname, Float.class);
                            method.invoke(bean, res.getFloat(dbname));
                            break;
                        case "class java.time.LocalDateTime":
                            method = clazz.getMethod("set" + methodname, LocalDateTime.class);
                            method.invoke(bean, res.getObject(dbname, LocalDateTime.class));
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + type);
                    }
                }

                beans.add(bean);
            } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException throwables) {
                throwables.printStackTrace();
            }
        }

        return beans;
    }

    public static String SmallCamel2Line(String str) {
        Matcher matcher = PATTERN.matcher(str);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, "_" + matcher.group(0).toLowerCase());
        }

        matcher.appendTail(buffer);

        return buffer.toString();
    }

    public static String SmallCamel2Camel(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
