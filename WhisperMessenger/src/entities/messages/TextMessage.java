package entities.messages;

import entities.User;

import java.awt.*;
import java.awt.geom.Point2D;
import java.time.LocalDate;

public class TextMessage implements Message {
    private String text;
    private User user;
    private LocalDate date;
    private Point2D position;
    private boolean visibele;

    public TextMessage(String text, User user, LocalDate date) {
        this.text = text;
        this.user = user;
        this.date = date;
    }

    @Override
    public void draw(Graphics2D g2d) {
    }
}
