package game.gameBodies.squirrel;

import city.cs.engine.*;

/**
 * Collision listener that allows the squirrel to collect things.
 */
public class SquirrelPickup implements CollisionListener {
    private Squirrel squirrel;
    
    public SquirrelPickup(Squirrel squirrel) {
        this.squirrel = squirrel;
    }

    // Squirrel to collect acorn
    @Override
    public void collide(CollisionEvent e) {
       if (e.getReportingBody() instanceof SquirrelFood && e.getOtherBody() == squirrel) {
           squirrel.incrementAcornCount();
           e.getReportingBody().destroy();
       }

    }
    
}
