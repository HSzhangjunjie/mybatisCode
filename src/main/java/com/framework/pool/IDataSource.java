package com.framework.pool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.ShardingKeyBuilder;
import java.util.logging.Logger;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.pool
 * @ClassName: IDataSource
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/21 2:06
 * @Version: 1.0
 */
public interface IDataSource extends DataSource {

    @Override
    default Connection getConnection(String s, String s1) throws SQLException {
        return null;
    }

    @Override
    default PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    default void setLogWriter(PrintWriter printWriter) throws SQLException {

    }

    @Override
    default void setLoginTimeout(int i) throws SQLException {

    }

    @Override
    default int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    default <T> T unwrap(Class<T> aClass) throws SQLException {
        return null;
    }

    @Override
    default boolean isWrapperFor(Class<?> aClass) throws SQLException {
        return false;
    }

    @Override
    default Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    default ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return null;
    }
}
