/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author utente
 */
public class SocialNetwork {


    public static void main(String[] args) throws SQLException, Exception {
                
        {
//              User u = new User(1,"pippo","ciao"); 
//              User u2 = new User("pippo","ciao");
//
//              Contenitore<User> c = new Contenitore<User>();
//              c.add(u);
        }
        // ------------------------------------------------------------
        {
              UserDAO userDAO = new UserDAO();
              
              User user = userDAO.findById(1);
        
              user.showProfile();
              
              user.password = "rrrrr";
              
              userDAO.save(user);
              
              User maria = new User("maria","yyyy");
              
              userDAO.save(maria);
              
              maria.showProfile();
        }
        
        {
            PostDAO PostDAO = new PostDAO();
            
            Post post = PostDAO.findById(2);
            
            post.show();
        
        
        }
        
        
        // ------------------------------------------------------------
        {
//              UserDAO userDAO = new UserDAO();
//              ArrayList<User> users = userDAO.findAll();
//              for(User user: users)
//                user.showProfile();
        }
//            User user = findById(3);
//            
//            System.out.println("Utente con id = 3: " + )
//            System.out.println("--------------------");
//            
//            Statement st2 = null;
//            ResultSet rs2 = null;
//            
//            try {
//                
//                long circleId = 2;
//
//                st2 = conn.createStatement();
//
//                rs2 = st2.executeQuery("select user.name,circle.name from membership " +
//                                                 "join user on membership.userid = user.id " + 
//                                                 "join circle on membership.circleid = circle.id " +
//                                                 "where circle.id = " + circleId);
//
//                while( rs2.next() ) {
//                    System.out.println( rs2.getString("user.name") + "/" + rs2.getString("circle.name") );
//                }
//            }
//            catch(SQLException e) {
//                System.out.println("Errore query 2: " + e);
//            }
//            finally {
//                if (rs2 != null) { try {rs2.close();} catch(SQLException e){}}
//                if (st2 != null) { try {st2.close();} catch(SQLException e){}}
//            }            
//            
//            // ------------------------------------
//            
//            Statement st3 = null;
//            
//            try {
//                st3 = conn.createStatement();
//
//
//
//                String sql3 = String.format("insert into post " +
//                              "(date,title,body,imageurl,userid,circleid) " +
//                              "values " +
//                              "('%s', '%s', '%s', '%s', %d, %d);",
//                              "2017-02-02", "Riprende il corso", "bla bla bla", "www.chiavari.it", 1, 1);
//
//                int rowCount = st3.executeUpdate(sql3);
//            }
//            catch(SQLException e) {
//                System.out.println("Errore query 3: " + e);
//            }
//            finally {
//                
//                if (st3 != null) { try {st3.close();} catch(SQLException e){}}
//            }            
//            
//            
//            /*
//            User mario = new User("Mario", LocalDate.of(2001,11,4));
//            User antonella = new User("Antonella", LocalDate.of(2001,11,4));
//
//            Circle corsoJava = new Circle("Corso Java");
//            corsoJava.add(mario);
//            corsoJava.add(antonella);
//
//            Post post1 = new Post(mario, "Elezioni USA", "oh noooo, ha vinto Trump!!");
//            Post post2 = new RichPost(antonella, "Corso su Java", "ciao oggi al corso... bleah!!", "http://wwww.corriere.it");
//
//            corsoJava.publish(post1);
//
//            corsoJava.showWall();
//            
//            corsoJava.publish(post2);
//                    
//            corsoJava.showWall();     
//            */
//        }
//        catch(Exception e) {
//            // ...
//            System.out.println(e);
//        }
//        finally {
//                if (conn != null) { try {conn.close();} catch(SQLException e){}}
//                
//            }
//        
        
    }
    
}
