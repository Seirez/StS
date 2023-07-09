import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UI extends JFrame implements ActionListener{
    static JFrame frame;
    static JButton button;
    static JLabel label;
    static Character Ironclad = new Character(null, 0, 0);

    public UI(){
        
        // ImageIcon icon = new ImageIcon("point.png");
        // ImageIcon icon2 = new ImageIcon("face.png");
        
        label = new JLabel();
        // label.setIcon(icon2);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);
        
        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(e -> Ironclad.setCharName("Ironclad"));
        button.setText("I'm a button!");
        
        button.setFocusable(false);
        // button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(button);
        frame.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("poo");
            button.setEnabled(false);
            label.setVisible(true);
        }	
    }
}
