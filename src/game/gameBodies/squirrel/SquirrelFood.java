package game.gameBodies.squirrel;


import city.cs.engine.*;

/**
 * Squirrel Food is An acorn.
 */
public class SquirrelFood extends DynamicBody {
    private static final Shape shape = new PolygonShape
        (0.292f,-0.044f, -0.067f,-0.374f, -0.316f,0.158f, 0.06f,0.493f);
    
    private static final BodyImage acornImage = new BodyImage("data/acorn.png", 1.25f);
    
    public SquirrelFood(World world) {
        super(world, shape);
        addImage(acornImage);
    }
}
