package snakerunner.audio;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent.Type;

public class AudioPlayer {

    private static final String ERROR = "Error playing sound.";
    private static boolean soundEnable = true;

    public AudioPlayer(){} //Empty constructor

    public static void setSoundEnabled(final boolean enable) {
        soundEnable = enable;
    }

    public static boolean isSoundEnable() { 
        return soundEnable;
    }

    public static void playSound(final String fileName) {

        if (!soundEnable) {
            return;
        }

        //Try-with-resources
        try ( InputStream sound = AudioPlayer.class.getResourceAsStream("/" + fileName);
              BufferedInputStream bstream = new BufferedInputStream(sound);
              AudioInputStream audioStream = AudioSystem.getAudioInputStream(bstream);
            ) {
                if (sound == null) {
                    return;
                }

                final Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                clip.addLineListener(event -> {
                    if (event.getType() == Type.STOP) {
                    clip.close();
                    }
                });

            } catch (Exception e) {
                System.out.println(ERROR);
                e.printStackTrace();
        }
    }
}
