package org.baits;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * sql执行器
 */
public class Executor {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

    public <T> T query(String sql, Object parameters) {
        Blog blog = new Blog();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            // 注册驱动
            Class.forName(bundle.getString("driver"));
            // 打开链接
            connection = DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("username"),
                    bundle.getString("password"));


            statement = connection.createStatement();
            // 执行查询
            String format = String.format(sql, parameters);
            resultSet = statement.executeQuery(format);
            // 处理结果集
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                blog.setId(id);
                blog.setName(name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return (T) blog;
    }

}
