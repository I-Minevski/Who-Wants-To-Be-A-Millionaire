package WWTBAM;

import java.util.*;
import java.lang.*;	

public class Question {
	
	private String title;
	private String correctAnswer;
	private String [] answers = new String[4];
	
	// Enum for the rewards for all questions
	enum Reward{
		// Every enum constant has a value assigned to it
		FIRST(100), SECOND(300), THIRD(500),
		FOURTH(1000), FIFTH(2500), SIXTH(5000),
		SEVENTH(10000), EIGHTH(20000), NINTH(50000), TENTH(100000);
		
		private int value;
		
		// Constructor for a Reward object. 
		Reward(int value){
			this.value = value;
		}
		
		// Getter method. Returns each constant's assigned value
		public static int getRewards(int key) {
			Reward r[] = Reward.values();
			int val;
			val = r[key].value;
			return val;
		}
	}
	
	// Constructor for the Question object. Uses a two-dimensional array for all questions and takes one by index
	public Question (String[][] key, int index){
		this.title = key[0][index];
		this.correctAnswer = key[1][index];
		
		// After taking the correct answer which always is on row 1, the property answers is filled with all answers 
		answers[0] = key[1][index];
		answers[1] = key[2][index];
		answers[2] = key[3][index];
		answers[3] = key[4][index];
		
		// The answers are shuffled randomly
		List<String> a = Arrays.asList(answers);
		Collections.shuffle(a);
		a.toArray(answers);
	}
	
	// Methods for the lifelines
	public String phoneFriend() {
		return String.format("Your friend thinks the correct answer is %s.", correctAnswer);
	}
	
	public String askTheAudience() {
		int index = 0;
		Random rnd = new Random();
		for(int i=0; i<4; i++) {
			if(answers[i].equals(correctAnswer)) {
				index = i;
			}
		}
		int correctPercentage = rnd.nextInt(50, 100);
		int [] percent = new int[4];
		int remains = 100 - correctPercentage;
		for(int i=0; i<4; i++) {
			if(i == index) {
				percent[i] = correctPercentage;
			} else {
				int answerPercentage = rnd.nextInt(remains);
				percent[i] = answerPercentage;
				remains -= answerPercentage;
			}
		}
		
		int addRemaining = rnd.nextInt(0, 4);
		percent[addRemaining] += remains;
		
		return String.format("A: %d%%  B: %d%%  C: %d%%   D: %d%%", percent[0], percent[1], percent[2], percent[3]);
	}
	
	public String [] fiftyFifty() {
		String [] eliminated = new String [2];
		Random rnd = new Random();
		while(eliminated[0] == null) {
		int rndIndex1 = rnd.nextInt(0, 4);
		if(answers[rndIndex1] != correctAnswer) {
			eliminated[0] = answers[rndIndex1];
		}
		}
		while(eliminated[1] == null) {
		int rndIndex2 = rnd.nextInt(0, 4);
		if(answers[rndIndex2] != correctAnswer && answers[rndIndex2] != eliminated[0]) {
			eliminated[1] = answers[rndIndex2];
		}
		}
		return eliminated;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String[] getAnswers() {
		return answers;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
}
