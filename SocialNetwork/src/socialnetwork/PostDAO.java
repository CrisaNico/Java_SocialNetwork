/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_FORWARD_ONLY;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class PostDAO {
    
    Post findById(long id) throws SQLException, Exception {
        
        Connection conn = null;
        
        String db_user = "admin";
        String db_user_password = "admin";
        
        Statement st1 = null;
        ResultSet rs1 = null;
        
        try{
            conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/social_network",
             db_user, db_user_password);
            
            st1 = conn.createStatement();
            
            String sql1 = String.format("select title, body, imageurl, link, userid from post where id=" + id);
            
            rs1 = st1.executeQuery(sql1);
            
            if(rs1.next()){
                
                
              
                String title = rs1.getString("title");
                String body = rs1.getString("body");
                String imageurl = rs1.getString("imageurl");
                String link = rs1.getString("link");
                Long userid = rs1.getLong("userid");
                
                User user = new UserDAO().findById(userid);
                
                Post post = new Post(id,user,title,body,imageurl,link);
                return post;
            }
            else
                throw new Exception("Non esiste questo post");
        }
        catch(SQLException e){
            System.out.println("Errore in findById: " + e);
            throw e;
        }
        finally {
            if (rs1 != null) { try {rs1.close();} catch(SQLException e){}}
            if (st1 != null) { try {st1.close();} catch(SQLException e){}}
            if (conn != null) { try {conn.close();} catch(SQLException e){}}
        }
    }
    
}
