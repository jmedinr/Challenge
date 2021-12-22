/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.RoundController.dataQuestion;
import static controller.RoundController.playerSelect;
import java.awt.Color;
import java.sql.SQLException;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class CongratulationController {
    
    ViewCongratulations view;
    PlayerModel model;
    int categoryVal;

    public CongratulationController(ViewCongratulations view, PlayerModel model, int categoryVal) {
        this.view = view;
        this.model = model;
        this.categoryVal = categoryVal;
    }
    
    public void start() throws SQLException, ClassNotFoundException {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
    }
}
