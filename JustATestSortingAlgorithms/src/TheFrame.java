import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;
public class TheFrame extends JFrame{
	
	private JButton button;
	private JButton submit;
	private JLabel name;
	private JLabel amount;
	private JTextField textArea;
	private JTextArea asd;
	private static int counterForClicked = 0;
	
	public TheFrame(){
		createFrame();
		setSize(455,455);
		setTitle("Testing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		 	}
	
	class draw extends JComponent{
		
		public void paintT(Graphics g){
			g.fillRect(4, 8, 24, 12);
			g.fillRect(2, 8, 24, 12);
			g.fillRect(4, 8, 24, 12);
			g.fillRect(12, 8, 24, 12);
		}
	}

	private void createFrame() {
		// TODO Auto-generated method stub
		button = new JButton("Hi");
		submit = new JButton("submit query");
		name = new JLabel("Users Name");
		amount = new JLabel("Total Amount");
		asd = new JTextArea(20,40);
		int wid = 24;
		textArea = new JTextField(wid);
		JPanel pa = new JPanel();
		ActionListener li = new itsClicked();
		submit.addActionListener(li);
		pa.add(button);
	 
		pa.add(textArea);
		pa.add(submit);
		pa.add(name);
		pa.add(asd);
		pa.add(amount);
		add(pa);
		
		System.out.println(textArea.getText());
		
	}
	
	class itsClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			counterForClicked ++;
		textArea.setText("I was clicked " + counterForClicked);
		
		System.out.println(textArea.getText());
			
			
		}
		
		
	}

}
