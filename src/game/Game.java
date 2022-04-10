package game;

import city.cs.engine.SoundClip;
import game.gameBodies.bird.Bird;
import game.gameBodies.bird.BirdController;
import game.gameBodies.squirrel.SquirrelController;
import game.gameLevel.GameLevel;
import game.gameLevel.Level1;
import game.gameLevel.Level2;
import game.gameLevel.Level3;
import game.gameBodies.squirrel.Squirrel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;
    // Game level
    private int level;
    private BirdController birdController;
    private SquirrelController squirrelController;
    private SoundClip backgroundMusic;

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
    /** Initialise a new Game. */
    public Game() {
        // Game start at level 1
        level = 1;
        world = new Level1();
        // set background music for level 1 (initial level)
        setBackgroundMusic("data/sound/bg_music_l1.wav");
        world.Initialize(this);

        view = new GameView(world, world.getBird(), 500, 500);

        // The view frame called "A Java Game"
        final JFrame frame = new JFrame("A Java Game");

        // Add the control panel
        // Button: restart, pause, exit
        Container buttons = new GameControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);
        
        // Quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // Display world in the window
        frame.add(view);
        // Don't let the game window be resized
        frame.setResizable(false);
        // Size the game window to fit the world view
        frame.pack();
        // Make the window visible
        frame.setVisible(true);
        // Get keyboard focus
        frame.requestFocus();
        // Give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        // Set key event for bird and squirrel
        birdController = new BirdController(world.getBird());;
        squirrelController = new SquirrelController(world.getSquirrel());
        frame.addKeyListener(birdController);
        frame.addKeyListener(squirrelController);

        // start!
        world.start();
    }

    /** Get the current level */
    public int getNextLevel(){
        return level+1;
    }
    /** The player in the current level. */
    public Bird getPlayer() {
        return world.getBird();
    }
    
    public void pause() {
        world.stop();
    }
    
    public void restart() {
        world.start();
    }
    
    
    /** The second player - Squirrel in the current level */
    public Squirrel getPlayer2() {
        return world.getSquirrel();
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        Bird oldBird = world.getBird();
        if (level == 3) {
            System.exit(0);
        } 
        else {

            if (level == 1) {
                level++;
                // get a new world level 2
                world = new Level2();
                // set background music for level 2
                setBackgroundMusic("data/sound/bg_music_l2.wav");
            }else if (level == 2){
                level++;
                // get a new world level 3
                world = new Level3();
                // set background music for level 3
                setBackgroundMusic("data/sound/bg_music_l3.wav");
            }

            // fill it with bodies
            world.Initialize(this);
            // switch the keyboard control to the new player
            birdController.setBody(world.getBird());
            squirrelController.setBody(world.getSquirrel());
            world.getBird().setOrangeCount(oldBird.getOrangeCount());
            // show the new world in the view
            view.setWorld(world);
            view.setBird(world.getBird());
            world.start();
        }
    }

    public  void setBackgroundMusic(String soundLink){
        // background music for level 1 (initial level)
        try {
            backgroundMusic = new SoundClip(soundLink);
            // changes the volume to make the background music quieter
            backgroundMusic.setVolume(0.3);
            backgroundMusic.loop();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
}
