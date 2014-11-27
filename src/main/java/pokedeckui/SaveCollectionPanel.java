package pokedeckui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pokedeckgame.Player;
import pokedeckgame.Pokedeck;

public class SaveCollectionPanel {
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	PrincipalPanel principalpanel = new PrincipalPanel();
	Player p;
	
	JLabel savecollection;
	
	public SaveCollectionPanel() {
		System.out.println(principalpanel.username_field.getText().toString());
		savecollection = new JLabel("Backup file : ");
		savecollection.setText("Backup file : " +pokedeck.getP().getName()+".txt");
		pokedeck.writeCollectCardInFile();
																
		principalcontent.saveCollectionPanel = new JPanel();
		principalcontent.saveCollectionPanel.add(savecollection);
	}
}
