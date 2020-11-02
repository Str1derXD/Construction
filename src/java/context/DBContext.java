/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +"\\" + instance + ";databaseName=" + dbName ;
        if(instance == null || instance.trim().isEmpty()){
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName ;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);

        //bên dưới là kết nối kiểu authen dùng cho máy nhà trường
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        Connection conn = DriverManager.getConnection("jdbc:sqlserver://"
//                + serverName + ":"
//                + portNumber + ";databaseName="
//                + dbname +";integratedSecurity=true;");
//        return conn;
    }
    private final String serverName = "localhost";
    private final String dbName = "Constructor";
    private final String portNumber = "1433";
    private final String instance ="";
    private final String userID = "sa";
    private final String password = "123";

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getImagePath() throws Exception {
        return "img/";
    }
}

