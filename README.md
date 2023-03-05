# Who-Wants-To-Be-A-Millionaire
A simple implementation of the popular game show "Who Wants To Be A Millionaire" using Java GUI.

This is a Java-based desktop game created as a project for a programming course at school.

## Getting Started

### Prerequisites

To run this project, you'll need to have Java SE Development Kit 8 installed on your machine.

### Installation

1. Clone the repository: git clone https://github.com/your_username/Who-Wants-To-Be-A-Millionaire.git

2. Compile and run the `Main_gui.java` file located in the `src` directory.

## Gameplay

When the game starts, the player is presented with a question and four possible answers. The player must select an answer, and if it is correct, they move on to the next question with an increased reward. If they answer incorrectly, the game ends and the player walks away with the reward from the previous question.

The game also includes three lifelines that the player can use: 50:50, Ask the Audience, and Phone a Friend. These lifelines can help the player narrow down their choices or eliminate some incorrect options.

## Classes
The game consists of several classes:

- Question: This class represents a single question, including the question itself, the correct answer, and three incorrect answers.
- Questions: This class represents a collection of questions.
- Reward: This enum represents the rewards for each question.
- Player: This class represents the player, including their name and current reward.
- MyFrame: This class represents the main window of the game, including the questions, answers, and lifelines.
- Main_gui: This class contains the main method of the game.

## Built With

* Java

## License
This project is licensed under the MIT License. See the LICENSE file for details.




