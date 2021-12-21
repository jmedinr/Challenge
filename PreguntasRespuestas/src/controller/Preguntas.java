/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class Preguntas implements ActionListener {

    private PreguntasModel modelo;
    private ViewPreguntas vista;

    public Preguntas(PreguntasModel modelo, ViewPreguntas vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
     public void start() {
        this.vista.setVisible(true);
        this.vista.getContentPane().setBackground(Color.WHITE);
        this.vista.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
