package pokedeckui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pokedeckgame.Pokedeck;

public class SeeCollectionPanel {
	
	Pokedeck pokedeck = new Pokedeck();
	PrincipalContent principalcontent = new PrincipalContent();
	String file_pokemon;
	
	JLabel collection;
	JButton previous;
	JButton next;
	JPanel cards;
	JPanel images;
	CardPanel p;
	ImagePanel im;
	JPanel control;
	
	public SeeCollectionPanel() {
		pokedeck.readCollectCardInFile();
		collection = new JLabel("Your collection : ");
		collection.setText("Your collection : " + pokedeck.getCollectCard());				
		
		principalcontent.seeCollectionPanel = new JPanel();
		principalcontent.seeCollectionPanel.add(collection);
						
		cards = new JPanel(new CardLayout());
		images = new JPanel(new CardLayout());
					
		for (int i=0; i < pokedeck.getCollectCard().size(); i++) {
			p = new CardPanel(""+pokedeck.getCollectCard().get(i));
			cards.add(p);
			file_pokemon = pokedeck.getCollectCard().get(i).toString();
			file_pokemon = file_pokemon.substring(file_pokemon.indexOf("resources")+10);
			im = null;
			try {
				im = new ImagePanel(ImageIO.read(this.getClass().getClassLoader().getResource(""+file_pokemon)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			images.add(im);
		}
		
		control = new JPanel();
        control.add(new JButton(new AbstractAction("\u22b2Prev") {

            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.previous(cards);
                CardLayout c2 = (CardLayout) images.getLayout();
                c2.previous(images);
            }
        }));
        control.add(new JButton(new AbstractAction("Next\u22b3") {

            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.next(cards);
                CardLayout c2 = (CardLayout) images.getLayout();
                c2.next(images);
            }
        }));
	}
}
