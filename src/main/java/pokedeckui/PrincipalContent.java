package pokedeckui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PrincipalContent {
	
	JPanel principalPanel;
	JPanel addCardPanel;
	JPanel removeCardPanel;
	JPanel modifyCardPanel;
	JPanel seeCollectionPanel;
	JPanel searchCardPanel;
	JPanel saveCollectionPanel;
	JPanel uploadCollectionPanel;
	BorderLayout login;
	
	public PrincipalContent() {
		principalPanel = new JPanel();
		login = new BorderLayout();
	}

}
