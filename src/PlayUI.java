import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PlayUI extends JFrame {
    public PlayUI(Character player, Enemy enemy) {
        // Card
        Ncard card1 = new Ncard(null, 0, 0, 0, 0);
        card1.setCardName("Attack");
        card1.setDamage(8);
        card1.setCardCost(1);

        Ncard card2 = new Ncard(null, 0, 0, 0, 0);
        card2.setCardName("Heal & Defend");
        card2.setHeal(10);
        card2.setBlock(10);
        card2.setCardCost(2);

        Ncard ecard = new Ncard(null, 0, 0, 0, 0);
        ecard.setCardName("Enemy Action");
        ecard.setDamage(10);

        // Energy
        Energy turn = new Energy();
        turn.setEnergy(3);
        turn.setMaxEnergy(3);

        JFrame PlayUI = new JFrame();
        setTitle("Slay the Spire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create a label
        JLabel charname = new JLabel("Player\t: "+player.getCharName());
        JLabel hp = new JLabel("HP  \t: "+String.valueOf(player.getHealth()));
        JLabel block = new JLabel("Block\t: "+String.valueOf(player.getCblock()));
        
        JLabel enemyname = new JLabel("Player\t: "+enemy.getCharName());
        JLabel hp2 = new JLabel("HP  \t: "+String.valueOf(enemy.getHealth()));
        JLabel block2 = new JLabel("Block\t: "+String.valueOf(enemy.getCblock()));
        
        JLabel detail1 = new JLabel("<html><br>"+card1.getCardName()+" ("+card1.getCardCost()
                                    +")</br><br>Deals "+card1.getDamage()+" damage</br><br>Heal "
                                    +card1.getHeal()+" HP</br><br>Gain "+card1.getBlock()+" Block</br></html>");
        JLabel detail2 = new JLabel("<html><br>"+card2.getCardName()+" ("+card2.getCardCost()
                                    +")</br><br>Deals "+card2.getDamage()+" damage</br><br>Heal "
                                    +card2.getHeal()+" HP</br><br>Gain "+card2.getBlock()+" Block</br></html>");
        JLabel detail3 = new JLabel(String.valueOf("Energy : ("+turn.getEnergy()+"/"+turn.getMaxEnergy()+")"));
        
        // Create buttons
        JButton card1Button = new JButton(card1.getCardName());
        JButton card2Button = new JButton(card2.getCardName());
        JButton endturnButton = new JButton("End Turn");
        
        // Create a panel for the labels and button panel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerPanel.add(charname);
        playerPanel.add(hp);
        playerPanel.add(block);

        playerPanel.add(enemyname);
        playerPanel.add(hp2);
        playerPanel.add(block2);
        
        // // Create a panel for the labels and button panel
        // JPanel enemyPanel = new JPanel();
        // enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.Y_AXIS));
        // enemyPanel.add(enemyname);
        // enemyPanel.add(hp2);
        // enemyPanel.add(block2);

        // Create a panel for button1 and label1
        JPanel panelcard1 = new JPanel();
        panelcard1.setLayout(new BoxLayout(panelcard1, BoxLayout.Y_AXIS));
        panelcard1.add(detail1);
        panelcard1.add(card1Button);

        // Create a panel for button2 and label2
        JPanel panelcard2 = new JPanel();
        panelcard2.setLayout(new BoxLayout(panelcard2, BoxLayout.Y_AXIS));
        panelcard2.add(detail2);
        panelcard2.add(card2Button);

        // Create a panel for button2 and label2
        JPanel panelcard3 = new JPanel();
        panelcard3.setLayout(new BoxLayout(panelcard3, BoxLayout.Y_AXIS));
        panelcard3.add(detail3);
        panelcard3.add(endturnButton);

        // Create a panel for card1 and card2 buttons
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cardPanel.add(panelcard1);
        cardPanel.add(panelcard2);

        // Create a panel for endturn button and cardPanel
        JPanel actionSouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        actionSouthPanel.add(cardPanel);
        actionSouthPanel.add(panelcard3);

        // Create a panel for the labels, buttons, and actionSouthPanel
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(playerPanel, BorderLayout.CENTER);
        // contentPane.add(enemyPanel, BorderLayout.CENTER);
        contentPane.add(actionSouthPanel, BorderLayout.SOUTH);
        
        // Add the content pane to the frame
        setContentPane(contentPane);

        // Add ActionListeners to buttons
        card1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for card1
                // Cek apa jumlah energy yang dimiliki cukup
                if (checkNeeds(turn.getEnergy(),card1.getCardCost())){
                    // Pemberitahuan efek card (damage)
                    JOptionPane.showMessageDialog(PlayUI,player.getCharName()+" deals "
                    +card1.getDamage()+" damage!", "Effect", JOptionPane.WARNING_MESSAGE);
                    
                    // Kalkulasi efek card
                    enemy.setHealth(enemy.damage(enemy.getHealth(),card1.getDamage(),enemy.getCblock()));
                    turn.setEnergy(turn.reduce(turn.getEnergy(),card1.getCardCost()));

                    SwingUtilities.invokeLater(() -> {
                        hp2.setText("HP  \t: "+String.valueOf(enemy.getHealth()));
                        block2.setText("Block\t: "+String.valueOf(enemy.getCblock()));
                        detail3.setText("Energy : ("+String.valueOf(turn.getEnergy()+")"));
                    });
                }

                // Pemberitahuan energy tidak cukup
                else{
                    JOptionPane.showMessageDialog(PlayUI,"Not enough energy!", "Effect", JOptionPane.WARNING_MESSAGE);
                }

                if (player.getHealth()<=0||enemy.getHealth()<=0) {
                    JOptionPane.showMessageDialog(PlayUI,"Congratulations you've reached the end of the current development!", "Game Over", JOptionPane.WARNING_MESSAGE);
                    PlayUI.dispose(); // Close the frame
                    System.exit(0); // Stop the program
                }
            }
        });

        card2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for card2
                // Cek apa jumlah energy yang dimiliki cukup
                if (checkNeeds(turn.getEnergy(),card1.getCardCost())){
                    // Pemberitahuan efek card (damage)
                    JOptionPane.showMessageDialog(PlayUI,"<html><br>"+player.getCharName()+" healed for "+card2.getHeal()
                    +"</br><br>"+player.getCharName()+" block increased by "+card2.getBlock()+" to "
                    +(card2.getBlock()+player.getCblock())+" Block!</br></html>", "Effect", JOptionPane.WARNING_MESSAGE);
                    
                    // Kalkulasi efek card
                    player.setHealth(player.heal(player.getHealth(),card2.getHeal()));
                    player.setCblock(player.getCblock()+card2.getBlock());
                    turn.setEnergy(turn.reduce(turn.getEnergy(),card2.getCardCost()));

                    SwingUtilities.invokeLater(() -> {
                        hp.setText("HP  \t: "+String.valueOf(player.getHealth()));
                        block.setText("Block\t: "+String.valueOf(player.getCblock()));
                        detail3.setText("Energy : ("+String.valueOf(turn.getEnergy()+")"));
                    });
                }

                // Pemberitahuan energy tidak cukup
                else{
                    JOptionPane.showMessageDialog(PlayUI,"Not enough energy!", "Effect", JOptionPane.WARNING_MESSAGE);
                }

                if (player.getHealth()<=0||enemy.getHealth()<=0) {
                    JOptionPane.showMessageDialog(PlayUI,"Congratulations you've reached the end of the current development!", "Game Over", JOptionPane.WARNING_MESSAGE);
                    PlayUI.dispose(); // Close the frame
                    System.exit(0); // Stop the program
                }
            }
        });

        endturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for endturn
                // Turn di-akhiri (energy di-reset menjadi penuh)
                turn.reset(turn.getMaxEnergy());

                JOptionPane.showMessageDialog(PlayUI,"<html><br>You ended your turn!</br><br>"
                +enemy.getCharName()+" deals "+ecard.getDamage()+" damage!</br></html>", "Turn Ended", JOptionPane.WARNING_MESSAGE);
                
                // Enemy mendapat giliran (menyerang balik)
                player.setHealth(player.damage(player.getHealth(),ecard.getDamage(),player.getCblock()));

                SwingUtilities.invokeLater(() -> {
                    hp.setText("HP  \t: "+String.valueOf(player.getHealth()));
                    detail3.setText("Energy : ("+String.valueOf(turn.getEnergy()+")"));
                });

                if (player.getHealth()<=0||enemy.getHealth()<=0) {
                    JOptionPane.showMessageDialog(PlayUI,"Congratulations you've reached the end of the current development!", "Game Over", JOptionPane.WARNING_MESSAGE);
                    PlayUI.dispose(); // Close the frame
                    System.exit(0); // Stop the program
                }
            }
        });

        setVisible(true); // Make the frame visible
    }

    // Method cek kecukupan energy
    boolean checkNeeds(int energy,int cost){
        boolean result = (energy >= cost);
	    return (result);
    }
}