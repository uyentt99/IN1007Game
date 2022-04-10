package game.gameBodies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class actionController extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 4;
    
    private Walker body;
    private int jumpKey;
    private int righKey;
    private int leftKey;

    /**
     * New action controller for bodies with jump, right move lef move action
     * @param body  body with action
     * @param jumpKey jump key
     * @param righKey right key
     * @param leftKey left key
     */
    public actionController(Walker body, int jumpKey, int leftKey, int righKey) {
        this.body = body;
        this.jumpKey = jumpKey;
        this.righKey = righKey;
        this.leftKey = leftKey;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            // Press q to  quit
            System.exit(0);//
        } else if (code == jumpKey) {
            // Press jump key to  jump
            Vec2 v = body.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == leftKey) {
            // Press left key to move to left
            body.startWalking(- WALKING_SPEED);
        } else if (code == righKey) {
            // Press right key to move to right
            body.startWalking(WALKING_SPEED);
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    public void setBody(Walker body) {
        this.body = body;
    }
}
