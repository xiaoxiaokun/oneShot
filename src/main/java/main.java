

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author jxx
 * @create 2020/7/7 11:18 上午
 */
public class main {
    private static final String URL="jdbc:mysql://localhost:3306/oneShotWeb?useUnicode=true&characterEncoding=utf-8";
    private static final String NAME="root";
    private static final String PASSWORD="123456";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
           //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);

        System.out.println(conn);
    }
}
