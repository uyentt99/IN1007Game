package game.gameBodies.bird;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things (orange).
 */
public class BirdPickup implements CollisionListener {
    private Bird bird;
    
    public BirdPickup(Bird bird) {
        this.bird = bird;
    }

    // Bird collect orange
    @Override
    public void collide(CollisionEvent e) {
       if (e.getReportingBody() instanceof BirdFood && e.getOtherBody() == bird) {
           bird.incrementOrangeCount();
           e.getReportingBody().destroy();
       }
    }
    
}
