/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.*;
import model.*;
import view.*;

/**
 *
 * @author juanm
 */
public class Main {
    public static void main(String[] args) {
        ViewPreguntas vista = new ViewPreguntas();
        PreguntasModel modelo = new PreguntasModel ();
        
        Preguntas controlador = new Preguntas(modelo,vista);
        controlador.start();
    }
}
