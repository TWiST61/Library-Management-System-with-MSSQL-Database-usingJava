/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AsadullauhSojib
 */
public class ConnectMSSQL {
    
    static Connection con = null;
    public static Connection connectDB(){try {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    con = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=libraryManagement;selectMethod=cursor;","sa","123456");
    
    } catch (Exception e)
    {  
        e.printStackTrace();
    }
    return con;
    }
    
}
