package game.gameLevel;

import city.cs.engine.*;
import game.gameBodies.door.Door;
import game.gameBodies.door.DoorListener;
import game.Game;
import game.gameBodies.bird.Bird;
import game.gameBodies.squirrel.Squirrel;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Bird bird;
    private Squirrel squirrel;
    
    public Bird getBird() {
        return bird;
    }
    
    public Squirrel getSquirrel() {
        return squirrel;
    }
    
    /**
     * Create the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void Initialize(Game game) {
        
        // Make a new game character: bird, squirrel, door
        bird = new Bird(this);
        bird.setPosition(startPosition());

        squirrel = new Squirrel(this);
        squirrel.setPosition(startPosition());

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

        // Basic platforms: ground and walls
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
            
    }
    
    /** Set initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** Set position for the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
