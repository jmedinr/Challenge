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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class RoundController implements ActionListener  {
    
    ViewRound view;
    QuestionModel model;
    int categoryVal;
    
    public static ArrayList<PlayerE> player = new ArrayList<PlayerE>();
    public static ArrayList<PlayerE> playerSelect = new ArrayList<PlayerE>();
    public static ArrayList<PlayerE> playerSelectC = new ArrayList<PlayerE>();
    public static ArrayList<QuestionE> data = new ArrayList<QuestionE>();
    public QuestionE value;
    public static ArrayList<QuestionE> dataQuestion = new ArrayList<QuestionE>();
    public static ArrayList<QuestionE> dataQuestionC = new ArrayList<QuestionE>();
    public static ArrayList<QuestionE> roundSelect = new ArrayList<QuestionE>();
    public int rand;
    public int point;

    public RoundController(ViewRound view, QuestionModel model,int categoryVal) {
        this.view = view;
        this.model = model;
        this.categoryVal = categoryVal;
        this.view.ContinueButton.addActionListener(this);
        this.view.FinishButton.addActionListener(this);
        this.view.jRadioButton1.addActionListener(this);
        this.view.jRadioButton2.addActionListener(this);
        this.view.jRadioButton3.addActionListener(this);
        this.view.jRadioButton4.addActionListener(this);
    }
    
    public void start() throws SQLException, ClassNotFoundException {
        this.view.setVisible(true);
        this.view.getContentPane().setBackground(Color.WHITE);
        this.view.setLocationRelativeTo(null);
        dataQuestion = getInformation();
        playerSelect = getPlayer();
        setInformation(dataQuestion,playerSelect,categoryVal);
    }
    
    public ArrayList<QuestionE> getInformation() throws SQLException, ClassNotFoundException{
        data = QuestionModel.getQuestions();
        return data;
    }
    
    public ArrayList<PlayerE> getPlayer() throws SQLException, ClassNotFoundException{
        player = PlayerModel.getUser();
        return player;
    }
    
    public void setInformation(ArrayList<QuestionE> dataA, ArrayList<PlayerE> dataB, int round){
        switch (round){
            case 1:{
                int max = 5;
                int min = 1;
                int range = max - min + 1;
                rand = (int)(Math.random() * range) + min;
                value = dataA.get(rand-1);
                break;
            }
            case 2:{
                int max = 10;
                int min = 6;
                int range = max - min + 1;
                rand = (int)(Math.random() * range) + min;
                value = dataA.get(rand-1);
                break;
            }
            case 3:{
                int max = 15;
                int min = 11;
                int range = max - min + 1;
                rand = (int)(Math.random() * range) + min;
                value = dataA.get(rand-1);
                break;
            }
            case 4:{
                int max = 20;
                int min = 16;
                int range = max - min + 1;
                rand = (int)(Math.random() * range) + min;
                value = dataA.get(rand-1);
                break;
            }
            case 5:{
                int max = 25;
                int min = 21;
                int range = max - min + 1;
                rand = (int)(Math.random() * range) + min;
                value = dataA.get(rand-1);
                break;
            }
        }
        this.view.RoundPane.setText(String.valueOf(value.getRound()));
        this.view.PrizePane.setText(String.valueOf(value.getPrize()));
        this.view.QuestionPane.setText(String.valueOf(value.getQuestion()));
        this.view.AnswerPane1.setText(String.valueOf(value.getAnswerA()));
        this.view.AnswerPane2.setText(String.valueOf(value.getAnswerB()));
        this.view.AnswerPane3.setText(String.valueOf(value.getAnswerC()));
        this.view.AnswerPane4.setText(String.valueOf(value.getAnswerD()));
        int sizePlayer = dataB.size();
        PlayerE playerView = dataB.get(sizePlayer-1);
        this.view.PointsPane.setText(String.valueOf(playerView.getPoint()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
            case "Continuar":
                String answer = value.getAnswer();
                int prize = value.getPrize();
                int sizePlayer = playerSelect.size();
                PlayerE playerC = playerSelect.get(sizePlayer-1);
                int idplayers = playerC.getId();
                switch (categoryVal){
                    case 1:{
                        point = 10;
                        break;
                    }
                    case 2:{
                        point = 30;
                        break;
                    }
                    case 3:{
                        point = 60;
                        break;
                    }
                    case 4:{
                        point = 100;
                        break;
                    }
                    case 5:{
                        point = 150;
                        break;
                    }
                }
                if (categoryVal<5){
                    if(this.view.jRadioButton1.isSelected() && "a".equals(answer)){
                        try {
                            PlayerModel.UpdatePlayer(point, categoryVal+1,idplayers);
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.view.setVisible(false);
                    } else if (this.view.jRadioButton2.isSelected() && "b".equals(answer)){
                        try {
                            PlayerModel.UpdatePlayer(point, categoryVal+1,idplayers);
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.view.setVisible(false);
                    } else if (this.view.jRadioButton3.isSelected() && "c".equals(answer)){
                        try {
                            PlayerModel.UpdatePlayer(point, categoryVal+1,idplayers);
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.view.setVisible(false);
                    } else if (this.view.jRadioButton4.isSelected() && "d".equals(answer)){
                        try {
                            PlayerModel.UpdatePlayer(point, categoryVal+1,idplayers);
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.view.setVisible(false);
                    } else{
                        ViewError view = new ViewError();
                        PlayerModel model = new PlayerModel();
                        try {
                            new ErrorController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.view.setVisible(false);
                    }
                }else if (categoryVal==5){
                    try {
                        PlayerModel.UpdatePlayer(point, categoryVal,idplayers);
                    } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewWinner view = new ViewWinner();
                    PlayerModel model = new PlayerModel();
                    try {
                        new WinnerController(view,model,categoryVal).start();
                    } catch (SQLException ex) {
                        Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view.setVisible(false);
                }
                 break;
            case "Retirarse":
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
