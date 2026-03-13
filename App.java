import javax.swing.*;
public class App 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				// Initialize the object of RockPaperScissorGUI
				RockPaperScissorGUI rockPaperScissorGUI = new RockPaperScissorGUI();
				
				// show the GUI
				rockPaperScissorGUI.setVisible(true);
			}
		});
	}
}
