package WWTBAM;

import java.util.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import WWTBAM.Question.Reward;

public class Main_gui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		// Creating a Questions object
		String[][] questions = new String [5][10];
		Questions q = new Questions(questions);
		questions = q.getQuestions();
		
		// Activating the frame
		MyFrame frame = new MyFrame(q);
		frame.add();
		
		// Creating a Player object. The player's name must begin with a capital letter
		Player player = new Player();
		while(player.getName() == "") {
			try {
			String playerName = JOptionPane.showInputDialog("Enter your name.");
			if(!Character.isUpperCase(playerName.charAt(0))) {
				throw new Exception("The name must start with a capital letter");
			} else {
				player.setName(playerName);
			}	
		} catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "The name must start with a capital letter");
		}
		}
		
		// Displaying the first question
		frame.displayQuestion(frame.questionArray[0]);
		
		// The game's main loop
		while(frame.getQuestionIndex() <= 10) {
			// Looping through the questions
			Question current = frame.questionArray[frame.getQuestionIndex()-1];
			
			// Checking if the record is empty 
			try {
	            SwingUtilities.invokeAndWait(() -> {
	                if (frame.getRecord() != "") {
	                    player.setPlayerAnswer(frame.getRecord().substring(3));
	                }
	            });
	        } catch (InvocationTargetException | InterruptedException e) {
	            //e.printStackTrace();
	        	continue;
	        }
			
			// Checking if an answer is selected
			if(frame.getRecord() != "") {
				player.setPlayerAnswer(frame.getRecord().substring(3));
				
				// Checking if the answer is correct
				if(player.getPlayerAnswer().equals(current.getCorrectAnswer())) {
					frame.setCorrectAnswerLabel(String.format("Correct! %s wins $%d!", player.getName() , Reward.getRewards(frame.getQuestionIndex()-1))); // Correct answer message
					player.setSum(Reward.getRewards(frame.getQuestionIndex()-1)); // Updating the player's reward
					frame.corectAnswerChosen(); // Disabling the frame until the next question is activated
					
					// Checking if the payer has won the game
					if(frame.getQuestionIndex() == 10) {
						frame.setCorrectAnswerLabel(String.format("Congratulations %s! You won $%d and the game!", player.getName(), Reward.getRewards(frame.getQuestionIndex()-1)));
						break;
					}
					
					// Enabling Continue for the next question
					frame.buttonContinue.setEnabled(true);
					
					// Returning the record back to "" so that a new answer can be chosen
					frame.setRecord("");
				} else {
					// Game over scenario
					frame.gameOver(player);
					break;
				}
			}
		}
	}
}
	

