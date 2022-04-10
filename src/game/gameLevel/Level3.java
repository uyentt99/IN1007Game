package game.gameLevel;

import city.cs.engine.*;
import java.awt.Color;

import game.gameBodies.bird.BirdPickup;
import game.Game;
import game.gameBodies.bird.BirdFood;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_ORANGES = 4;

    /**
     * Populate the world.
     */
    @Override
    public void Initialize(Game game) {
        super.Initialize(game);

        // Make some current level  platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        platform1.setFillColor(Color.GREEN);

        // Spawn oranges and acorns in the game world
        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new BirdFood(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new BirdPickup(getBird()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getBird().getOrangeCount() == NUM_ORANGES;
    }
}
