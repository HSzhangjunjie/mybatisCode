package com.framework.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.utils
 * @ClassName: ReflectionUtils
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 3:28
 * @Version: 1.0
 */
public class ReflectionUtils {
    public static void setProToBeanFromResult(Object entity, ResultSet set) throws SQLException {
        ResultSetMetaData resultSetMetaData=set.getMetaData();

        int count=resultSetMetaData.getColumnCount();
        Field[] fields=entity.getClass().getDeclaredFields();
        for (int i=0;i<count;i++){
            String columnName=resultSetMetaData.getColumnName(i+1).replace("_","").toUpperCase();

            String fieldName=fields[i].getName().toUpperCase();
            if (columnName.equalsIgnoreCase(fieldName)){
                if ("Integer".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getInt(resultSetMetaData.getColumnName(i+1)));
                }else if ("Double".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getDouble(resultSetMetaData.getColumnName(i+1)));
                }else if ("Long".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getLong(resultSetMetaData.getColumnName(i+1)));
                }else if ("String".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getString(resultSetMetaData.getColumnName(i+1)));
                }else if ("Date".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getDate(resultSetMetaData.getColumnName(i+1)));
                }else if ("Boolean".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getBoolean(resultSetMetaData.getColumnName(i+1)));
                }else if ("BigDecimal".equals(fields[i].getType().getSimpleName())){
                    setProToBean(entity,fields[i].getName(),set.getBigDecimal(resultSetMetaData.getColumnName(i+1)));
                }
            }
        }
    }
    private static void setProToBean(Object bean,String name,Object value){
        try {
            Field field=bean.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean,value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
