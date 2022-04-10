package game.gameBodies.door;

import city.cs.engine.*;
import game.Game;
import game.gameBodies.bird.Bird;
import game.gameBodies.squirrel.Squirrel;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        System.out.println("Collided with door");
        Bird player = game.getPlayer();
        Squirrel player2 = game.getPlayer2();

        // Go to next level if player get the door and current level completed
        if ((e.getOtherBody() == player || e.getOtherBody() == player2) && game.isCurrentLevelCompleted()) {
            System.out.println("Going to level " + game.getNextLevel());
            game.goNextLevel();
        }
    }
}
