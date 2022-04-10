package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import game.gameBodies.bird.Bird;

/**
 * extended view with game bodies
 */
public class GameView extends UserView {
    Bird bird;
    
    private Image background;

    // Init the game with bodies and background
    public GameView(World world, Bird bird, int width, int height) {
        super(world, width, height);
        this.bird = bird;
        this.background = new ImageIcon("data/background.jpg").getImage();
    }
    
    public void setBird(Bird bird) {
        this.bird = bird;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        // code to display the current score
        // total number of oranges collected by the bird
        g.drawString("Score= " + bird.getOrangeCount(), 75, 105);
    }


}
