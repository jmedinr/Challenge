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
        ViewQuestion view = new ViewQuestion();
        PlayerModel model = new PlayerModel();
        Players play = new Players(model,view);
        play.start();
    }
}
