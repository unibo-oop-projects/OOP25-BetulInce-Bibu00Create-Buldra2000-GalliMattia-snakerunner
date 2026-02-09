package snakerunner.audio;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent.Type;

public final class AudioPlayer {

    private static boolean soundEnable = true;

    private AudioPlayer(){} //Empty constructor

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

        try {
            final InputStream sound = AudioPlayer.class.getResourceAsStream("/" + fileName);
            final byte[] audioData = sound.readAllBytes();
            final ByteArrayInputStream byteStream = new ByteArrayInputStream(audioData);
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(byteStream);

            final Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            clip.addLineListener(event -> {
               if (event.getType() == Type.STOP) {
                    clip.close();
                    try {
                        audioStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
