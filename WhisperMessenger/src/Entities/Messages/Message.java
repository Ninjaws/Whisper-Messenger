package Entities.Messages;

import Entities.User;

import java.io.Serializable;

public class Message implements Serializable {
    private User user;
    private String text;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
}
