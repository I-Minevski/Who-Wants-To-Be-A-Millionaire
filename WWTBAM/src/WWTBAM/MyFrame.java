package WWTBAM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame extends JFrame implements ActionListener{
	
	private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10); //Creates the border
	
	private ImageIcon image = new ImageIcon("logo.png"); //Sets the frame icon
	
	// Icons for the lifelines
	private ImageIcon fiftyFifty = new ImageIcon("50_50_50x39.png");
	private ImageIcon phoneFriend = new ImageIcon("phone_50x39.png");
	private ImageIcon askTheAudience = new ImageIcon("audience_50x39.png");
	
	//properties of the main frame
	private JLabel label = new JLabel();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JButton buttonC = new JButton();
	private JButton buttonD = new JButton();
	private JButton buttonFifty = new JButton();
	private JButton buttonAtA = new JButton();
	private JButton buttonPaF = new JButton();
	JButton buttonContinue = new JButton();
	
	// creates an object that contains the questions
	private String[][] questions = new String [5][10];
	private Questions q1 = new Questions(questions);
	Question [] questionArray = new Question[10];
	
	// saves the player's answer
	private String record = "";
	
	// info label for correct/incorrect answer
	private JLabel correctAnswerLabel = new JLabel(); 
	
	private int questionIndex = 1;
	
	//lifelines availability
	private boolean pafAvailable = true;
	private boolean ataAvailable = true;
	private boolean fiftyAvailable = true;
	
	//frame constructor
	MyFrame(Questions q1) {
		
		for(int i=0; i<10; i++) {
			this.questionArray[i] = new Question(this.q1.getQuestions(), i);
		}
		
		this.setTitle("Stani Bogat"); //sets title to the main frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits on close
		this.setSize(750, 500); //sets the size of the main frame
		
		this.setIconImage(image.getImage());
	
		label.setText(""); // set text to label
		label.setBackground(new Color(5,44,113)); // set color to the label
		label.setForeground(Color.white); //set color to the text
		label.setBorder(border); // set the border
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER); // set text alignment
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(15, 100, 700, 100); // set size and place of the label
		
		correctAnswerLabel.setText("");
		correctAnswerLabel.setBounds(225, 300, 700, 100);
		
		buttonA.setBounds(15, 200, 350, 50);
		buttonA.setFocusable(false); // removes the annoying rectangle around the text upon creation of the button
		buttonA.addActionListener(this); // adds functionality to the button
		
		buttonB.setBounds(365, 200, 350, 50);
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		
		buttonC.setBounds(15, 250, 350, 50);
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		
		buttonD.setBounds(365, 250, 350, 50);
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		
		buttonFifty.setBounds(250, 50, 50, 39);
		buttonFifty.setIcon(fiftyFifty);
		buttonFifty.setFocusable(false);
		buttonFifty.addActionListener(this);
		
		buttonAtA.setBounds(350, 50, 50, 39);
		buttonAtA.setIcon(askTheAudience);
		buttonAtA.setFocusable(false);
		buttonAtA.addActionListener(this);
		
		buttonPaF.setBounds(450, 50, 50, 39);
		buttonPaF.setIcon(phoneFriend);
		buttonPaF.setFocusable(false);
		buttonPaF.addActionListener(this);
		
		buttonContinue.setBounds(200, 400, 350, 50);
		buttonContinue.setText("Next Question");
		buttonContinue.setFocusable(false);
		buttonContinue.addActionListener(this);
		buttonContinue.setEnabled(false);
		
		
	}
	
	// add method - makes the frame visible
	public void add() {
		this.setLayout(null);
		this.add(label);
		this.add(correctAnswerLabel);
		this.add(buttonA);
		this.add(buttonB);
		this.add(buttonC);
		this.add(buttonD);
		this.add(buttonFifty);
		this.add(buttonAtA);
		this.add(buttonPaF);
		this.add(buttonContinue);
		this.setVisible(true);
	}
	
	// sets the text of the question label
	public void setLabel(String text) {
		this.label.setText(text);
	}
	
	// sets the text of the buttons 
	public void setButtonA(String text) {
		this.buttonA.setText(String.format("A: %s", text)); 
	}

	public void setButtonB(String text) {
		this.buttonB.setText(String.format("B: %s", text));
	}

	public void setButtonC(String text) {
		this.buttonC.setText(String.format("C: %s", text));
	}

	public void setButtonD(String text) {
		this.buttonD.setText(String.format("D: %s", text));
	}

	public String getButtonA() {
		return buttonA.getText();
	}

	public String getButtonB() {
		return buttonB.getText();
	}

	public String getButtonC() {
		return buttonC.getText();
	}

	public String getButtonD() {
		return buttonD.getText();
	}
	
	// action method for all buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonContinue) {
			this.displayQuestion(questionArray[questionIndex]); // displays the next question
			questionIndex += 1;
			buttonContinue.setEnabled(false); // disables the continue button until a correct answer is given
			
			// wipes the previous player answer 
			correctAnswerLabel.setText("");
			this.setRecord("");
			
			// enables the answer buttons
			buttonA.setEnabled(true); 
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			
			// the lifelines are enabled/disabled depending on whether they have been used
			buttonFifty.setEnabled(fiftyAvailable);
			buttonAtA.setEnabled(ataAvailable);
			buttonPaF.setEnabled(pafAvailable);
		}
		
		if(e.getSource() == buttonA) {
			record = buttonA.getText();
		}
		
		if(e.getSource() == buttonB) {
			record = buttonB.getText();
		}
		
		if(e.getSource() == buttonC) {
			record = buttonC.getText();
		}
		
		if(e.getSource() == buttonD) {
			record = buttonD.getText();
		}
		
		// actions for the lifelines
		if(e.getSource() == buttonPaF) {
			correctAnswerLabel.setText(questionArray[questionIndex-1].phoneFriend());
			pafAvailable = false;
			buttonPaF.setEnabled(fiftyAvailable);
		}
		
		if(e.getSource() == buttonAtA) {
			correctAnswerLabel.setText(questionArray[questionIndex-1].askTheAudience());
			ataAvailable = false;
			buttonAtA.setEnabled(fiftyAvailable);
			
		}
		
		if(e.getSource() == buttonFifty) {
			String[] eliminatedAnswers = questionArray[questionIndex-1].fiftyFifty();
			for(int i=0; i<2; i++) {
				if(buttonA.getText().contains(eliminatedAnswers[i])) {
					buttonA.setText("");
				}
				if(buttonB.getText().contains(eliminatedAnswers[i])) {
					buttonB.setText("");
				}
				if(buttonC.getText().contains(eliminatedAnswers[i])) {
					buttonC.setText("");
				}
				if(buttonD.getText().contains(eliminatedAnswers[i])) {
					buttonD.setText("");
				}
			}
			correctAnswerLabel.setText("The computer takes away two of the wrong answers.");
			fiftyAvailable = false;
			buttonFifty.setEnabled(fiftyAvailable);
		}
		
	}
	
	// necessary getter/setter methods for properties
	public void setCorrectAnswerLabel(String text) {
		correctAnswerLabel.setText(text);
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}
	
	// displays the question and all answers on the frame
	public void displayQuestion(Question q) {
		this.setLabel(q.getTitle());
		this.setButtonA(q.getAnswers()[0]);
		this.setButtonB(q.getAnswers()[1]);
		this.setButtonC(q.getAnswers()[2]);
		this.setButtonD(q.getAnswers()[3]);
	}
	
	// disables the frame when the game is over
	public void gameOver(Player p) {
		correctAnswerLabel.setText(String.format("Game Over! %s leaves the game with $%d!", p.getName(), p.getSum()));
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonFifty.setEnabled(false);
		buttonAtA.setEnabled(false);
		buttonPaF.setEnabled(false);
		buttonContinue.setEnabled(false);
		
	}
	
	// disables the frame after a correct answer is given until continue is clicked
	public void corectAnswerChosen() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonFifty.setEnabled(false);
		buttonAtA.setEnabled(false);
		buttonPaF.setEnabled(false);
	}
	
}
