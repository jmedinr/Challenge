/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author juanm
 */
public class Players implements ActionListener {
    
    PlayerModel model;
    ViewQuestion view;
    

    public Players(PlayerModel model, ViewQuestion view) {
        this.model = model;
        this.view = view;
        this.view.nombreField.addActionListener(this);
        this.view.iniciarButton.addActionListener(this);
        this.view.salirButton1.addActionListener(this);
    }
    
    public void start() {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Iniciar Cuestionario":
                String name = this.view.nombreField.getText();
                int points = 0;
                int category = 1;
                {
                    try {
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
