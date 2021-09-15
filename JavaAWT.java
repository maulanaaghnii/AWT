import java.awt.*;
import java.awt.event.*;



public class JavaAWT{

		private Frame mainFrame;
		private Label headerLabel;
		private Label statusLabel;
		private Panel controlPanel;


	private void prepareGUI(){

		mainFrame = new Frame("demo");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter(){	
			//Close Windows back to OS
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		}

		);
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());


		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);

		
	}
	private void ShowEventDemo(){

		headerLabel.setText("Demo Control on Button");
		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancle");

		okButton.addActionListener(new ButtonClickListener());
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);
		mainFrame.setVisible(true);
	}

	public class ButtonClickListener implements ActionListener{


		public void actionPerformed(ActionEvent e){

			String command = e.getActionCommand();

			if (command.equals("ok")) {
				
				statusLabel.setText("Ok Button clicked");
			}
			else if (command.equals("Submit")) {
				statusLabel.setText("Submit Button clicked");
			}
			else{
				statusLabel.setText("Cancel Button clicked");
			}

		}
	}

	public static void main(String[] args) {
		JavaAWT demo = new JavaAWT();
		demo.prepareGUI();
		demo.ShowEventDemo();
	}

}