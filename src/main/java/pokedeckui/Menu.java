package pokedeckui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pokedeckgame.UserChoice;

public class Menu {
	
	JMenuBar menuBar;
	JMenu actions;
	JMenuItem addCard, removeCard, modifyCard, seeCollection, searchCard, saveCollection, uploadCollection, stop;
	
	public Menu() {
		menuBar = new JMenuBar();
		actions = new JMenu("Actions");
		addCard = new JMenuItem(""+UserChoice.AddCard);
		removeCard = new JMenuItem(""+UserChoice.RemoveCard);
		modifyCard = new JMenuItem(""+UserChoice.ModifyCard);
		seeCollection = new JMenuItem(""+UserChoice.SeeCollection);
		searchCard = new JMenuItem(""+UserChoice.SearchCard);
		saveCollection = new JMenuItem(""+UserChoice.SaveCollection);
		uploadCollection = new JMenuItem(""+UserChoice.UploadCollection);
		stop = new JMenuItem(""+UserChoice.Stop);
		actions.add(addCard);
		actions.add(removeCard);
		actions.add(modifyCard);
		actions.add(seeCollection);
		actions.add(searchCard);
		actions.add(saveCollection);
		actions.add(uploadCollection);
		actions.add(stop);
		menuBar.add(actions);
	}
}
