package game.gameBodies;

import city.cs.engine.Shape;
import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Foods class with method to play sound when destroy().
 */
public class Foods extends DynamicBody {
    public Foods(World world, Shape shape) {
        super(world, shape);
    }

    private static SoundClip pickupSound;
    static {
        try {
            pickupSound = new SoundClip("data/sound/pickup_sound.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy() {
        pickupSound.play();
        super.destroy();
    }
}
