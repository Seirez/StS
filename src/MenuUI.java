import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame {
    public MenuUI() {
        setTitle("Slay the Spire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create buttons
        JButton playButton = new JButton("Play");
        playButton.setBounds(100, 50, 250, 100);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 100, 250, 100);

        // Add action listeners to buttons
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open another frame when the Play button is clicked
                new CharacterSelectionUI();
                setVisible(false); // Hide the current frame
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application when the Exit button is clicked
            }
        });

        // Create panel and add buttons
        JPanel panel = new JPanel();
        panel.add(playButton);
        panel.add(exitButton);

        // Add panel to the frame
        getContentPane().add(panel);

        setVisible(true); // Make the frame visible
    }
}