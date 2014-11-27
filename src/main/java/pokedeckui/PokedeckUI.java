/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeckgame.Card;
import pokedeckgame.Player;
import pokedeckgame.Pokedeck;
import pokedeckgame.PokemonType;
import pokedeckgame.UserChoice;

/**
 * class PokedeckUI : contains GUI, what the user sees, menus and questions available to the user
 * Scanner : used to read keyboard input
 * Player p : contains the current player 
 * int numCard : initializing card number to zero
 * String nameCard : initializing card name to blank
 * int numCardSearch : number of card searched
 * Sring nameCardSearch : name of card searched
 * user_choice : related to the user choice
 */
public class PokedeckUI extends JFrame{
	
	JFrame window;	
	
	/**
	 * request the player name
	 * initializing a new player with name
	 * send the player name to class Pokedeck
	 * while stop different to false, display menu
	 */
	public void start() {
		window = new JFrame();
		window.setLocationRelativeTo(null);
		
		Menu menu = new Menu();
		window.setJMenuBar(menu.menuBar);
		
		final PrincipalContent principalcontent = new PrincipalContent();
		final PrincipalPanel principalpanel = new PrincipalPanel();
		
		window.getContentPane().add(principalpanel.principalcontent.principalPanel, BorderLayout.PAGE_START);
		window.getContentPane().add(principalpanel.file_panel, BorderLayout.CENTER);
		window.getContentPane().add(principalpanel.button_panel, BorderLayout.PAGE_END);
		
		//addCard panel
		menu.addCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				AddCardPanel addcardpanel = new AddCardPanel();
				
				window.getContentPane().removeAll();
				window.getContentPane().add(addcardpanel.principalcontent.addCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(addcardpanel.card_addcardpanel, BorderLayout.CENTER);
				window.getContentPane().add(addcardpanel.button_addcardpanel, BorderLayout.PAGE_END);
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
			}
		});
		
		//removeCard panel
		menu.removeCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveCardPanel removecardpanel = new RemoveCardPanel();
				
				window.getContentPane().removeAll();
				window.getContentPane().add(removecardpanel.principalcontent.removeCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(removecardpanel.card_removecardpanel, BorderLayout.CENTER);
				window.getContentPane().add(removecardpanel.button_removecardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
			}
		});
			
		//modifyCard panel
		menu.modifyCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyCardPanel modifycardpanel = new ModifyCardPanel();
				
				window.getContentPane().removeAll();
				window.getContentPane().add(modifycardpanel.principalcontent.modifyCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(modifycardpanel.card_modifycardpanel, BorderLayout.CENTER);
				window.getContentPane().add(modifycardpanel.button_modifycardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
			}
		});
				
		//seeCollection panel
		menu.seeCollection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeCollectionPanel seecollectionpanel = new SeeCollectionPanel();
			       
				window.getContentPane().removeAll();
				window.getContentPane().add(seecollectionpanel.cards, BorderLayout.PAGE_START);
				window.getContentPane().add(seecollectionpanel.images, BorderLayout.CENTER);
				window.add(seecollectionpanel.control, BorderLayout.SOUTH);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();	
			}
		});
		
		//searchCard panel
		menu.searchCard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				SearchCardPanel searchcardpanel = new SearchCardPanel();
				
				window.getContentPane().removeAll();
				window.getContentPane().add(searchcardpanel.principalcontent.searchCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(searchcardpanel.card_searchcardpanel, BorderLayout.CENTER);
				window.getContentPane().add(searchcardpanel.button_searchcardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
			}
		});
		
		//saveCollection panel
		menu.saveCollection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveCollectionPanel savecollectionpanel = new SaveCollectionPanel();
								
				window.getContentPane().removeAll();
				window.getContentPane().add(savecollectionpanel.principalcontent.saveCollectionPanel, BorderLayout.PAGE_START);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();						
			}
		});
		
		//uploadCollection panel
		menu.uploadCollection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadCollectionPanel uploadcollectionpanel = new UploadCollectionPanel();
								
				window.getContentPane().removeAll();
				window.getContentPane().add(uploadcollectionpanel.principalcontent.uploadCollectionPanel, BorderLayout.PAGE_START);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();	
			}
		});

		//quit
		menu.stop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
				
		window.pack();
	    window.setVisible(true);
	}
}