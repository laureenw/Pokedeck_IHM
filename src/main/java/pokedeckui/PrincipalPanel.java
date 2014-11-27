package pokedeckui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeckgame.Player;
import pokedeckgame.Pokedeck;

public class PrincipalPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	Player p;
	
	JTextField username_field;
	JLabel username_label;
	JLabel file;
	JButton loginbutton;
	JPanel button_panel;
	JPanel file_panel;
	String playerName;
	
	public PrincipalPanel() {
		username_label = new JLabel("Enter your name");
		username_field = new JTextField(10);
		file = new JLabel("Your file : ");
		loginbutton = new JButton("Send");
		loginbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = username_field.getText();
				p = new Player(playerName);
				pokedeck.setP(p);
				file.setText("Your file : " + (username_field.getText() == null ? "" : p.getName()+".txt"));    
			}
		});
				
		principalcontent.principalPanel.add(username_label);
		principalcontent.principalPanel.add(username_field);
		button_panel = new JPanel(new FlowLayout());
		file_panel = new JPanel(new FlowLayout());
		button_panel.add(loginbutton);
		file_panel.add(file);
	}
}
