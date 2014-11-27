package pokedeckui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeckgame.Player;
import pokedeckgame.Pokedeck;
import pokedeckgame.PokemonType;

public class ModifyCardPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	Scanner scanner = new Scanner(System.in);
	int numCard = 0;
	String nameCard = "";
	String pokemon_type = "";
	String pokemon_image;
	BufferedImage image = null;
	JFileChooser chooser;
	
	JComboBox pokemon_types_combo_modif;
	JLabel pokemon_type_label_modif;
	JTextField modifycard_field;
	JLabel modifycard_label;
	JLabel cardmodify;
	JTextField modifycardname_field;
	JLabel modifycardname_label;
	JButton modifyCardbutton;
	JPanel button_modifycardpanel;
	JPanel card_modifycardpanel;
	JLabel choice_image_label_modif;
	JButton choice_image_button_modif;
	
	public ModifyCardPanel() {
		modifycard_label = new JLabel("Enter card number you want to update");
		modifycard_field = new JTextField(10);
		modifycardname_label = new JLabel("New card name : ");
		modifycardname_field = new JTextField(10);
		pokemon_type_label_modif = new JLabel("Choose a new pokemon type");
		pokemon_types_combo_modif = new JComboBox();
		pokemon_types_combo_modif.addItem(""+PokemonType.grass);
		pokemon_types_combo_modif.addItem(""+PokemonType.fire);
		pokemon_types_combo_modif.addItem(""+PokemonType.water);
		pokemon_types_combo_modif.addItem(""+PokemonType.lightning);
		pokemon_types_combo_modif.addItem(""+PokemonType.psychic);
		pokemon_types_combo_modif.addItem(""+PokemonType.fighting);
		pokemon_types_combo_modif.addItem(""+PokemonType.darkness);
		pokemon_types_combo_modif.addItem(""+PokemonType.metal);
		pokemon_types_combo_modif.addItem(""+PokemonType.fairy);
		pokemon_types_combo_modif.addItem(""+PokemonType.dragon);
		pokemon_types_combo_modif.addItem(""+PokemonType.colorless);
		pokemon_types_combo_modif.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pokemon_type = String.valueOf(pokemon_types_combo_modif.getSelectedItem());							
			}
			
		});
		
		choice_image_label_modif = new JLabel("Choose an image");
		choice_image_button_modif = new JButton("Loading");
		choice_image_button_modif.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser("./src/main/resources/");
				chooser.setAccessory(new FilePreview(chooser));
				chooser.showOpenDialog(null);
				pokemon_image = chooser.getSelectedFile().toString();
			}
			
		});
		
		cardmodify = new JLabel("Your card : ");
		modifyCardbutton = new JButton("Update");
		modifyCardbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numCard = Integer.parseInt(modifycard_field.getText());
				pokedeck.setNumCard(numCard);
				nameCard = modifycardname_field.getText();
				pokedeck.setNameCard(nameCard, pokemon_type, pokemon_image);
				pokedeck.modifyCard();
				cardmodify.setText("Your card : " + (modifycard_field.getText() == null ? "" : pokedeck.getCardUpdate() + " has been updated in : "+numCard+" "+nameCard+" "+pokemon_type+ " "+pokemon_image));
				pokedeck.writeCollectCardInFile();	
			}
		});
						
	principalcontent.modifyCardPanel = new JPanel();
	principalcontent.modifyCardPanel.add(modifycard_label);
	principalcontent.modifyCardPanel.add(modifycard_field);
	principalcontent.modifyCardPanel.add(modifycardname_label);
	principalcontent.modifyCardPanel.add(modifycardname_field);
	principalcontent.modifyCardPanel.add(pokemon_type_label_modif);
	principalcontent.modifyCardPanel.add(pokemon_types_combo_modif);
	principalcontent.modifyCardPanel.add(choice_image_label_modif);
	principalcontent.modifyCardPanel.add(choice_image_button_modif);
	button_modifycardpanel = new JPanel(new FlowLayout());
	card_modifycardpanel = new JPanel(new FlowLayout());
	button_modifycardpanel.add(modifyCardbutton);
	card_modifycardpanel.add(cardmodify);
	}

}
