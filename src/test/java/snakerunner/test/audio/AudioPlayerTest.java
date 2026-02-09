package snakerunner.test.audio;

import org.junit.jupiter.api.Test;

import snakerunner.audio.AudioPlayer;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayerTest {

    private static final String EAT = "eat.wav";
    private static final String FILE_NOT_EXIST = "file_not_exist.wav";

    /* Test getters return true/false */
    @Test
    void SoundEnabledGettersTest() {
        AudioPlayer.setSoundEnabled(true);
        assertTrue(AudioPlayer.isSoundEnable());
        
        AudioPlayer.setSoundEnabled(false);
        assertFalse(AudioPlayer.isSoundEnable());
    }

    /* Test AudioPlayer playSound() */
    @Test
    void playSoundTest() {
        assertDoesNotThrow(() -> AudioPlayer.playSound(EAT));
    }

    /* Test AudioPlayer playSound() Exeption */
    @Test
    void playSoundExeptionTest(){
        assertDoesNotThrow(() -> AudioPlayer.playSound(FILE_NOT_EXIST));
    }

    /* Test AudioPlayer playSound() multiple sound */
    @Test
    void playSoundMultipleTest(){
        assertDoesNotThrow(() -> {
            AudioPlayer.playSound(EAT);
            AudioPlayer.playSound(EAT);
            AudioPlayer.playSound(EAT);
        });
    }

}
