/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {

    databaseHandler handler = null;
    private static int userID = -1;

    public ChangePassword() {
        initComponents();
        handler = databaseHandler.getInst();
    }

    private boolean testPassMatch() {
        return (String.valueOf(fieldNewPass.getPassword()).equals(String.valueOf(fieldConfirmNewPass.getPassword())));
    }

    public boolean testPassRequirements(String password) {
        boolean containsNums = false;

        if (password.contains(String.valueOf(1)) || password.contains(String.valueOf(2))
                || password.contains(String.valueOf(3)) || password.contains(String.valueOf(4))
                || password.contains(String.valueOf(5)) || password.contains(String.valueOf(6))
                || password.contains(String.valueOf(7)) || password.contains(String.valueOf(8))
                || password.contains(String.valueOf(9)) || password.contains(String.valueOf(0))) {

            containsNums = true;
        }

        if (password.length() >= 8 && containsNums) {
            return true;
        } else {

        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblChangePass1 = new javax.swing.JLabel();
        lblChangePass2 = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        fieldConfirmNewPass = new javax.swing.JPasswordField();
        fieldNewPass = new javax.swing.JPasswordField();
        lblOldPass = new javax.swing.JLabel();
        lblNewPass = new javax.swing.JLabel();
        lblConfirmNewPass = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        emailField1 = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        fieldOldPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(316, 566));
        getContentPane().setLayout(new java.awt.FlowLayout());

        lblChangePass1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblChangePass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePass1.setText("Change");
        lblChangePass1.setToolTipText("");

        lblChangePass2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblChangePass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePass2.setText("Password");
        lblChangePass2.setToolTipText("");

        btnChangePass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnChangePass.setText("Change Password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        fieldConfirmNewPass.setName(""); // NOI18N
        fieldConfirmNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConfirmNewPassActionPerformed(evt);
            }
        });

        lblOldPass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblOldPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOldPass.setText("Old Password:");

        lblNewPass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblNewPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNewPass.setText("New Password:");

        lblConfirmNewPass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblConfirmNewPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConfirmNewPass.setText("Confirm New Password:");

        btnBack.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        emailField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailField1ActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        fieldOldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldOldPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblChangePass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChangePass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailField1)
                            .addComponent(fieldNewPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(fieldOldPass)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblConfirmNewPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldConfirmNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblChangePass1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChangePass2)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldPass)
                    .addComponent(fieldOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPass))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldConfirmNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmNewPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnChangePass)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(116, 116, 116))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed



        if (testPassMatch()) {
            if (testPassRequirements(String.valueOf(fieldNewPass.getPassword()))) {
            if ((userID = handler.verifyCredentials(emailField1.getText(), String.valueOf(fieldOldPass.getPassword()))) > 0) {
                handler.changePassword(emailField1.getText(), String.valueOf(fieldOldPass.getPassword()), String.valueOf(fieldNewPass.getPassword()));
                JOptionPane.showMessageDialog(null, "Password Successfully Changed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Email Address or Old Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            } else {
                JOptionPane.showMessageDialog(null, "Password Must Be 8 Characters In Length and Contain Letters and Numbers", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenu mainMenu = new MainMenu();
        mainMenu.pack();
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void fieldConfirmNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldConfirmNewPassActionPerformed

    }//GEN-LAST:event_fieldConfirmNewPassActionPerformed

    private void emailField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailField1ActionPerformed

    }//GEN-LAST:event_emailField1ActionPerformed

    private void fieldOldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldOldPassActionPerformed

    }//GEN-LAST:event_fieldOldPassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JTextField emailField1;
    private javax.swing.JPasswordField fieldConfirmNewPass;
    private javax.swing.JPasswordField fieldNewPass;
    private javax.swing.JPasswordField fieldOldPass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChangePass1;
    private javax.swing.JLabel lblChangePass2;
    private javax.swing.JLabel lblConfirmNewPass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblOldPass;
    // End of variables declaration//GEN-END:variables
}
