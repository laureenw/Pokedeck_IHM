package pokedeckui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pokedeckgame.Player;
import pokedeckgame.Pokedeck;

public class UploadCollectionPanel {
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	Player p;
	
	JLabel uploadcollection;
	
	public UploadCollectionPanel() {
		uploadcollection = new JLabel("Loading file : ");
		uploadcollection.setText("Loading file : " +pokedeck.getP().getName()+".txt");
		pokedeck.readCollectCardInFile();
																
		principalcontent.uploadCollectionPanel = new JPanel();
		principalcontent.uploadCollectionPanel.add(uploadcollection);
	}
}
