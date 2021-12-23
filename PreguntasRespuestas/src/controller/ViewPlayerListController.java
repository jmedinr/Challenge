/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Main.Main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class ViewPlayerListController implements ActionListener {
    
    ViewPlayerList view;
    PlayerModel model;
    
    public static ArrayList<PlayerE> players = new ArrayList<PlayerE>();
    public static ArrayList<PlayerE> playerList = new ArrayList<PlayerE>();

    public ViewPlayerListController(ViewPlayerList view, PlayerModel model) {
        this.view = view;
        this.model = model;
        this.view.ReturnPlayButton.addActionListener(this);
        this.view.SalirButton2.addActionListener(this);
    }
    
    public void start() throws SQLException, ClassNotFoundException {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
        playerList = getPlayer();
        setTable(playerList);
    }
    
    public ArrayList<PlayerE> getPlayer() throws SQLException, ClassNotFoundException{
        players = PlayerModel.getUser();
        return players;
    }
    
    public void setTable(ArrayList<PlayerE> data){
        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Jugador", "Puntos"});
        ArrayList<PlayerE> playersArray = data;
        for (PlayerE listObjet1 : playersArray) {
            String[] register = new String[2];
            register[0] = "" + listObjet1.getName();
            register[1] = "" + listObjet1.getPoint();
            modelo.addRow(register);
        }
        view.PlayerTable.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Volver a Jugar":    
                ViewQuestion view = new ViewQuestion();
                PlayerModel model = new PlayerModel();
                new Players(model,view).start();
                this.view.setVisible(false);
            case "Salir":
                this.view.setVisible(false);
                break;
        }
    }
    

}
