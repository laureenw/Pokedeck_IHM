package pokedeckui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeckgame.Pokedeck;
import pokedeckgame.PokemonType;

public class AddCardPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	String pokemon_type = "";
	JFileChooser chooser;
	String pokemon_image;
	String nameCard = "";
	
	JComboBox pokemon_types_combo;
	JLabel pokemon_type_label;
	JTextField cardname_field;
	JLabel cardname_label;
	JLabel card;
	JButton addCardbutton;
	JPanel button_addcardpanel;
	JPanel card_addcardpanel;
	JLabel choice_image_label;
	JButton choice_image_button;
	
	public AddCardPanel() {
		cardname_label = new JLabel("Card name");
		cardname_field = new JTextField(10);
		pokemon_type_label = new JLabel("Choose a pokemon type");
		pokemon_types_combo = new JComboBox();
		pokemon_types_combo.addItem(""+PokemonType.grass);
		pokemon_types_combo.addItem(""+PokemonType.fire);
		pokemon_types_combo.addItem(""+PokemonType.water);
		pokemon_types_combo.addItem(""+PokemonType.lightning);
		pokemon_types_combo.addItem(""+PokemonType.psychic);
		pokemon_types_combo.addItem(""+PokemonType.fighting);
		pokemon_types_combo.addItem(""+PokemonType.darkness);
		pokemon_types_combo.addItem(""+PokemonType.metal);
		pokemon_types_combo.addItem(""+PokemonType.fairy);
		pokemon_types_combo.addItem(""+PokemonType.dragon);
		pokemon_types_combo.addItem(""+PokemonType.colorless);
		pokemon_types_combo.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pokemon_type = String.valueOf(pokemon_types_combo.getSelectedItem());							
			}
			
		});
		
		choice_image_label = new JLabel("Choose an image");
		choice_image_button = new JButton("Loading");
		choice_image_button.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser("./src/main/resources/");
				chooser.setAccessory(new FilePreview(chooser));
				chooser.showOpenDialog(null);
				pokemon_image = chooser.getSelectedFile().toString();
			}
			
		});
			
		card = new JLabel("Your card : ");
		addCardbutton = new JButton("Add");
		addCardbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameCard = cardname_field.getText();
				if (pokedeck.getCollectCard().toString().contains(nameCard)) {
					card.setText("Your collection already contains\n the name card, please enter again");
				} else {
					pokedeck.setNameCard(nameCard, pokemon_type, pokemon_image);
					pokedeck.addCard();
					card.setText("Your card : " + (cardname_field.getText() == null ? "" : pokedeck.getMyCard()));
					pokedeck.writeCollectCardInFile();	
				}
			}
		});
											
	principalcontent.addCardPanel = new JPanel();
	principalcontent.addCardPanel.add(cardname_label);
	principalcontent.addCardPanel.add(cardname_field);
	principalcontent.addCardPanel.add(pokemon_type_label);
	principalcontent.addCardPanel.add(pokemon_types_combo);
	principalcontent.addCardPanel.add(choice_image_label);
	principalcontent.addCardPanel.add(choice_image_button);
	button_addcardpanel = new JPanel(new FlowLayout());
	card_addcardpanel = new JPanel(new FlowLayout());
	button_addcardpanel.add(addCardbutton);
	card_addcardpanel.add(card);
	}

}
