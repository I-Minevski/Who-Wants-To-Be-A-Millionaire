package WWTBAM;

import java.util.*;
import java.lang.*;

public class Questions {

	private String [][] questions = new String [5][10];
		
		// The constructor creates an object that contains all questions
		
	public Questions(String[][] questions) {	
		questions[0][0] = "In the medical profession, what do the initials 'GP' stand for?";
		questions[0][1] = "What is the smallest country in the world?";
		questions[0][2] = "In what year was the first iPhone released?";
		questions[0][3] = "Who won the first ever football World Cup?";
		questions[0][4] = "Which city will host the 2028 Olympic Games?";
		questions[0][5] = "What colour were the Pyramids of Giza originally?";
		questions[0][6] = "Which of the following men does not have a chemical element named for him?";
		questions[0][7] = "Oberon is the satellite of which planet?";
		questions[0][8] = "In 1912, former US President Theodore Roosevelt was a candidate for which political party?";
		questions[0][9] = "Duroc, Berkshire and Mangalica are breeds of which farmyard animal?";
		
		questions[1][0] = "General Practitioner";
		questions[2][0] = "Garden Practitioner";
		questions[3][0] = "Good Practitioner";
		questions[4][0] = "Graded Practitioner";
		
		questions[1][1] = "Vatican City";
		questions[2][1] = "Monaco";
		questions[3][1] = "Andorra";
		questions[4][1] = "Montenegro";
		
		questions[1][2] = "2007";
		questions[2][2] = "2008";
		questions[3][2] = "2006";
		questions[4][2] = "2005";
		
		questions[1][3] = "Uruguay";
		questions[2][3] = "Italy";
		questions[3][3] = "Brazil";
		questions[4][3] = "Germany";
		
		questions[1][4] = "Los Angeles";
		questions[2][4] = "Paris";
		questions[3][4] = "Tokyo";
		questions[4][4] = "San Francisco";
		
		questions[1][5] = "White";
		questions[2][5] = "Yellow";
		questions[3][5] = "Pink";
		questions[4][5] = "Orange";
		
		questions[1][6] = "Isaac Newton";
		questions[2][6] = "Albert Einstein";
		questions[3][6] = "Enrico Fermi";
		questions[4][6] = "Niels Bohr";
		
		questions[1][7] = "Uranus";
		questions[2][7] = "Jupiter";
		questions[3][7] = "Saturn";
		questions[4][7] = "Neptune";

		questions[1][8] = "Bull Moose";
		questions[2][8] = "Democrat";
		questions[3][8] = "Republican";
		questions[4][8] = "Patriot";
		
		questions[1][9] = "Pig";
		questions[2][9] = "Chicken";
		questions[3][9] = "Cow";
		questions[4][9] = "Sheep";
		
		this.questions = questions;
		
		
		
	}

	public String[][] getQuestions() {
		return questions;
	}
}
