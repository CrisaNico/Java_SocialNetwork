/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author riccobene
 */
public class UserDAO {
    User findById(long id) throws SQLException, Exception {
    
        Connection conn = null;
        
        


        Statement st1 = null;
        ResultSet rs1 = null;
        
        try {
            
            MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("social_network");
            
            String db_user = "admin";
            String db_user_password = "admin";
            dataSource.setUser(db_user);
            dataSource.setPassword(db_user_password);
            
            String sql1 = String.format("select name, password from user where id=" + id);

            rs1 = st1.executeQuery(sql1);

            if (rs1.next()) { 
                
                String name = rs1.getString("name");
                String pwd = rs1.getString("password");
                
                User user = new User(id,name,pwd);
                return user;
            }
            else
                throw new Exception("Attenzione utente non trovato");
            
        }
        catch(SQLException e) {
            System.out.println("Errore in findById: " + e);
            throw e;
        }
        finally {
            if (rs1 != null) { try {rs1.close();} catch(SQLException e){}}
            if (st1 != null) { try {st1.close();} catch(SQLException e){}}
            if (conn != null) { try {conn.close();} catch(SQLException e){}}
        }
            
       
    }
    
    ArrayList<User> findAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            String db_user = "admin";
            String db_user_password = "admin";
        
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/social_network", 
                db_user, db_user_password);  
        
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id,name,password FROM user");

            while (rs.next()) {
                int user_id = rs.getInt("id");
                String user_name = rs.getString("name");
                String user_pwd = rs.getString("password");
                
                User user = new User(user_id,user_name,user_pwd);
                users.add(user);
            }
            
            return users;
        } 
        catch (SQLException e) {
            System.out.println("Errore: " + e);
            throw e;
        } 
        finally {
            if (rs != null)   {try { rs.close(); }   catch (SQLException e) { /* ignored */} }
            if (stmt != null) {try { stmt.close(); } catch (SQLException e) { /* ignored */} }
            if (conn != null)  {try { conn.close(); }  catch (SQLException e) { /* ignored */} }
        }              
        
    }
    
    void save(User user) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            String db_user = "admin";
            String db_user_password = "admin";
        
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/social_network", 
                db_user, db_user_password);  
        
            stmt = conn.createStatement();
            
//            String sql = String.format("INSERT INTO user (id,name,password) VALUES (%d,'%s','%s') "  +
//                                       "on duplicate key " +
//                                       "update name='%s', password='%s' ",
//                    user.id, user.name, user.password, user.name, user.password);
           
            String sql = String.format("INSERT INTO user (name,password) VALUES ('%s','%s') ",
                    user.name, user.password);
            
             if (user.id != null) {
                 sql = String.format("update user set name='%s', password='%s' where id = %d ",
                    user.name, user.password, user.id);
             }
             
            int affectedRows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            if (affectedRows != 1)
                throw new Exception("???");
            
            if (user.id == null) {
                ResultSet generatedKeys = stmt.getGeneratedKeys(); 
                if (generatedKeys.next()) {
                    user.id = generatedKeys.getLong(1);
                }
                else
                    throw new Exception("???"); 
            }       
          
            
        }
        catch(Exception e) {
            System.out.println("Errore: " + e);
            throw e;
        }
        finally {
            if (rs != null)   {try { rs.close(); }   catch (SQLException e) { /* ignored */} }
            if (stmt != null) {try { stmt.close(); } catch (SQLException e) { /* ignored */} }
            if (conn != null)  {try { conn.close(); }  catch (SQLException e) { /* ignored */} }
        }         
    }
}
