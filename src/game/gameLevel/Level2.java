package game.gameLevel;

import city.cs.engine.*;
import game.*;
import game.gameBodies.squirrel.SquirrelFood;
import game.gameBodies.bird.BirdFood;
import game.gameBodies.bird.BirdPickup;
import game.gameBodies.squirrel.Squirrel;
import game.gameBodies.squirrel.SquirrelPickup;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_ORANGES = 7;
    private static final int NUM_ACORNS = 3;
    
    /**
     * Populate the world.
     */
    @Override
    public void Initialize(Game game) {
        super.Initialize(game);

        // Wake some current level platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(7, 7.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(6, -3.5f));

        // Spawn oranges and acorns in the game world
        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new BirdFood(this);
            orange.setPosition(new Vec2(i * 2 - 6, 10));
            orange.addCollisionListener(new BirdPickup(getBird()));
        }
        for (int i = 0; i < NUM_ACORNS; i++) {
            Body acorn = new SquirrelFood(this);
            acorn.setPosition(new Vec2(i*2-8, 8));
            acorn.addCollisionListener(new SquirrelPickup(getSquirrel()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(9.5f, 9.5f);
    }

    @Override
    public boolean isCompleted() {
        return getBird().getOrangeCount() >= NUM_ORANGES;
    }
    
    
}
