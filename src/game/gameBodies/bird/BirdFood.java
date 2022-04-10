package game.gameBodies.bird;

import city.cs.engine.*;
import java.awt.Color;

/**
 * Bird food is an orange.
 */
public class BirdFood extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    
    public BirdFood(World world) {
        super(world, shape);
        setFillColor(Color.orange);
    }
}
