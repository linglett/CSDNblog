package dao;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
    }
    public static Connection DriverAndConnect() {
        Connection conn = null;
        try {
            conn = getConnection("jdbc:mysql://localhost:3306/webproject", "root", "20001228");
        System.out.println(conn);
    }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeJDBC(ResultSet rs,Statement stmt,Connection conn) {
        if(rs!=null){
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
