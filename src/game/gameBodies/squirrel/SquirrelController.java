package game.gameBodies.squirrel;

import city.cs.engine.Walker;
import game.gameBodies.actionController;

import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class SquirrelController extends actionController {

    public SquirrelController(Squirrel body) {
        super(body, KeyEvent.VK_W,KeyEvent.VK_A,KeyEvent.VK_D);
    }
}
