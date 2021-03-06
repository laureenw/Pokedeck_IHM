package pokedeckui;

import java.io.File; 
import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.text.*;

public class FilePreview extends JPanel implements PropertyChangeListener{
	private JFileChooser chooser;
	private JLabel nom, taille, date, icone, description;
	public FilePreview(JFileChooser chooser){
		super(new GridLayout(0,1));	
		
		add(icone = new JLabel("Ic�ne du fichier"));
		add(description = new JLabel("Description du fichier"));
		add(nom = new JLabel("Nom du fichier"));
		add(taille = new JLabel("Taille du fichier"));
		add(date = new JLabel("Derni�re mod. du fichier"));
		
		this.chooser = chooser;
		this.chooser.addPropertyChangeListener(this);
		setBorder(new TitledBorder("Preview"));
	}
	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();
		
		if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)){
			
			File file = (File) e.getNewValue();
			if(file == null){
				clear();
				return;	
			}
			
			FileSystemView vueSysteme = FileSystemView.getFileSystemView(); 
			Locale locale = Locale.getDefault();
			NumberFormat nf = NumberFormat.getInstance(locale);
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			
			icone.setIcon(vueSysteme.getSystemIcon(file));
			
			nom.setText(vueSysteme.getSystemDisplayName(file));
			
			description.setText(vueSysteme.getSystemTypeDescription(file));
			
			String tailleFile = nf.format(file.length()/1024.0)+" Kb";
			taille.setText(tailleFile);
			
			String dateFile = dateFormat.format(new Date(file.lastModified()));
			date.setText("Derni�re mod : "+dateFile);
			
		}else{
			clear();	
		}
	}
	private void clear(){
		icone.setIcon(null);
		nom.setText("Nom du fichier");	
		description.setText("Description fichier");
		taille.setText("Taille du fichier");	
		date.setText("Derni�re mod. du fichier");
	}
	
}
