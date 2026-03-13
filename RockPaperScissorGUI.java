import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// frontend
public class RockPaperScissorGUI extends JFrame implements ActionListener
{
	// GUI Buttons:
	JButton rockButton, paperButton, scissorButton;
	
	// will display the choice of the computer:
	JLabel computerChoice;
	
	// will display the scores of computer and the player
	JLabel computerScoreLabel, playerScoreLabel;
	
	// backend object
	RockPaperScissor rockPaperScissor;
	
	public RockPaperScissorGUI()
	{
		// invoke the constructor of JFrame and title to the GUI:
		super("Rock Paper Scissor");
		
		// set the size of the GUI:
		setSize(450, 574);
		
		// set layout to null to to disable layout management, so we can use absolute positioning for the elememts
		// (i.e setting x, y coordinates and width/height values)
		setLayout(null);
		
		//terminate the java virtual machine on closing the GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// load GUI in the center of the screen everytime we run the project:
		setLocationRelativeTo(null);
		
		// initialize the backened object
		rockPaperScissor = new RockPaperScissor();
		
		// Add GUI Components:
		addGuiComponents();
	}
	public void addGuiComponents()
	{
		// create computer score label
		computerScoreLabel = new JLabel("Computer: 0");
		
		// set x, y coordinates and width and height values
		computerScoreLabel.setBounds(0, 43, 450, 30);
		
		// set the font to have a font family dialog, font-weight of bold and font-size 26:
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		
		// place the text into the center:
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// change the colour of the computer score label to red:
		computerScoreLabel.setForeground(Color.RED); 

		// add to GUI
		add(computerScoreLabel);
		
		// create computer Choice:
		computerChoice = new JLabel("?");
		computerChoice.setBounds(175, 118, 98, 81);
		computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
		computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		
		// create a block border
		computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(computerChoice);
		
		// create a player score label
		playerScoreLabel = new JLabel("Player: 0");
		playerScoreLabel.setBounds(0, 317, 450, 30);
		playerScoreLabel.setFont(new Font("Dialog",  Font.BOLD, 26));
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreLabel.setForeground(Color.GREEN);
		add(playerScoreLabel);
		
		// player Buttons
		
		// 1. rock button: 
		rockButton = new JButton("Rock");
		rockButton.setBounds(40, 387, 105, 81);
		rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		rockButton.setBackground(Color.GRAY);
		rockButton.addActionListener(this);
		add(rockButton);
		
		
		// 2. Paper button: 
		paperButton = new JButton("Paper");
		paperButton.setBounds(165, 387, 105, 81);
		paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		paperButton.setBackground(Color.CYAN);
		paperButton.addActionListener(this);
		add(paperButton);
		
		// 3. Scissor button: 
		scissorButton = new JButton("Scissors");
		scissorButton.setBounds(290, 387, 105, 81);
		scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		scissorButton.setBackground(Color.PINK);
		scissorButton.addActionListener(this);
		add(scissorButton);
	}
	
	// displays a button which will show the winner and the try again message:
	private void showDialog(String message)
	{
		JDialog resultDialog = new JDialog(this, "Result", true);
		resultDialog.setSize(227, 124);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setResizable(false);
		
		// message the Label
		JLabel resultLabel = new JLabel(message);	 
		resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultDialog.add(resultLabel, BorderLayout.CENTER);
		
		// try again button
		JButton tryAgainButton = new JButton("Try Again?");
		tryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// reset computer choice
				computerChoice.setText("?");
				
				// close the dialog box
				resultDialog.dispose();
			}	
		});	
		resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
		resultDialog.setLocationRelativeTo(this);
		resultDialog.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// get player choice
		String playerChoice = e.getActionCommand().toString();
		
		// Play rock, paper and scissor. and store the result into a String var
		String result = rockPaperScissor.playRockPaperScissor(playerChoice);
		
		// load computer's choice
		 computerChoice.setText(rockPaperScissor.getComputerChoice()); 	
		 
		 // update Score
		 computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
		 playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());
		 
		 // Display result dialog:
		 showDialog(result); 
	}
}
