package dcc025.genius;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
    
    public static void Board() {
        JFrame board = new JFrame("Genius");
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JButton("Button1"));
        panel.add(new JButton("Button2"));
        panel.add(new JButton("Button3"));
        panel.add(new JButton("Button4"));
        
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(500,500);
        board.getContentPane().add(panel);
        board.setVisible(true);
    }
    
    public static void main(String[] args) {
        Board();
    }
    
}
