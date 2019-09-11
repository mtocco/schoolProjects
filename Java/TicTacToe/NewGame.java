/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import java.io.IOException;
import javax.swing.JFrame;

public class NewGame extends javax.swing.JFrame {

	public NewGame() {
		initComponents();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		btnNPCEasy = new javax.swing.JButton();
		btnNPCHard = new javax.swing.JButton();
		btnPVPLocal = new javax.swing.JButton();
		btnPVPOnline = new javax.swing.JButton();
		btnMainMenu = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.FlowLayout());

		jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
		jLabel1.setText("Select Game");

		btnNPCEasy.setText("NPC Easy");
		btnNPCEasy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNPCEasyActionPerformed(evt);
			}
		});

		btnNPCHard.setText("NPC Hard");
		btnNPCHard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNPCHardActionPerformed(evt);
			}
		});

		btnPVPLocal.setText("PVP Local");
		btnPVPLocal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPVPLocalActionPerformed(evt);
			}
		});

		btnPVPOnline.setText("PVP Online");
		btnPVPOnline.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPVPOnlineActionPerformed(evt);
			}
		});

		btnMainMenu.setText("Return To Main Menu");
		btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMainMenuActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(74, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNPCEasy, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNPCHard, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPVPLocal, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPVPOnline, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(72, 72, 72)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(86, 86, 86).addComponent(jLabel1)
						.addGap(88, 88, 88).addComponent(btnNPCEasy).addGap(18, 18, 18).addComponent(btnNPCHard)
						.addGap(18, 18, 18).addComponent(btnPVPLocal).addGap(18, 18, 18).addComponent(btnPVPOnline)
						.addGap(18, 18, 18).addComponent(btnMainMenu).addContainerGap(149, Short.MAX_VALUE)));

		getContentPane().add(jPanel1);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnNPCEasyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNPCEasyActionPerformed
		if (TicTacToe.getIsGameRunning() == false) {
			setGameMode(1);
			TicTacToe.gamePanel();
			TicTacToe.clearButtons();
		}
	}// GEN-LAST:event_btnNPCEasyActionPerformed

	private void btnNPCHardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNPCHardActionPerformed
		if (TicTacToe.getIsGameRunning() == false) {
			setGameMode(2);
			TicTacToe.gamePanel();
			TicTacToe.clearButtons();
		}
	}// GEN-LAST:event_btnNPCHardActionPerformed

	private void btnPVPLocalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPVPLocalActionPerformed
		if (TicTacToe.getIsGameRunning() == false) {
			setGameMode(3);
			TicTacToe.gamePanel();
			TicTacToe.clearButtons();
		}
	}// GEN-LAST:event_btnPVPLocalActionPerformed

	private void btnPVPOnlineActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPVPOnlineActionPerformed
		try {
			// #EDIT
			//Process process = new ProcessBuilder("C:\\Users\\pjalv\\Desktop\\TTTClient.exe").start();
			Process process = new ProcessBuilder("C:\\Users\\pclab\\Desktop\\misc\\TTTClient.exe").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// GEN-LAST:event_btnPVPOnlineActionPerformed

	private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMainMenuActionPerformed
		MainMenu mainMenu = new MainMenu();
		mainMenu.pack();
		mainMenu.setLocationRelativeTo(null);
		mainMenu.setVisible(true);

		this.dispose();
	}// GEN-LAST:event_btnMainMenuActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnPVPLocal;
	private javax.swing.JButton btnPVPOnline;
	private javax.swing.JButton btnMainMenu;
	private javax.swing.JButton btnNPCEasy;
	private javax.swing.JButton btnNPCHard;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

	public static int gameMode;

	public static int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		NewGame.gameMode = gameMode;
	}
}
