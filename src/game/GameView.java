package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import game.gameBodies.bird.Bird;
import game.gameBodies.bird.BirdFood;
import game.gameBodies.squirrel.Squirrel;
import org.jbox2d.common.Vec2;

/**
 * extended view with game bodies
 */
public class GameView extends UserView {
    Bird bird;
    Squirrel squirrel;
    
    private Image background;

    // Init the game with bodies and background
    public GameView(World world, Bird bird, Squirrel squirrel,  int width, int height) {
        super(world, width, height);
        this.bird = bird;
        this.squirrel = squirrel;
        this.background = new ImageIcon("data/background.jpg").getImage();
    }
    
    public void setNewLevel(World world, Bird bird, Squirrel squirrel) {
        setWorld(world);
        this.bird = bird;
        this.squirrel = squirrel;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
        // display instruction
        g.drawString("Squirrel: press W/A/D to move", 300,15);
        g.drawString("Bird: press up/left/right arrow", 300,30);
        g.drawString("Mission: Collect oranges and acorns", 300, 45);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        // code to display the current score
        // total number of oranges collected by the bird
        g.drawString("No. Oranges = " + bird.getOrangeCount(), 30, 15);
        // total number of oranges collected by the bird
        g.drawString("No. Acorns = " + squirrel.getAcornCount(), 30, 30);
    }


}
