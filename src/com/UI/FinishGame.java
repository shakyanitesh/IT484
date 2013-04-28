package com.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.state.SingletonStatus;

public class FinishGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String WINDOW_TITLE = "Game Finished";
	
	private JTextField winnerText;
	private JTextField player1Score;
	private JTextField player2Score;
	
	
	private static FinishGame instance;
	public static FinishGame getInstance(){
		if(instance == null){
			instance = new FinishGame();
		}
		return instance;
	}
	
	private FinishGame(){
		super(WINDOW_TITLE);
		System.out.println("HERE");
		winnerText = new JTextField(JTextField.CENTER);
		winnerText.setText("");
		player1Score = new JTextField(JTextField.CENTER);
		player1Score.setText("");
		player2Score = new JTextField(JTextField.CENTER);
		player2Score.setText("");
		this.getContentPane().add(winnerText);
		this.getContentPane().add(player1Score);
		this.getContentPane().add(player2Score);
		this.setSize(300, 200);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(winnerText);		
		panel.add(player1Score);		
		panel.add(player2Score);
		JButton goTo = new JButton("Go To Home");
		goTo.addActionListener(new ButtonListener());
		panel.add(goTo);
		this.add(panel);
		
		winner();
		this.setVisible(true);
		this.addWindowListener(new WindowEventHandler());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
		
		
	public void winner(){
		if(SingletonStatus.getInstance().getPlayer1Score() > SingletonStatus.getInstance().getPlayer2Score()){
			winnerText.setText("Player 1 wins!");
			player1Score.setText("Player1 Score: " + SingletonStatus.getInstance().getPlayer1Score());
			player2Score.setText("Player2 Score: " + SingletonStatus.getInstance().getPlayer2Score());
		}
		else if (SingletonStatus.getInstance().getPlayer2Score() > SingletonStatus.getInstance().getPlayer1Score()){
			winnerText.setText("Player 2 wins!");
			player1Score.setText("Player1 Score: " + SingletonStatus.getInstance().getPlayer1Score());
			player2Score.setText("Player2 Score: " + SingletonStatus.getInstance().getPlayer2Score());
			
		}
		else{
			winnerText.setText("Game Draw!");
			player1Score.setText("Player1 Score: " + SingletonStatus.getInstance().getPlayer1Score());
			player2Score.setText("Player2 Score: " + SingletonStatus.getInstance().getPlayer2Score());
		}
	}
	
	class WindowEventHandler extends WindowAdapter {
		  public void windowClosing(WindowEvent evt) {
		    Runner.enableWindow();
		  }
		}
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals ("Go To Home")){
				MainPage.closeFinish();
				Runner.enableWindow();
				Runner.getHomePage();
				
			}	
		}
	}
	
	
}
