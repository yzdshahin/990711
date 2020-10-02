
package Model.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    
    private Connection connection;

     static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException xe) {
           xe.printStackTrace();
        }

    }
  public Connection getConnection(){

         try {
             return DriverManager.getConnection("jbdc:derby://localhost:1527/sample");
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
    }
}
