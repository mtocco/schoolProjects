/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

public class MainMenu extends javax.swing.JFrame {

	public MainMenu() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		btnNewGame = new javax.swing.JButton();
		btnScoreBoard = new javax.swing.JButton();
		btnAccount = new javax.swing.JButton();
		btnLogout = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(new java.awt.Dimension(366, 516));
		getContentPane().setLayout(new java.awt.FlowLayout());

		jPanel1.setPreferredSize(new java.awt.Dimension(366, 516));

		btnNewGame.setText("New Game");
		btnNewGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNewGameActionPerformed(evt);
			}
		});
		
		btnScoreBoard.setText("ScoreBoard");
		btnScoreBoard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnScoreBoardActionPerformed(evt);
			}
		});

		btnAccount.setText("Account");
		btnAccount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAccountActionPerformed(evt);
			}
		});

		btnLogout.setText("Logout");
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLogoutActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
		jLabel1.setText("Tic Tac Foe");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(82, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnScoreBoard, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 207,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel1))
								.addGap(77, 77, 77)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(104, 104, 104).addComponent(jLabel1)
						.addGap(69, 69, 69).addComponent(btnNewGame).addGap(18, 18, 18).addComponent(btnScoreBoard)
						.addGap(18, 18, 18).addComponent(btnAccount).addGap(18, 18, 18).addComponent(btnLogout)
						.addContainerGap(150, Short.MAX_VALUE)));

		getContentPane().add(jPanel1);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNewGameActionPerformed
		NewGame newGame = new NewGame();
		newGame.pack();
		newGame.setLocationRelativeTo(null);
		newGame.setVisible(true);

		this.dispose();
	}// GEN-LAST:event_btnNewGameActionPerformed

	private void btnScoreBoardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnScoreBoardActionPerformed
		ScoreBoard scoreBoard = new ScoreBoard();
		scoreBoard.pack();
		scoreBoard.setLocationRelativeTo(null);
		scoreBoard.setVisible(true);
		
		this.dispose();
	}// GEN-LAST:event_btnScoreBoardActionPerformed

	private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAccountActionPerformed
		Account account = new Account();
		account.pack();
		account.setLocationRelativeTo(null);
		account.setVisible(true);

		this.dispose();
	}// GEN-LAST:event_btnAccountActionPerformed

	private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoutActionPerformed
		Login loginForm = new Login();
		loginForm.pack();
		loginForm.setLocationRelativeTo(null);
		loginForm.setVisible(true);

		this.dispose();
	}// GEN-LAST:event_btnLogoutActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAccount;
	private javax.swing.JButton btnLogout;
	private javax.swing.JButton btnNewGame;
	private javax.swing.JButton btnScoreBoard;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables
}
