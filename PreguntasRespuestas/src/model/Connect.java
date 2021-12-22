/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author juanm
 */
public class Connect {
    private static final String SERVER = Configuration.SERVER;
    private static final int PORT = Configuration.PORT;
    private static final String BD = Configuration.BD;
    private static final String USER_NAME = Configuration.USER_NAME;
    private static final String PASSWORD = Configuration.PASSWORD;
   
    
        public static Connection getConnection() throws SQLException{
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(SERVER);
            ds.setPortNumber(PORT);
            ds.setDatabaseName(BD);
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
        
        Connection con = ds.getConnection();
        return con;      
    }
}
