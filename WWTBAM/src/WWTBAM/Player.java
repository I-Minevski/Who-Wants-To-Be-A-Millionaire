package WWTBAM;

public class Player {
	
	private String name;
	private int sum;
	private String playerAnswer;
	
	public Player() {
		this.name = "";
	}

	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	public String getPlayerAnswer() {
		return playerAnswer;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// A class for the player that will contain his name, reward and selected answer
	
}
