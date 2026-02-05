package snakerunner.audio;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public class AudioPlayer {

    private static final String ERROR = "Error playing sound.";
    private static final String NOT_FOUND = "Sound not found.";
    private static final String STREAM = "stream: ";

    private static boolean soundEnable = true;

    public AudioPlayer(){} //Empty constructor

    public static void setSoundEnabled(boolean enable){
        soundEnable = enable;
    }

    public static boolean isSoundEnable() {
        return soundEnable;
    }

    public static void playSound(String fileName){

        if (!soundEnable) {
            return;
        }

        //Try-with-resources
        try ( InputStream sound = AudioPlayer.class.getResourceAsStream("/" + fileName);
              BufferedInputStream bstream = new BufferedInputStream(sound);
              AudioInputStream audioStream = AudioSystem.getAudioInputStream(bstream);
            ) {
                System.out.println(STREAM + sound);

                if (sound == null) {
                    System.out.println(NOT_FOUND);
                    return;
                }

                System.out.println(STREAM + bstream);

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    }
                });

            } catch (Exception e) {
                System.out.println(ERROR);
                e.printStackTrace();
        }
    }
}
