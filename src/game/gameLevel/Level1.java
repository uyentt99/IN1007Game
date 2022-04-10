package game.gameLevel;

import city.cs.engine.*;
import game.gameBodies.bird.BirdPickup;
import game.Game;
import game.gameBodies.bird.BirdFood;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    public static final int NUM_ORANGES = 5;
    public static final int NUM_ACORNS = 0;
    /**
     * Populate the world.
     */
    @Override
    public void Initialize(Game game) {
        super.Initialize(game);
        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));

        // Spawn oranges and acorns in the game world
        for (int i = 0; i < 7; i++) {
            Body orange = new BirdFood(this);
            orange.setPosition(new Vec2(i*2-10, 10));
            orange.addCollisionListener(new BirdPickup(getBird()));
        }
    }

    
    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getBird().getOrangeCount() >= NUM_ORANGES && getSquirrel().getAcornCount() >= NUM_ACORNS;
    }

}
