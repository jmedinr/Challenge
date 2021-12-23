/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.RoundController.dataQuestion;
import static controller.RoundController.playerSelect;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class CongratulationController implements ActionListener {
    
    ViewCongratulations view;
    PlayerModel model;
    int categoryVal;
    
    public static ArrayList<PlayerE> player = new ArrayList<PlayerE>();
    public static ArrayList<PlayerE> playerSelect = new ArrayList<PlayerE>();

    public CongratulationController(ViewCongratulations view, PlayerModel model, int categoryVal) {
        this.view = view;
        this.model = model;
        this.categoryVal = categoryVal;
        this.view.nextButton.addActionListener(this);
    }
    
    public void start() throws SQLException, ClassNotFoundException {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
        playerSelect = getPlayer();
        setInformation(playerSelect);
    }
    
    public ArrayList<PlayerE> getPlayer() throws SQLException, ClassNotFoundException{
        player = PlayerModel.getUser();
        return player;
    }
    
    public void setInformation(ArrayList<PlayerE> data){
        int sizePlayer = data.size();
        PlayerE playerC = data.get(sizePlayer-1);
        view.PointPane.setText(String.valueOf(playerC.getPoint()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Siguiente Ronda":
                ViewRound view = new ViewRound();
                QuestionModel model = new QuestionModel();
            {
                try {
                    new RoundController(view,model,categoryVal+1).start();
                } catch (SQLException ex) {
                    Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                this.view.setVisible(false);
                break;
        }
    }
}
