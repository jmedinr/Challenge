
package Main;

import controller.*;
import model.*;
import view.*;

/**
 *
 * @author jmedinr
 * This is the Main of the Project. Here the Players.java is initialized
 */
public class Main {
    public static void main(String[] args) {
        ViewQuestion view = new ViewQuestion();
        PlayerModel model = new PlayerModel();
        Players play = new Players(model,view);
        play.start();
    }
}
