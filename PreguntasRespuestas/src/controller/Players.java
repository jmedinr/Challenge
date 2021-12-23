/*
 * This is the Controller for the inicial View.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author jmedinr
 */
public class Players implements ActionListener {
    
    PlayerModel model;
    ViewQuestion view;
    
    // Contructor
    public Players(PlayerModel model, ViewQuestion view) {
        this.model = model;
        this.view = view;
        this.view.nombreField.addActionListener(this);
        this.view.iniciarButton.addActionListener(this);
        this.view.salirButton1.addActionListener(this);
    }
    
    // Start View
    public void start() {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
    }
    
    //Action for Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Iniciar Cuestionario":
                String name = this.view.nombreField.getText();
                int points = 0;
                int category = 1;
                {
                    try {
                        //Register Player in BD
                        PlayerModel.registerPlayer(name,points,category);
                    } catch (SQLException ex) {
                        Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(view, "Inicio del Cuestionario");
                this.view.nombreField.setText("");
                ViewRound view = new ViewRound();
                QuestionModel model = new QuestionModel();
            {
                try {
                    new RoundController(view,model,category).start();
                } catch (SQLException ex) {
                    Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                this.view.setVisible(false);
                break;

            case "Salir":
                this.view.setVisible(false);
                break;
        }
    }
}
