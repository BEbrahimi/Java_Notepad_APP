
package notepadapp;
import java.awt.Font;
import javax.swing.*;
public class About extends JFrame{
    
    About(){
        setBounds(100,100,500,400);
        setTitle("About Notepad Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
        setLayout(null);
        
        JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("notepad.png")));
        iconLabel.setBounds(100,70,80,80);
        add(iconLabel);
        
        JLabel textLabel = new JLabel ("<html>Welcome to Notepad <br> Notepad is a simple text editor for microsoft windows and a sbasic text editing program which enables computer users to create documents <br> All rights reseved@2024\n" +
" </html>");
        textLabel.setBounds(50,50,400,300);
        textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        add(textLabel);
        
    }
    
    public static void main(String[] args) {
        new About().setVisible(true);
    }
    
    
    
}
