/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;


public class Post {

    protected Long id;
    protected String title;
    protected String body;
    protected String imageurl;
    protected String link;
    protected User author;
    
    public Post(User author, String title, String body, String imageurl, String link) {
        this.id = null;
        this.title = title;
        this.body = body;
        this.imageurl = imageurl;
        this.link = link;
        this.author = author;
      
    }
    
    public Post(long id, User author, String title, String body, String imageurl, String link) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imageurl = imageurl;
        this.link = link;
        this.author = author;
    }
    
    public void show() {
        author.showAvatar();
        System.out.println("- " + title + " -");
        System.out.println(body);
    }
}
