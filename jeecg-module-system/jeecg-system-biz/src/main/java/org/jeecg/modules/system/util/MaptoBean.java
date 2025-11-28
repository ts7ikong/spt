package org.jeecg.modules.system.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName(类名) : MaptoBean
 * @Description(描述) : Map转化javabean
 * @author(作者) zhaobin
 * @date(开发日期) ：2017-5-31 上午9:45:55
 * @exception
 */
public class MaptoBean {


    /**
     * @param map
     * @param obj void
     * @throws :
     * @Description(功能描述) :  Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
     * @author(作者) ：  zhaobin
     * @date(开发日期) :  2017-5-31 上午9:56:28
     */
    public void transMap2Bean(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                try {
                    if (map.containsKey(key)) {
                        Field field = obj.getClass().getDeclaredField(key);

                        Object value = map.get(key);
                        String type = property.getPropertyType().getName();



                        // 得到property对应的setter方法

                        Method setter = property.getWriteMethod();

                        setter.invoke(obj, returnType(type, value));
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
        return;
    }


    //把JavaBean转化为map
    public static Map<String,Object> bean2map(Object bean) throws Exception{
        Map<String,Object> map = new HashMap<>();
        //获取JavaBean的描述器
        BeanInfo b = Introspector.getBeanInfo(bean.getClass(),Object.class);
        //获取属性描述器
        PropertyDescriptor[] pds = b.getPropertyDescriptors();
        //对属性迭代
        for (PropertyDescriptor pd : pds) {
            //属性名称
            String propertyName = pd.getName();
            //属性值,用getter方法获取
            Method m = pd.getReadMethod();
            Object properValue = m.invoke(bean);//用对象执行getter方法获得属性值

            //把属性名-属性值 存到Map中
            map.put(propertyName, properValue);
        }
        return map;
    }


    /**
     * @param map
     * @param obj void
     * @throws :
     * @Description(功能描述) :  Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
     * @author(作者) ：  zhaobin
     * @date(开发日期) :  2017-5-31 上午9:56:28
     */
    public void transMapToBeanJson(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                try {
                    if (map.containsKey(key)) {
                        Object value = map.get(key);
                        String type = property.getPropertyType().getName();
                        // 得到property对应的setter方法

                        Method setter = property.getWriteMethod();

                        setter.invoke(obj, returnType(type, value));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
        return;
    }

    /**
     * @Author zhaobin
     * @Version 1.0
     * @Description 返回类型
     * @Param
     * @Return
     * @Exception
     * @Date 2019/6/18 10:15
     */
    private Object returnType(String tpye, Object value) {
        switch (tpye) {
            case "java.lang.Class":
                return null;
            case "java.lang.Long":
                return Long.parseLong(String.valueOf(value));
            case "java.lang.Integer":
                return Integer.parseInt(String.valueOf(value));
            case "java.lang.Float":
                return Float.parseFloat(String.valueOf(value));
            case "java.lang.Double":
                return Double.parseDouble(String.valueOf(value));
            case "java.lang.Short":
                return Short.parseShort(String.valueOf(value));
            case "java.lang.Boolean":
                return Boolean.parseBoolean(String.valueOf(value));
            case "int":
                return Integer.parseInt(String.valueOf(value));
            case "Int":
                return Integer.parseInt(String.valueOf(value));
            case "Long":
                return Long.parseLong(String.valueOf(value));
            case "long":
                return Long.parseLong(String.valueOf(value));
            case "float":
                return Float.parseFloat(String.valueOf(value));
            case "Float":
                return Float.parseFloat(String.valueOf(value));
            case "Double":
                return Float.parseFloat(String.valueOf(value));
            case "double":
                return Float.parseFloat(String.valueOf(value));
            case "java.lang.String":
                return String.valueOf(value);
            case "string":
                return String.valueOf(value);
            case "String":
                return String.valueOf(value);
            case "java.util.Date":
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
                try {
                    Date date = simpleDateFormat.parse(String.valueOf(value));
                    return date;
                } catch (ParseException e) {
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        Date date = simpleDateFormat1.parse(String.valueOf(value));
                        return date;
                    } catch (ParseException e1) {
                        return null;
                    }
                }
            case "short":
                return Short.parseShort(String.valueOf(value));
            case "boolean":
                return Boolean.parseBoolean(String.valueOf(value));
            case "Boolean":
                return Boolean.parseBoolean(String.valueOf(value));
            case "Short":
                return Short.parseShort(String.valueOf(value));
            case "java.math.BigDecimal":
                return new BigDecimal(String.valueOf(value));

            default:
                return value;
        }


    }

}
