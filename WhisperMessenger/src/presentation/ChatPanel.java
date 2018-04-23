package presentation;

import entities.messages.Message;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class ChatPanel extends JPanel {

    private HashSet<Message> messages = new HashSet<>();
    private HashSet<Message> visibleMessages = new HashSet<>();

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JFrame jFrame = new JFrame();
        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        jFrame.setContentPane(new ChatPanel());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public ChatPanel() {
        setBackground(new Color(44,47,51));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
    }

}
