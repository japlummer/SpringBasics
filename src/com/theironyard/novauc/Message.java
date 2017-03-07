package com.theironyard.novauc;

/**
 * Created by JacobP on 3/2/17.
 */
public class Message {
    int id;
    int replyId;
    String user;
    String text;
    String post;

    public Message(int id, int replyId, String user, String text, String post) {
        this.id = id;
        this.replyId = replyId;
        this.user = user;
        this.text = text;
        this.post = post;
    }


    public Message(Message text) {

    }


    public Message(User user, String text) {

    }
}
