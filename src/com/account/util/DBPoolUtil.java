package com.account.util;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 使用连接池技术管理数据库连接
 *
 * @author Neal
 */
public class DBPoolUtil {

    //数据库连接池
    private static BasicDataSource dbcp;

    //为不同线程管理连接
    private static ThreadLocal<Connection> tl;

    //通过配置文件来获取数据库参数
    static {
        try {
            Properties prop = new Properties();

            InputStream is = DBPoolUtil.class.getClassLoader().getResourceAsStream("config.properties");

            prop.load(is);
            is.close();

            //一、初始化连接池
            dbcp = new BasicDataSource();

            //设置驱动 (Class.forName())
            dbcp.setDriverClassName(prop.getProperty("jdbc.driver"));
            //设置url
            dbcp.setUrl(prop.getProperty("jdbc.url"));
            //设置数据库用户名
            dbcp.setUsername(prop.getProperty("jdbc.user"));
            //设置数据库密码
            dbcp.setPassword(prop.getProperty("jdbc.password"));
            //初始连接数量
            dbcp.setInitialSize(
                    Integer.parseInt(
                            prop.getProperty("jdbc.initialSize")
                    )
            );
            //连接池允许的最大连接数
            dbcp.setMaxConnLifetimeMillis(
                    Integer.parseInt(
                            prop.getProperty("jdbc.maxActive")
                    )
            );
            dbcp.setMaxWaitMillis(
                    Integer.parseInt(
                            prop.getProperty("jdbc.maxWait")
                    )
            );
            //设置最小空闲数
            dbcp.setMinIdle(
                    Integer.parseInt(
                            prop.getProperty("jdbc.minIdle")
                    )
            );
            //设置最大空闲数
            dbcp.setMaxIdle(
                    Integer.parseInt(
                            prop.getProperty("jdbc.maxIdle")
                    )
            );
            //初始化线程本地
            tl = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 一个连接
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        /*
         * 通过连接池获取一个空闲连接
         */
        Connection conn = dbcp.getConnection();
        tl.set(conn);
        return conn;
    }


    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                /*
                 * 通过连接池获取的Connection
                 * 的close()方法实际上并没有将
                 * 连接关闭，而是将该链接归还。
                 */
                conn.close();
                tl.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}