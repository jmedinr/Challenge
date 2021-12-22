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
    public static ArrayList<QuestionE> dataQuestion = new ArrayList<QuestionE>();
    public static ArrayList<QuestionE> dataQuestionC = new ArrayList<QuestionE>();
    public static ArrayList<QuestionE> roundSelect = new ArrayList<QuestionE>();

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
        setInformation(dataQuestion,playerSelect,1);
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
        int max = 5;
        int min = 1;
        int range = max - min + 1;
        for(QuestionE  i : dataA) {
            if (i.getRound() == round) {
                roundSelect.add(i);
                }
            }
        int rand = (int)(Math.random() * range) + min;
        QuestionE value = roundSelect.get(rand-1);
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
                String questionC = this.view.QuestionPane.getText();
            {
                try {
                    dataQuestionC = getInformation();
                    playerSelectC = getPlayer();
                } catch (SQLException ex) {
                    Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                int index = dataQuestionC.indexOf(questionC);
                QuestionE dataEvaluated = dataQuestionC.get(index);
                String answer = dataEvaluated.getAnswer();
                if (categoryVal<5){
                    if(this.view.jRadioButton1.isSelected() && answer == "a"){
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (this.view.jRadioButton2.isSelected() && answer == "b"){
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (this.view.jRadioButton3.isSelected() && answer == "c"){
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (this.view.jRadioButton4.isSelected() && answer == "d"){
                        ViewCongratulations view = new ViewCongratulations();
                        PlayerModel model = new PlayerModel();
                        try {
                            new CongratulationController(view,model,categoryVal).start();
                        } catch (SQLException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RoundController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else{

                    }
                }else if (categoryVal==5){
                   
                    this.view.setVisible(false);
                }

            
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
                new RoundController(view,model).start();
                this.view.setVisible(false);
                break;
            case "Salir":
                this.view.setVisible(false);
                break;
        }
    }
    
}
