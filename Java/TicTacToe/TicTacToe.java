/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {

	private static int[][] winCombinations = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // horizontal wins
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // vertical wins
			{ 0, 4, 8 }, { 2, 4, 6 } // diagonal wins
	};
	private static boolean turnOneCorners, turnOneSides, turnOneMiddle, pathA, pathB, pathC, pathD, pathE, pathF,
			pathG = false;

	private static JButton buttons[] = new JButton[9]; // create 9 buttons

	public static boolean gameRunning = false;

	static int random = (int) (Math.random() * 9);
	static int wins = 0;
	static int losses = 0;
	static int ties = 0;
	static int xWins = 0;
	static int oWins = 0;
	static int localTies = 0;

	public static void gamePanel() {
		int gameMode = NewGame.getGameMode();
		String gameModeName = "";
		if (gameMode == 1) {
			gameModeName = "NPC Easy";
		} else if (gameMode == 2) {
			gameModeName = "NPC Hard";
		} else if (gameMode == 3) {
			gameModeName = "PVP Local";
		}
		gameRunning = true; // ensure only one game open
		JFrame frame = new JFrame("Tic Tac Foe - " + gameModeName);
		// Handle user closing window. Reset gameRunning boolean to false
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gameRunning = false;
				frame.dispose();
			}
		});

		JPanel panel = new JPanel(); // creating a panel with a box like a tic tac toe board
		panel.setLayout(new GridLayout(3, 3));
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		panel.setBackground(Color.white);

		for (int i = 0; i <= 8; i++) { // placing the button onto the board
			buttons[i] = new MyButton();
			panel.add(buttons[i]);
		}

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
	}

	public static int playerTurn = 0; // used for counting

	@SuppressWarnings("serial")
	private static class MyButton extends JButton implements ActionListener {
		int again = 1000;
		boolean win = false; // there is not a win
		String letter; // x or o

		public MyButton() { // creating blank board
			super();
			letter = " ";
			setFont(new Font("Dialog", 1, 60));
			setText(letter);
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) { // placing x or o's
			int gameMode = NewGame.getGameMode();
			if ((playerTurn % 2) == 0 && getText().equals(" ") && win == false) {
				letter = "X";
				playerTurn = playerTurn + 1;
				setText(letter);
			} else if ((playerTurn % 2) == 1 && getText().equals(" ") && win == false && gameMode == 3) {
				letter = "O";
				playerTurn = playerTurn + 1;
				setText(letter);
			}

			win = checkWin(win);

			// EASY CPU
			if (gameMode == 1 && win == false && (playerTurn % 2) == 1 && playerTurn < 8) {
				letter = "O";
				// Easy = Math.random
				while (buttons[random].getText() == "X" || buttons[random].getText() == "O") {
					random = (int) (Math.random() * 9);
				}
				buttons[random].setText(letter);
				playerTurn = playerTurn + 1;
			}

			// HARD CPU
			if (gameMode == 2 && win == false && (playerTurn % 2) == 1 && playerTurn < 8) {
				letter = "O";

				// Turn 1 CPU
				if (playerTurn == 1) {
					// Player Corner Start
					if (buttons[0].getText().contentEquals("X") || buttons[2].getText().contentEquals("X")
							|| buttons[6].getText().contentEquals("X") || buttons[8].getText().contentEquals("X")) {
						turnOneCorners = true;
						buttons[4].setText(letter);
					}
					// Player Middle Start
					else if (buttons[4].getText().contentEquals("X")) {
						turnOneMiddle = true;
						buttons[0].setText(letter);
					}
					// Player Side Start
					else {
						turnOneSides = true;
						buttons[4].setText(letter);
					}
				}
				// Turn 2 CPU
				if (playerTurn == 3) {
					if (turnOneSides) {
						if ((buttons[0].getText().contentEquals("X") && buttons[1].getText().contentEquals("X"))
								|| (buttons[1].getText().contentEquals("X") && buttons[2].getText().contentEquals("X"))
								|| (buttons[2].getText().contentEquals("X") && buttons[5].getText().contentEquals("X"))
								|| (buttons[5].getText().contentEquals("X") && buttons[8].getText().contentEquals("X"))
								|| (buttons[8].getText().contentEquals("X") && buttons[7].getText().contentEquals("X"))
								|| (buttons[6].getText().contentEquals("X") && buttons[7].getText().contentEquals("X"))
								|| (buttons[3].getText().contentEquals("X") && buttons[6].getText().contentEquals("X"))
								|| (buttons[0].getText().contentEquals("X") && buttons[3].getText().contentEquals("X"))
								|| (buttons[1].getText().contentEquals("X") && buttons[8].getText().contentEquals("X"))
								|| (buttons[1].getText().contentEquals("X") && buttons[6].getText().contentEquals("X"))
								|| (buttons[3].getText().contentEquals("X") && buttons[2].getText().contentEquals("X"))
								|| (buttons[3].getText().contentEquals("X") && buttons[8].getText().contentEquals("X"))
								|| (buttons[5].getText().contentEquals("X") && buttons[0].getText().contentEquals("X"))
								|| (buttons[5].getText().contentEquals("X") && buttons[6].getText().contentEquals("X"))
								|| (buttons[7].getText().contentEquals("X") && buttons[0].getText().contentEquals("X"))
								|| (buttons[7].getText().contentEquals("X")
										&& buttons[2].getText().contentEquals("X"))) {
							turnOneSides = false;
							turnOneCorners = true;
						} else if (buttons[1].getText().contentEquals("X") && buttons[3].getText().contentEquals("X")) {
							pathA = true;
							buttons[0].setText(letter);
						} else if (buttons[1].getText().contentEquals("X") && buttons[5].getText().contentEquals("X")) {
							pathA = true;
							buttons[2].setText(letter);
						} else if (buttons[3].getText().contentEquals("X") && buttons[7].getText().contentEquals("X")) {
							pathA = true;
							buttons[6].setText(letter);
						} else if (buttons[5].getText().contentEquals("X") && buttons[7].getText().contentEquals("X")) {
							pathA = true;
							buttons[8].setText(letter);
						} else {
							// Auto Win for CPU
							pathB = true;
							buttons[0].setText(letter);
						}
					}
					if (turnOneCorners) {
						if (buttons[0].getText().contentEquals("X") && buttons[2].getText().contentEquals("X")) {
							pathB = true;
							buttons[1].setText(letter);
						} else if (buttons[0].getText().contentEquals("X") && buttons[6].getText().contentEquals("X")) {
							pathB = true;
							buttons[3].setText(letter);
						} else if (buttons[2].getText().contentEquals("X") && buttons[8].getText().contentEquals("X")) {
							pathB = true;
							buttons[5].setText(letter);
						} else if (buttons[6].getText().contentEquals("X") && buttons[8].getText().contentEquals("X")) {
							pathB = true;
							buttons[7].setText(letter);
						} else if ((buttons[0].getText().contentEquals("X") && buttons[1].getText().contentEquals("X"))
								|| (buttons[5].getText().contentEquals("X")
										&& buttons[8].getText().contentEquals("X"))) {
							pathC = true;
							buttons[2].setText(letter);
						} else if ((buttons[1].getText().contentEquals("X") && buttons[2].getText().contentEquals("X"))
								|| (buttons[3].getText().contentEquals("X")
										&& buttons[6].getText().contentEquals("X"))) {
							pathC = true;
							buttons[0].setText(letter);
						} else if ((buttons[0].getText().contentEquals("X") && buttons[3].getText().contentEquals("X"))
								|| (buttons[7].getText().contentEquals("X")
										&& buttons[8].getText().contentEquals("X"))) {
							pathC = true;
							buttons[6].setText(letter);
						} else if ((buttons[6].getText().contentEquals("X") && buttons[7].getText().contentEquals("X"))
								|| (buttons[2].getText().contentEquals("X")
										&& buttons[5].getText().contentEquals("X"))) {
							pathC = true;
							buttons[8].setText(letter);
						} else if (buttons[1].getText().contentEquals("X") || buttons[7].getText().contentEquals("X")) {
							pathD = true;
							buttons[3].setText(letter);
						} else if (buttons[3].getText().contentEquals("X") || buttons[5].getText().contentEquals("X")) {
							pathD = true;
							buttons[1].setText(letter);
						} else {
							pathA = true;
							buttons[1].setText(letter);
						}
					}

					if (turnOneMiddle) {
						if (buttons[7].getText().contentEquals("X")) {
							pathA = true;
							buttons[1].setText(letter);
						} else if (buttons[6].getText().contentEquals("X")) {
							pathB = true;
							buttons[2].setText(letter);
						} else if (buttons[5].getText().contentEquals("X")) {
							pathC = true;
							buttons[3].setText(letter);
						} else if (buttons[3].getText().contentEquals("X")) {
							pathD = true;
							buttons[5].setText(letter);
						} else if (buttons[2].getText().contentEquals("X")) {
							pathE = true;
							buttons[6].setText(letter);
						} else if (buttons[1].getText().contentEquals("X")) {
							pathF = true;
							buttons[7].setText(letter);
						} else {
							pathG = true;
							buttons[6].setText(letter);
						}
					}
				}

				// Turn 3 CPU
				if (playerTurn == 5) {
					if (turnOneCorners) {
						if (pathA) {
							if (buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else if (buttons[0].getText().contentEquals("X")) {
								buttons[6].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")) {
								buttons[8].setText(letter);
							}
						} else if (pathB) {
							if (buttons[7].getText().contentEquals(" ") && buttons[1].getText().contentEquals("O")) {
								buttons[7].setText(letter);
							} else if (buttons[5].getText().contentEquals(" ")
									&& buttons[3].getText().contentEquals("O")) {
								buttons[5].setText(letter);
							} else if ((buttons[1].getText().contentEquals(" ")
									&& buttons[7].getText().contentEquals("O"))
									|| (buttons[3].getText().contentEquals("X")
											&& buttons[5].getText().contentEquals("O"))
									|| (buttons[3].getText().contentEquals("O")
											&& buttons[5].getText().contentEquals("X"))) {
								buttons[1].setText(letter);
							} else {
								buttons[3].setText(letter);
							}
						} else if (pathC) {
							if (buttons[0].getText().contentEquals(" ") && buttons[8].getText().contentEquals("O")) {
								buttons[0].setText(letter);
							} else if (buttons[0].getText().contentEquals("X")
									&& buttons[2].getText().contentEquals("X")) {
								buttons[1].setText(letter);
							} else if (buttons[2].getText().contentEquals(" ")
									&& buttons[6].getText().contentEquals("O")) {
								buttons[2].setText(letter);
							} else if (buttons[0].getText().contentEquals("X")
									&& buttons[6].getText().contentEquals("X")) {
								buttons[3].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X")) {
								buttons[5].setText(letter);
							} else if (buttons[6].getText().contentEquals(" ")
									&& buttons[2].getText().contentEquals("O")) {
								buttons[6].setText(letter);
							} else if (buttons[6].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X")) {
								buttons[7].setText(letter);
							} else {
								buttons[8].setText(letter);
							}
						} else if (pathD) {
							if (buttons[3].getText().contentEquals("O") && buttons[5].getText().contentEquals(" ")) {
								buttons[5].setText(letter);
							} else if (buttons[1].getText().contentEquals("O")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else if ((buttons[5].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X"))
									|| (buttons[0].getText().contentEquals("X")
											&& buttons[3].getText().contentEquals("O"))) {
								buttons[2].setText(letter);
							} else if ((buttons[7].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X"))
									|| (buttons[0].getText().contentEquals("X")
											&& buttons[1].getText().contentEquals("O"))) {
								buttons[6].setText(letter);
							} else {
								buttons[8].setText(letter);
							}
						}
					}
					if (turnOneSides) {
						if (pathA) {
							if ((buttons[0].getText().contentEquals(" ") && buttons[8].getText().contentEquals("O"))
									|| (buttons[7].getText().contentEquals("X")
											&& buttons[2].getText().contentEquals("X"))
									|| (buttons[1].getText().contentEquals("X")
											&& buttons[5].getText().contentEquals("X"))) {
								buttons[0].setText(letter);
							} else if (buttons[6].getText().contentEquals(" ")
									&& buttons[2].getText().contentEquals("O")) {
								buttons[6].setText(letter);
							} else if (buttons[8].getText().contentEquals(" ")
									&& buttons[0].getText().contentEquals("O")) {
								buttons[8].setText(letter);
							} else {
								buttons[2].setText(letter);
							}
						} else if (pathB) {
							if (buttons[8].getText().contentEquals(" ")) {
								buttons[8].setText(letter);
							} else if (buttons[8].getText().contentEquals("X")
									&& buttons[3].getText().contentEquals("X")) {
								buttons[2].setText(letter);
							} else {
								buttons[6].setText(letter);
							}
						}
					}
					if (turnOneMiddle) {
						if (pathA) {
							if (buttons[2].getText().contentEquals(" ")) {
								buttons[2].setText(letter);
							} else {
								buttons[6].setText(letter);
							}
						} else if (pathB) {
							if (buttons[1].getText().contentEquals(" ")) {
								buttons[1].setText(letter);
							} else {
								buttons[7].setText(letter);
							}
						} else if (pathC) {
							if (buttons[6].getText().contentEquals(" ")) {
								buttons[6].setText(letter);
							} else {
								buttons[2].setText(letter);
							}
						} else if (pathD) {
							if (buttons[6].getText().contentEquals("X")) {
								buttons[2].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")) {
								buttons[6].setText(letter);
							} else if (buttons[1].getText().contentEquals("X")) {
								buttons[7].setText(letter);
							} else {
								buttons[1].setText(letter);
							}
						} else if (pathE) {
							if (buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else {
								buttons[5].setText(letter);
							}
						} else if (pathF) {
							if (buttons[6].getText().contentEquals("X")) {
								buttons[2].setText(letter);
							} else if (buttons[3].getText().contentEquals("X")) {
								buttons[5].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")) {
								buttons[6].setText(letter);
							} else {
								buttons[3].setText(letter);
							}
						} else if (pathG) {
							if (buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else {
								buttons[5].setText(letter);
							}
						}
					}
				}

				// Turn 4 CPU
				if (playerTurn == 7) {
					if (turnOneCorners) {
						if (pathA) {
							if (buttons[0].getText().contentEquals(" ") && buttons[2].getText().contentEquals("X")) {
								buttons[0].setText(letter);
							} else if (buttons[0].getText().contentEquals("X")
									&& buttons[2].getText().contentEquals(" ")) {
								buttons[2].setText(letter);
							} else if (buttons[0].getText().contentEquals("X")
									&& buttons[6].getText().contentEquals("X")
									&& buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else {
								buttons[5].setText(letter);
							}
						} else if (pathB) {
							if (buttons[1].getText().contentEquals("X") && buttons[5].getText().contentEquals("X")) {
								buttons[2].setText(letter);
							} else if (buttons[3].getText().contentEquals("O")
									&& buttons[5].getText().contentEquals(" ")) {
								buttons[5].setText(letter);
							} else if (buttons[3].getText().contentEquals("X")
									&& buttons[7].getText().contentEquals("X")) {
								buttons[6].setText(letter);
							} else if (buttons[1].getText().contentEquals("O")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else {
								buttons[8].setText(letter);
							}
						} else if (pathC) {
							if (buttons[7].getText().contentEquals("O") && buttons[1].getText().contentEquals(" ")) {
								buttons[1].setText(letter);
							} else if (buttons[5].getText().contentEquals("O")
									&& buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else if (buttons[3].getText().contentEquals("O")
									&& buttons[5].getText().contentEquals(" ")) {
								buttons[5].setText(letter);
							} else if (buttons[1].getText().contentEquals("O")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else {
								while (buttons[random].getText() == "X" || buttons[random].getText() == "O") {
									random = (int) (Math.random() * 9);
								}
								buttons[random].setText(letter);
							}
						} else if (pathD) {
							if (buttons[2].getText().contentEquals("X") && buttons[1].getText().contentEquals(" ")) {
								buttons[1].setText(letter);
							} else if ((buttons[6].getText().contentEquals("O")
									&& buttons[2].getText().contentEquals(" "))
									|| (buttons[1].getText().contentEquals("X")
											&& buttons[2].getText().contentEquals(" "))) {
								buttons[2].setText(letter); // DO THIS ONE
							} else if (buttons[0].getText().contentEquals("X")
									&& buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else if (buttons[8].getText().contentEquals("X")
									&& buttons[5].getText().contentEquals(" ")) {
								buttons[5].setText(letter);
							} else if ((buttons[2].getText().contentEquals("O")
									&& buttons[6].getText().contentEquals(" "))
									|| (buttons[3].getText().contentEquals("X")
											&& buttons[6].getText().contentEquals(" "))) {
								buttons[6].setText(letter);
							} else if (buttons[8].getText().contentEquals("X")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else if (buttons[7].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals(" ")) {
								buttons[8].setText(letter);
							} else {
								buttons[0].setText(letter);
							}
						}
					}
					if (turnOneSides) {
						if (pathA) {
							if (buttons[0].getText().contentEquals("X") && buttons[6].getText().contentEquals("X")) {
								buttons[3].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X")) {
								buttons[5].setText(letter);
							} else if (buttons[2].getText().contentEquals("O")
									&& buttons[6].getText().contentEquals(" ")) {
								buttons[6].setText(letter);
							} else if (buttons[8].getText().contentEquals("X")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else {
								buttons[8].setText(letter);
							}
						} else if (pathB) {
							if (buttons[3].getText().contentEquals("X") && buttons[6].getText().contentEquals("X")) {
								buttons[1].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")
									&& buttons[7].getText().contentEquals("X")) {
								buttons[3].setText(letter);
							} else if (buttons[5].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X")) {
								buttons[6].setText(letter);
							} else {
								buttons[2].setText(letter);
							}
						}
					}
					if (turnOneMiddle) {
						if (pathA) {
							if (buttons[3].getText().contentEquals(" ")) {
								buttons[3].setText(letter);
							} else {
								buttons[5].setText(letter);
							}
						} else if (pathB) {
							if (buttons[5].getText().contentEquals("X")) {
								buttons[3].setText(letter);
							} else {
								buttons[5].setText(letter);
							}
						} else if (pathC) {
							if (buttons[1].getText().contentEquals(" ")) {
								buttons[1].setText(letter);
							} else {
								buttons[7].setText(letter);
							}
						} else if (pathD) {
							if (buttons[1].getText().contentEquals(" ") && buttons[2].getText().contentEquals("O")) {
								buttons[1].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")
									&& buttons[6].getText().contentEquals(" ")) {
								buttons[6].setText(letter);
							} else if (buttons[1].getText().contentEquals("X")
									&& buttons[7].getText().contentEquals(" ")) {
								buttons[7].setText(letter);
							} else {
								buttons[2].setText(letter);
							}
						} else if (pathE) {
							if (buttons[7].getText().contentEquals("X")) {
								buttons[1].setText(letter);
							} else {
								buttons[7].setText(letter);
							}
						} else if (pathF) {
							if (buttons[6].getText().contentEquals("X") && buttons[2].getText().contentEquals(" ")) {
								buttons[2].setText(letter);
							} else if (buttons[5].getText().contentEquals("X")
									&& buttons[4].getText().contentEquals(" ")) {
								buttons[4].setText(letter);
							} else if (buttons[2].getText().contentEquals("X")
									&& buttons[8].getText().contentEquals("X")
									&& buttons[5].getText().contentEquals(" ")) {
								buttons[5].setText(letter);
							} else if (buttons[6].getText().contentEquals("O")
									&& buttons[8].getText().contentEquals(" ")) {
								buttons[8].setText(letter);
							} else {
								buttons[6].setText(letter);
							}
						} else if (pathG) {
							if (buttons[1].getText().contentEquals("X")) {
								buttons[7].setText(letter);
							} else {
								buttons[1].setText(letter);
							}
						}
					}
				}
				playerTurn = playerTurn + 1;
			}

			win = checkWin(win);
			if (win == true) { // state win and play again
				if (letter == "X") {
					if (gameMode == 3) {
						xWins = xWins + 1;
					}
					else {
						wins = wins + 1;
					}
				} else {
					if (gameMode == 3) {
						oWins = oWins + 1;
					}
					else {
						losses = losses + 1;
					}
				}
				if (gameMode == 1 || gameMode == 2) {
					again = JOptionPane.showConfirmDialog(
							null, letter + " wins the game!  Do you want to play again?" + "\nWins: " + wins
									+ " | Losses: " + losses + " | Ties: " + ties,
							letter + "won!", JOptionPane.YES_NO_OPTION);
				} else {
					again = JOptionPane.showConfirmDialog(
							null, letter + " wins the game!  Do you want to play again?" + "\nX Wins: " + xWins
									+ " | O Wins: " + oWins + " | Ties: " + localTies,
							letter + "won!", JOptionPane.YES_NO_OPTION);
				}

			} else if (playerTurn == 9 && win == false) { // state win and play again
				if (gameMode == 1 || gameMode == 2) {
					ties = ties + 1;
					again = JOptionPane
							.showConfirmDialog(
									null, "The game was tie!  Do you want to play again?" + "\nWins: " + wins
											+ " | Losses: " + losses + " | Ties: " + ties,
									"Tie game!", JOptionPane.YES_NO_OPTION);
				} else {
					localTies = localTies + 1;
					again = JOptionPane
							.showConfirmDialog(
									null, "The game was tie!  Do you want to play again?" + "\nX Wins: " + xWins
											+ " | O Wins: " + oWins + " | Ties: " + localTies,
									"Tie game!", JOptionPane.YES_NO_OPTION);
				}

				win = true;
			}

			if (again == JOptionPane.YES_OPTION && win == true) {
				clearButtons();
				win = false;
			} else if (again == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}
	}

	public static boolean checkWin(boolean win) {
		for (int i = 0; i <= 7; i++) { // check for win
			if (buttons[winCombinations[i][0]].getText().equals(buttons[winCombinations[i][1]].getText())
					&& buttons[winCombinations[i][1]].getText().equals(buttons[winCombinations[i][2]].getText())
					&& buttons[winCombinations[i][0]].getText() != " ") {
				// win is true
				win = true;
			}
		}
		return win;
	}

	public static void clearButtons() {
		// clear buttons
		for (int i = 0; i <= 8; i++) {
			buttons[i].setText(" ");
		}
		// reset the count
		playerTurn = 0;
		// Reset the booleans
		turnOneCorners = false;
		turnOneSides = false;
		turnOneMiddle = false;
		pathA = false;
		pathB = false;
		pathC = false;
		pathD = false;
		pathE = false;
		pathF = false;
		pathG = false;
	}

	public static boolean getIsGameRunning() {
		return gameRunning;
	}
}
