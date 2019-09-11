/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

    databaseHandler handler = null;

    public Registration() {
        initComponents();
        handler = databaseHandler.getInst();
        setAstVisFalse();
    }

    private void setAstVisFalse() {
        starFName.setVisible(false);
        starLName.setVisible(false);
        starPass1.setVisible(false);
        starPass2.setVisible(false);
        starEmail.setVisible(false);
    }

    private boolean markEmptyField() {
        boolean isEmpty = false;

        if (fNameField.getText().isEmpty()) {

            starFName.setVisible(true);
            isEmpty = true;
        }
        if (lNameField.getText().isEmpty()) {
            isEmpty = true;
            starLName.setVisible(true);
        }
        if (String.valueOf(passField1.getPassword()).isEmpty()) {
            isEmpty = true;
            starPass1.setVisible(true);
        }
        if (String.valueOf(passField2.getPassword()).isEmpty()) {
            isEmpty = true;
            starPass2.setVisible(true);
        }
        if (eMailField.getText().isEmpty()) {
            isEmpty = true;
            starFName.setVisible(true);
        }
        return isEmpty;
    }

    private boolean testPassMatch() {
        return (String.valueOf(passField1.getPassword()).equals(String.valueOf(passField2.getPassword())));
    }

    public boolean testPassRequirements(String password) {
        boolean containsNums = false;
        
        if (password.contains(String.valueOf(1)) || password.contains(String.valueOf(2)) 
                || password.contains(String.valueOf(3))|| password.contains(String.valueOf(4))
                || password.contains(String.valueOf(5))|| password.contains(String.valueOf(6))
                || password.contains(String.valueOf(7))|| password.contains(String.valueOf(8))
                || password.contains(String.valueOf(9))|| password.contains(String.valueOf(0))){
            
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

        label3 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        fNameField = new javax.swing.JTextField();
        lNameField = new javax.swing.JTextField();
        eMailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passField1 = new javax.swing.JPasswordField();
        passField2 = new javax.swing.JPasswordField();
        starFName = new java.awt.Label();
        starPass1 = new java.awt.Label();
        starPass2 = new java.awt.Label();
        starLName = new java.awt.Label();
        starEmail = new java.awt.Label();

        label3.setForeground(new java.awt.Color(255, 51, 51));
        label3.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(366, 516));
        setSize(new java.awt.Dimension(366, 516));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(366, 516));
        jPanel1.setSize(new java.awt.Dimension(366, 516));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("First Name:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Last Name:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Email Address:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Password:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Confirm Password:");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        fNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fNameFieldFocusLost(evt);
            }
        });
        fNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameFieldActionPerformed(evt);
            }
        });

        lNameField.setToolTipText("");
        lNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameFieldActionPerformed(evt);
            }
        });

        eMailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMailFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Register");

        passField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passField1FocusLost(evt);
            }
        });
        passField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passField1ActionPerformed(evt);
            }
        });

        passField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passField2FocusLost(evt);
            }
        });
        passField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passField2ActionPerformed(evt);
            }
        });

        starFName.setForeground(new java.awt.Color(255, 51, 51));
        starFName.setMinimumSize(new java.awt.Dimension(10, 18));
        starFName.setName(""); // NOI18N
        starFName.setText("*");

        starPass1.setForeground(new java.awt.Color(255, 51, 51));
        starPass1.setPreferredSize(new java.awt.Dimension(10, 18));
        starPass1.setText("*");

        starPass2.setForeground(new java.awt.Color(255, 51, 51));
        starPass2.setPreferredSize(new java.awt.Dimension(10, 18));
        starPass2.setText("*");

        starLName.setForeground(new java.awt.Color(255, 51, 51));
        starLName.setPreferredSize(new java.awt.Dimension(10, 18));
        starLName.setSize(new java.awt.Dimension(10, 20));
        starLName.setText("*");

        starEmail.setForeground(new java.awt.Color(255, 51, 51));
        starEmail.setPreferredSize(new java.awt.Dimension(10, 18));
        starEmail.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lNameField)
                                    .addComponent(eMailField)
                                    .addComponent(passField1)
                                    .addComponent(passField2)
                                    .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(starPass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(starEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(starLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(starPass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(starFName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBack, btnSignUp, eMailField, jLabel1, jLabel2, jLabel3, jLabel5, jLabel6, lNameField});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {starEmail, starLName, starPass1, starPass2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(starFName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(eMailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(starLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(starEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(starPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(starPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSignUp))
                .addGap(93, 93, 93))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {starLName, starPass1, starPass2});

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passField2ActionPerformed

    }//GEN-LAST:event_passField2ActionPerformed

    private void passField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passField2FocusLost

    }//GEN-LAST:event_passField2FocusLost

    private void passField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passField2FocusGained
        if (passField2.getForeground() == Color.gray) {
            passField2.setText("");
            passField2.setEchoChar('*');
            passField2.setForeground(null);
        }
    }//GEN-LAST:event_passField2FocusGained

    private void passField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passField1ActionPerformed

    }//GEN-LAST:event_passField1ActionPerformed

    private void passField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passField1FocusLost

    }//GEN-LAST:event_passField1FocusLost

    private void passField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passField1FocusGained
        if (passField1.getForeground() == Color.gray) {
            passField1.setText("");
            passField1.setEchoChar('*');
            passField1.setForeground(null);
        }
    }//GEN-LAST:event_passField1FocusGained

    private void eMailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMailFieldActionPerformed

    }//GEN-LAST:event_eMailFieldActionPerformed

    private void lNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameFieldActionPerformed

    }//GEN-LAST:event_lNameFieldActionPerformed

    private void fNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameFieldActionPerformed

    }//GEN-LAST:event_fNameFieldActionPerformed

    private void fNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameFieldFocusLost

    }//GEN-LAST:event_fNameFieldFocusLost

    private void fNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameFieldFocusGained

    }//GEN-LAST:event_fNameFieldFocusGained

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed

        System.out.println(emailChecker.isValid(eMailField.getText()));

        if (!emailChecker.isValid(eMailField.getText())) {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid Email", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (markEmptyField()) {
            JOptionPane.showMessageDialog(null, "Please Enter All Fields", "Error", JOptionPane.ERROR_MESSAGE);

        }

        if (!testPassMatch()) {
            JOptionPane.showMessageDialog(null, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (!testPassRequirements(String.valueOf(passField1.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Password Must Be 8 Characters In Length and Contain Letters and Numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (!markEmptyField() && testPassMatch() && emailChecker.isValid(eMailField.getText()) && testPassRequirements(String.valueOf(passField1.getPassword()))) {

            if (handler.insertUser(fNameField.getText(), lNameField.getText(), eMailField.getText(), String.valueOf(passField1.getPassword()))) {
                JOptionPane.showMessageDialog(null, "User Successfully Registered", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Email already registered", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Login loginForm = new Login();
        loginForm.pack();
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JTextField eMailField;
    private javax.swing.JTextField fNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lNameField;
    private java.awt.Label label3;
    private javax.swing.JPasswordField passField1;
    private javax.swing.JPasswordField passField2;
    private java.awt.Label starEmail;
    private java.awt.Label starFName;
    private java.awt.Label starLName;
    private java.awt.Label starPass1;
    private java.awt.Label starPass2;
    // End of variables declaration//GEN-END:variables
}
