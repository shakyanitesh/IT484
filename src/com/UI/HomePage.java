package com.UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -386551712892064216L;

	
	//Singleton Pattern
	private static HomePage instance;
	
	private JCheckBox[] checkboxes;
	private boolean player2;
	private int numOfBoxes;
	JComboBox<Object> gridList;
	
	//Private Constructor
	private HomePage(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		checkboxes = new JCheckBox[2];
		addImage();
		addCheckBoxes();
		addDropDown();
		addButton();
	}
	
	
	public static HomePage getInstance(){
		if(instance == null){
			instance = new HomePage();
		}
		return instance;
	}
	
	private void addImage(){
		JLabel image = new JLabel(new ImageIcon("board.png"));
		this.add(image);
	}
	
	private void addCheckBoxes(){
		Dimension d = new Dimension(200,40);
		String[] texts = {"Player Vs Player", "Player Vs AI"};
		ButtonGroup bg1 = new ButtonGroup( );
		int i = 0;
		for(String text : texts){
			checkboxes[i] = new JCheckBox(text);
			checkboxes[i].setSize(d);
			checkboxes[i].setMinimumSize(d);
			checkboxes[i].setMaximumSize(d);
			checkboxes[i].setPreferredSize(d);
			this.add(checkboxes[i]);
			bg1.add(checkboxes[i]);
			i++;
		}
	}
	
	private void addDropDown(){
		Dimension d = new Dimension(200,40);
		String[] Grid = {"","2x2", "3x3" , "4x4", "5x5", "6x6", "7x7", "8x8", "9x9","10x10"};
		gridList = new JComboBox<Object>(Grid);
		gridList.setSelectedIndex(0);
		gridList.setVisible(true);
		gridList.setSize(d);
		gridList.setMinimumSize(d);
		gridList.setMaximumSize(d);
		gridList.setPreferredSize(d);
		this.add(gridList);
		
	}
	
	private void addButton(){
		Dimension d = new Dimension(200,40);
		JButton start = new JButton("START");
		start.setSize(d);
		start.setMinimumSize(d);
		start.setMaximumSize(d);
		start.setPreferredSize(d);
		this.add(start);
		
		class ButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals ("START")){
					player2 = checkboxes[0].isSelected();
					String num = ((String)gridList.getSelectedItem()).split("x")[0];
					numOfBoxes = Integer.parseInt(num);
					
					Runner.getGame(numOfBoxes, player2);
					
				}
			}
			
		}
		start.addActionListener(new ButtonListener());
	}
	
}

