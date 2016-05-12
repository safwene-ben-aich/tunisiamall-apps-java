/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.entities;

import java.util.Date;
import edu.esprit.tunisiamall.entities.Thread;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import edu.esprit.tunisiamall.entities.Client;
/**
 *
 * @author Max
 */
public class Comment {
    private int id;
    private Client author;
    private Thread thread;
    private String body;
    private String ancestor;
    private int depth;
    private  String created_at;
    private int state;
    private int score;

    public Comment(Thread thread, String body) {
        this.thread = thread;
        this.body = body;
        this.ancestor="";
        this.depth=0;
        Date datenow=new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
   this.created_at =ft.format(datenow);
      System.out.println("Current Date: " +this.created_at);
      this.state=0;
      this.score=0;
        
        
       // this.created_at=LocalDateTime.now();
        
        
    }

    public Comment(int id, Client author, Thread thread, String body) {
        this.id = id;
        this.author = author;
        this.thread = thread;
        this.body = body;
    }

    public Comment(Client author, Thread thread, String body) {
        this.author = author;
        this.thread = thread;
        this.body = body;
         this.ancestor="";
        this.depth=0;
        Date datenow=new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
   this.created_at =ft.format(datenow);
      System.out.println("Current Date: " +this.created_at);
      this.state=0;
      this.score=0;
        
        
    }

    public Comment(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAncestor() {
        return ancestor;
    }

    public void setAncestor(String ancestor) {
        this.ancestor = ancestor;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Client getAuthor() {
        return author;
    }

    public void setAuthor(Client author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", author=" + author + ", thread=" + thread + ", body=" + body + ", ancestor=" + ancestor + ", depth=" + depth + ", created_at=" + created_at + ", state=" + state + ", score=" + score + '}';
    }

    
    
    
}
