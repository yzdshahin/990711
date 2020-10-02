
package Model.Dao;

import Model.Entity.LoginBean;
import Model.Util.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
     public String AuthorizeLogin(LoginBean bean) throws SQLException {
            String username=bean.getUsername();
            String password=bean.getPassword();
        
           try{ 
            ConnectionProvider connectioner =new ConnectionProvider();
PreparedStatement preparedStatement = connectioner.getConnection().prepareStatement("SELECT * from user where username=? and password=?");
            
            preparedStatement.setString(1, "username");
            preparedStatement.setString(1, "password");
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                   String DBuser= resultSet.getString(username);
                   String DBpassword= resultSet.getString(password);
                   
                   if(password.equals(DBpassword)&& username.equals(DBuser)){
                        return "Success";
                   }
            }
           }catch(SQLException e){
              e.printStackTrace();
           }
        return "Wrong username and password";
    }
}
