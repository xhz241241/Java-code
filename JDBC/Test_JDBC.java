package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test_JDBC {
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
        String sql = "insert into student values(999, 9999, 'jdbc测试', '12345678', 2)";
        PreparedStatement statement = connection.prepareStatement(sql);
//        PreparedStatement statement2 = connection.prepareStatement(sql2);
//        String sql2 = "insert into student values(?, 9999, ?, '1234567890', 2)";
//        int id = 888;
//        String name = "动态输入";
//        statement2.setInt(1, id);
//        statement2.setString(2, name);
//        System.out.println("sql:" + statement2.toString());
        // 5. 执行sql语句 insert delete update 用的都是executeUpdate()方法
        //    返回的整数 res 代表影响到的行数
        int res = statement.executeUpdate();
        System.out.println("有 " + res + "行受到影响");
        // 6. 清理资源(程序结束前进行 close 即可)
        statement.close();
        connection.close();
    }
}
