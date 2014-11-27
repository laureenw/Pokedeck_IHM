package pokedeckui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeckgame.Pokedeck;

public class RemoveCardPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	int numCard = 0;
	
	JTextField removecard_field;
	JLabel removecard_label;
	JLabel carddelete;
	JButton removeCardbutton;
	JPanel button_removecardpanel;
	JPanel card_removecardpanel;
	
	public RemoveCardPanel() {
		removecard_label = new JLabel("Enter card number you want to delete");
		removecard_field = new JTextField(10);
		carddelete = new JLabel("Your card : ");
		removeCardbutton = new JButton("Delete");
		removeCardbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numCard = Integer.parseInt(removecard_field.getText());
				pokedeck.setNumCard(numCard);
				pokedeck.removeCard();
				carddelete.setText("Your card : " + (removecard_field.getText() == null ? "" : pokedeck.getCardDelete() + " has been removed"));
				pokedeck.writeCollectCardInFile();	
			}
		});
						
	principalcontent.removeCardPanel = new JPanel();
	principalcontent.removeCardPanel.add(removecard_label);
	principalcontent.removeCardPanel.add(removecard_field);
	button_removecardpanel = new JPanel(new FlowLayout());
	card_removecardpanel = new JPanel(new FlowLayout());
	button_removecardpanel.add(removeCardbutton);
	card_removecardpanel.add(carddelete);
	}

}
