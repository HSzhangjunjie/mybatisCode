package com.framework.executor;

import com.framework.mapping.Configuration;
import com.framework.mapping.MapperStatement;
import com.framework.pool.DataSourceImpl;
import com.framework.utils.ReflectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.mapping
 * @ClassName: Executor
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 2:00
 * @Version: 1.0
 */
public class Executor {
    private DataSourceImpl dataSource;

    public Executor(Configuration configuration) {
        //初始化数据源
        DataSourceImpl dataSource = (DataSourceImpl) DataSourceImpl.getInstance(configuration.getEnvironment());
        this.dataSource = dataSource;
    }

    public <T> List<T> query(MapperStatement statement, Object param) {
        List<T> resultList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement(statement.getSql());

            if (param instanceof Integer) {
                preparedStatement.setInt(1, (Integer) param);
            } else if (param instanceof Long) {
                preparedStatement.setLong(1, (Long) param);
            } else if (param instanceof Double) {
                preparedStatement.setDouble(1, (Double) param);
            }

            set = preparedStatement.executeQuery();

            //查询后的结果处理，转换为一个对象返回
            handlerResultSet(set, resultList, statement.getResultType());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                dataSource.release(connection);
            }
        }
        return resultList;
    }

    private <T> void handlerResultSet(ResultSet set, List<T> resultList, String resultType) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(resultType);
            while (set.next()) {
                Object entity = clazz.getConstructor().newInstance();

                ReflectionUtils.setProToBeanFromResult(entity, set);
                resultList.add((T) entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
