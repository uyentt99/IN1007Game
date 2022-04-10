package game.gameBodies.bird;

import city.cs.engine.*;
import game.gameBodies.actionController;

import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class BirdController extends actionController {

    public BirdController(Bird body) {
        super(body, KeyEvent.VK_UP,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);
    }
}
