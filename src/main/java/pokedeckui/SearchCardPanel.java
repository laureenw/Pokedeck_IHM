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

import pokedeckgame.Card;
import pokedeckgame.Player;
import pokedeckgame.Pokedeck;
import pokedeckgame.PokemonType;

public class SearchCardPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	Scanner scanner = new Scanner(System.in);
	Player p;
	int numCard = 0;
	String nameCard = "";
	int numCardSearch;
	String nameCardSearch;
	String pokemon_type = "";
	String pokemon_type_search;
	String pokemon_image;
	String pokemon_image_search;
	String file_pokemon;
	BufferedImage image = null;
	JFileChooser chooser;
	
	JComboBox pokemon_types_combo_search;
	JLabel pokemon_type_label_search;
	JTextField searchnumcard_field;
	JLabel searchnumcard_label;
	JTextField searchnamecard_field;
	JLabel searchnamecard_label;
	JLabel cardsearch;
	JButton searchCardbutton;
	JPanel button_searchcardpanel;
	JPanel card_searchcardpanel;
	JLabel choice_image_label_search;
	JButton choice_image_button_search;
	
	public SearchCardPanel() {
		pokedeck.readCollectCardInFile();
		searchnumcard_label = new JLabel("Enter card number you want to search");
		searchnumcard_field = new JTextField(10);
		searchnamecard_label = new JLabel("Enter card name you want to search");
		searchnamecard_field = new JTextField(10);
		pokemon_type_label_search = new JLabel("Choose a pokemon type you want to search");
		pokemon_types_combo_search = new JComboBox();
		pokemon_types_combo_search.addItem(""+PokemonType.grass);
		pokemon_types_combo_search.addItem(""+PokemonType.fire);
		pokemon_types_combo_search.addItem(""+PokemonType.water);
		pokemon_types_combo_search.addItem(""+PokemonType.lightning);
		pokemon_types_combo_search.addItem(""+PokemonType.psychic);
		pokemon_types_combo_search.addItem(""+PokemonType.fighting);
		pokemon_types_combo_search.addItem(""+PokemonType.darkness);
		pokemon_types_combo_search.addItem(""+PokemonType.metal);
		pokemon_types_combo_search.addItem(""+PokemonType.fairy);
		pokemon_types_combo_search.addItem(""+PokemonType.dragon);
		pokemon_types_combo_search.addItem(""+PokemonType.colorless);
		pokemon_types_combo_search.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pokemon_type_search = String.valueOf(pokemon_types_combo_search.getSelectedItem());							
			}
			
		});
		
		choice_image_label_search = new JLabel("Choose an image you want to search");
		choice_image_button_search = new JButton("Loading");
		choice_image_button_search.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser("./src/main/resources/");
				chooser.setAccessory(new FilePreview(chooser));
				chooser.showOpenDialog(null);
				pokemon_image_search = chooser.getSelectedFile().toString();
			}
			
		});
		
		cardsearch = new JLabel("Your card : ");
		searchCardbutton = new JButton("Search");
		searchCardbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numCardSearch = Integer.parseInt(searchnumcard_field.getText());
				pokedeck.setNumCardSearch(numCardSearch);
				nameCardSearch = searchnamecard_field.getText();
				pokedeck.setNameCardSearch(nameCardSearch);
				pokemon_type_search = String.valueOf(pokemon_types_combo_search.getSelectedItem());	
				pokedeck.setPokemonTypeSearch(pokemon_type_search);
				pokemon_image_search = chooser.getSelectedFile().toString();
				pokedeck.setPokemon_image_search(pokemon_image_search);
				if (pokedeck.searchCard() == true) {
					cardsearch.setText("Your card : "+ (searchnumcard_field.getText() == null && searchnamecard_field.getText() == null ? "" : new Card(nameCardSearch, numCardSearch, pokemon_type_search, pokemon_image_search).toString()));
				} else {
					cardsearch.setText("Your collection does not contain card : "+new Card(nameCardSearch, numCardSearch, pokemon_type_search, pokemon_image_search).toString());
				}	
			}
		});
						
	principalcontent.searchCardPanel = new JPanel();
	principalcontent.searchCardPanel.add(searchnumcard_label);
	principalcontent.searchCardPanel.add(searchnumcard_field);
	principalcontent.searchCardPanel.add(searchnamecard_label);
	principalcontent.searchCardPanel.add(searchnamecard_field);
	principalcontent.searchCardPanel.add(pokemon_type_label_search);
	principalcontent.searchCardPanel.add(pokemon_types_combo_search);
	principalcontent.searchCardPanel.add(choice_image_label_search);
	principalcontent.searchCardPanel.add(choice_image_button_search);
	button_searchcardpanel = new JPanel(new FlowLayout());
	card_searchcardpanel = new JPanel(new FlowLayout());
	button_searchcardpanel.add(searchCardbutton);
	card_searchcardpanel.add(cardsearch);
	}

}
