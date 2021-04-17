package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test_JDBC_chaxun {
    public static void main(String[] args) throws SQLException {
        // 1. 先创建数据源对象
        MysqlDataSource dataSource = new MysqlDataSource();
        // 2. 指定数据源内部参数 (在数据源中定义用户名, 密码, 端口号)
        dataSource.setUser("root");
        dataSource.setPassword("000000");
        // 协议 + // + 本机IP(环回ip) + 端口号 + 数据库名字 + 一些配置
        dataSource.setURL("jdbc:mysql://localhost:3306/linked?characterEncoding=utf8&useSSL=true");
        // 3. 和服务器建立连接
        Connection connection = dataSource.getConnection();
        // 4. 创建sql语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5. 执行sql语句
        ResultSet resultSet = statement.executeQuery();
        // 6. 遍历结果集
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int sn = resultSet.getInt("sn");
            String name = resultSet.getString("name");
            String qq_mail = resultSet.getString("qq_mail");
            int class_id = resultSet.getInt("classes_id");
            System.out.println(id + ", " + sn + ", " + name + ", " + qq_mail + ", " + class_id);
        }
        // 7. 清理资源(顺序很重要, 一定要倒着来)
        resultSet.close();
        statement.close();
        connection.close();
    }
}
