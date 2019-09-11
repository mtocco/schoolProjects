/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import javax.swing.SwingUtilities;


public class TicTacFoe {

    public static void main(String[] args) throws Exception {
       
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                Login frame = new Login();
                frame.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
            }
        });
    }
}
