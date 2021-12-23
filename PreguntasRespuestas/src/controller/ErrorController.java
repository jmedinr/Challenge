/*
* This is the controller for when is wrong
 */
package controller;

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
 * @author jmedinr
 */
public class ErrorController implements ActionListener{
    
    ViewError view;
    PlayerModel model;
    int categoryVal;
    
    public static ArrayList<PlayerE> player = new ArrayList<PlayerE>();
    public static ArrayList<PlayerE> playerSelect = new ArrayList<PlayerE>();
    
    // Contructor
    public ErrorController(ViewError view, PlayerModel model, int categoryVal) {
        this.view = view;
        this.model = model;
        this.categoryVal = categoryVal;
        this.view.ExitButton.addActionListener(this);
    }
    
    // Start View
    public void start() throws SQLException, ClassNotFoundException {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
        playerSelect = getPlayer();
        setInformation(playerSelect);
    }
    
    // Method for obtain Playeers of BD
    public ArrayList<PlayerE> getPlayer() throws SQLException, ClassNotFoundException{
        player = PlayerModel.getUser();
        return player;
    }
    
    // Method for setting View Items
    public void setInformation(ArrayList<PlayerE> data){
        int sizePlayer = data.size();
        PlayerE playerC = data.get(sizePlayer-1);
        view.PointPane.setText(String.valueOf(playerC.getPoint()));
    }
    
    //Action for Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salir":
                ViewPlayerList view = new ViewPlayerList();
                PlayerModel model = new PlayerModel();
                {
                    try {
                        new ViewPlayerListController(view,model).start();
                    } catch (SQLException ex) {
                        Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.view.setVisible(false);
                break;
        }
    }
}
