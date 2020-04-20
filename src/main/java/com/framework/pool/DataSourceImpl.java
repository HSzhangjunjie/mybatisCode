package com.framework.pool;

import com.framework.mapping.Environment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: mybatisCode
 * @Package: com.framework.executor
 * @ClassName: DataSource
 * @Author: ZhangJunjie
 * @Description: 手写数据库连接池
 * @Date: 2020/4/21 2:04
 * @Version: 1.0
 */
public class DataSourceImpl implements IDataSource {
    private Environment environment;
    private List<Connection> pool;
    private Connection connection = null;
    private static DataSource dataSource = null;
    private static final int POOL_SIZE = 15;

    private DataSourceImpl(Environment environment) {
        this.environment = environment;
        pool = new ArrayList<>(POOL_SIZE);
        this.createConnection();
    }

    public static DataSource getInstance(Environment environment) {
        if (dataSource == null) {
            dataSource = new DataSourceImpl(environment);
        }
        return dataSource;
    }

    private void createConnection() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Class.forName(environment.getDriver());
                connection = DriverManager.getConnection(environment.getUrl(), environment.getUsername(), environment.getPassword());
                pool.add(connection);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        }
        return null;
    }

    public synchronized void release(Connection connection) {
        pool.add(connection);
    }

    public synchronized void closePool() {
        for (int i = 0; i < pool.size(); i++) {
            try {
                connection = pool.get(i);
                connection.close();
                pool.remove(i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
